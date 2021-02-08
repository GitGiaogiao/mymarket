package com.yss.market.web;

import com.yss.market.Pojo.user1;
import com.yss.market.service.UserService;
import com.yss.market.service.serviceimpl.UserServiceimpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class user1Servlet extends BaseAbstractSevrlet {
   private UserService userServiceimpl=new UserServiceimpl();
    /**
     *登录功能部分
     */
    @SuppressWarnings("unused")
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        user1 user1=userServiceimpl.getUser(username,password);
        //如果账号密码均正确，那么跳转到登陆成功的界面
        if(userServiceimpl.login(username,password)!=null)
        {
            /////如果登录成功那么将用户Bean放入session域中
            req.getSession().setAttribute("user1",user1);
            System.out.println("用户["+username+"]登录成功!");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
        else
        {
            //如果不正确那么打印登录失败并且跳转到登录界面
            System.out.println("账号和密码不正确！请重新输入！！");
            req.setAttribute("msg","账号和密码不正确！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
    }


    //注册功能部分
    @SuppressWarnings("unused")
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ////获取服务器的验证码
        String token=(String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        ////删除session中的验证码，防止表单重复提交数据
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        ////获取客户端的信息
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String code=req.getParameter("code");
        String phone=req.getParameter("phone");

        ///判断验证码是否正确
        if(token!=null&&token.equalsIgnoreCase(code))
        {
            //判断用户名是否存在
            if(userServiceimpl.existUsername(username)==null)
            {
                ///当用户名不存在的时候就可以进行判断邮箱是否存在
                if(userServiceimpl.existEmail(email)==null)
                {
                    if(userServiceimpl.existPhone(phone)==null) {
                        ////当用户名邮箱手机号都不存在并且验证码正确就可以进行注册操作啦
                        userServiceimpl.register(new user1(username, password, email, null, phone));
                        System.out.println("注册成功!");
                        req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
                    }
                    else {
                        System.out.println("手机号已存在！");
                        req.setAttribute("msg","手机号已存在！");
                        req.setAttribute("phone",phone);
                        req.setAttribute("email",email);
                        req.setAttribute("username",username);
                        req.setAttribute("code",code);
                        req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
                    }
                }
                else {
                    System.out.println("邮箱已存在！");
                    req.setAttribute("msg","邮箱已存在！");
                    req.setAttribute("email",email);
                    req.setAttribute("username",username);
                    req.setAttribute("code",code);
                    req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
                }
            }
            else{
                System.out.println("用户名已存在！");
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("email",email);
                req.setAttribute("username",username);
                req.setAttribute("code",code);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
                }
        }
        else
        {
            System.out.println("验证码["+code+"]不正确！");
            req.setAttribute("msg","验证码不正确！");
            req.setAttribute("email",email);
            req.setAttribute("username",username);
            req.setAttribute("code",code);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
    @SuppressWarnings("unused")
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        ////去掉session域中的数据
        req.getSession().invalidate();
        ////重定向到首页
        resp.sendRedirect("/index.jsp");
    }
}
