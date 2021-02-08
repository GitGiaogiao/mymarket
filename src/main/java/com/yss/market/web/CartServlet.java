package com.yss.market.web;

import com.yss.market.Pojo.Cart;
import com.yss.market.Pojo.CartItem;
import com.yss.market.Pojo.commodity_1;
import com.yss.market.service.CommodityService;
import com.yss.market.service.serviceimpl.CommodityServiceimpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CartServlet extends BaseAbstractSevrlet {

    private CommodityService commodityService = new CommodityServiceimpl();
    private CommodityServiceimpl commodityServiceimpl=new CommodityServiceimpl();

    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
        }
        return defaultValue;
    }

    @SuppressWarnings("unused")
    //给页面放入商品
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.查询到商品
        List<commodity_1> list=commodityServiceimpl.QueryCommodities();
        //2 保存Page对象到Request域中
        req.setAttribute("page",list);
        //3 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    @SuppressWarnings("unused")
    //修改商品数量
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取请求的参数 商品编号 、商品数量
        int id =parseInt(req.getParameter("id"),0);
        int count=parseInt(req.getParameter("count"), 1);
        // 获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            // 修改商品数量
            cart.updateCount(id,count);
            // 重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    @SuppressWarnings("unused")
    // 清空购物车
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 1 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            // 清空购物车
            cart.clear();
            // 重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    @SuppressWarnings("unused")
   // 删除商品项
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取商品编号
        int id =parseInt(req.getParameter("id"), 0);
        // 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            // 删除 了购物车商品项
            cart.deleteItem(id);
            // 重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }



    @SuppressWarnings("unused")
     // 加入购物车
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 商品编号
        int id = parseInt(req.getParameter("id"), 0);
        //得到商品对象
        commodity_1 commodity_1 = commodityService.QueryCommodity(id);
        // 把商品信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(commodity_1.getId(),commodity_1.getName(),1,commodity_1.getPrice(),commodity_1.getPrice());
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        System.out.println(cart);

        // 重定向回原来商品所在的地址页面
         resp.sendRedirect(req.getHeader("Referer"));
    }
}
