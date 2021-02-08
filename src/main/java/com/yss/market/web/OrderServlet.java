package com.yss.market.web;

import com.yss.market.Pojo.Cart;
import com.yss.market.Pojo.Order;
import com.yss.market.Pojo.orderItem;
import com.yss.market.Pojo.user1;
import com.yss.market.service.OrderService;
import com.yss.market.service.serviceimpl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseAbstractSevrlet {

    private OrderService orderService = new OrderServiceImpl();


    // 生成订单
    @SuppressWarnings("unused")
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        user1 loginUser = (user1) req.getSession().getAttribute("user1");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        String  userId = loginUser.getUsername();
        ////调用orderService.createOrder(Cart,Userid);生成订单
        String orderId = orderService.createOrder(cart, userId);
       if(orderId!=null)
       {
           req.getSession().setAttribute("orderId",orderId);
           resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
       }
       else
       {
           req.setAttribute("msg","请输入正确的商品数量！");
           resp.sendRedirect(req.getContextPath()+"/pages/cart/cart.jsp");
       }
    }

    // 生成订单
    @SuppressWarnings("unused")
    protected void infOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /// 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        user1 loginUser = (user1) req.getSession().getAttribute("user1");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        String  userId = loginUser.getUsername();
        ////调用orderService.createOrder(Cart,Userid);生成订单
        ////将order信息和orderItem信息放入session中
        Order order=orderService.queryOrder(userId);
        List<orderItem> list=orderService.queryOrderItem(order.getOrderId());
        req.getSession().setAttribute("orderItemInf",list);
        req.getSession().setAttribute("orderInf",order);
        resp.sendRedirect(req.getContextPath()+"/pages/order/order.jsp");
    }

}
