package com.yss.market.web;

import com.yss.market.Pojo.commodity_1;
import com.yss.market.service.serviceimpl.CommodityServiceimpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class commodity1Servlet extends BaseAbstractSevrlet {
    ///將String类型转换为int类型
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
        }
        return defaultValue;
    }

    private CommodityServiceimpl commodityServiceimpl=new CommodityServiceimpl();
   @SuppressWarnings("unused")
    //添加
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("name");
       int price=parseInt(req.getParameter("price"),0);
       int  sales=parseInt(req.getParameter("sales"),0);
       int  stock=parseInt(req.getParameter("stock"),0);
       String img_path=req.getParameter("img_path");
       commodityServiceimpl.addCommodity(new commodity_1(null,name,new BigDecimal(price),sales,stock,img_path));
       resp.sendRedirect(req.getContextPath() + "/commodity1Servlet?action=query");
    }

   @SuppressWarnings("unused")
    //删除
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id=parseInt(req.getParameter("id"),0);
       commodityServiceimpl.delCommodityById(id);
       resp.sendRedirect(req.getContextPath() + "/commodity1Servlet?action=query");
    }
   @SuppressWarnings("unused")
    //修改
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("name");
       int price=parseInt(req.getParameter("price"),0);
       int id=parseInt(req.getParameter("id"),0);
       int  sales=parseInt(req.getParameter("sales"),0);
       int  stock=parseInt(req.getParameter("stock"),0);
       String img_path=req.getParameter("img_path");
       commodityServiceimpl.updateCommodity(new commodity_1(id,name,new BigDecimal(price),sales,stock,img_path));
       resp.sendRedirect(req.getContextPath() + "/commodity1Servlet?action=query");
    }

    @SuppressWarnings("unused")
    //获取信息
    protected void getInformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=parseInt(req.getParameter("id"),0);
        commodity_1 commodity_1=commodityServiceimpl.QueryCommodity(id);
        req.setAttribute("commodity",commodity_1);
        req.getRequestDispatcher("/pages/manager/commodity_edit.jsp").forward(req,resp);
    }

   @SuppressWarnings("unused")
    //查询所有并保存在request域中，放在商品管理处
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     List<commodity_1> list=commodityServiceimpl.QueryCommodities();
     req.setAttribute("lists",list);
     req.getRequestDispatcher("/pages/manager/commodity_manager.jsp").forward(req,resp);
    }
}
