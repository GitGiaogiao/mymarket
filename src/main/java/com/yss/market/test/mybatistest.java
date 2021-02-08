package com.yss.market.test;

import com.yss.market.Pojo.Order;
import com.yss.market.Pojo.commodity_1;
import com.yss.market.Pojo.orderItem;
import com.yss.market.Pojo.user1;
import com.yss.market.dao.daoimpl.commodityimpl.commodityDaoimpl;
import com.yss.market.dao.daoimpl.orderimpl.orderDao;
import com.yss.market.dao.daoimpl.orderimpl.orderDaoimpl;
import com.yss.market.dao.daoimpl.orderimpl.orderItemDao;
import com.yss.market.dao.daoimpl.orderimpl.orderItemDaoimpl;
import com.yss.market.dao.daoimpl.user1impl.CRUD;
import com.yss.market.service.CommodityService;
import com.yss.market.service.OrderService;
import com.yss.market.service.UserService;
import com.yss.market.service.serviceimpl.CommodityServiceimpl;
import com.yss.market.service.serviceimpl.OrderServiceImpl;
import com.yss.market.service.serviceimpl.UserServiceimpl;
import org.junit.Test;
import org.terracotta.offheapstore.paging.Page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class mybatistest {
    private commodityDaoimpl commodityDaoimpl=new commodityDaoimpl();
    @Test
    public void test1()
    {
        UserServiceimpl userServiceimpl=new UserServiceimpl();
        userServiceimpl.register(new user1("yss111","1234516","ys111@163.com",null,null));

    }

    @Test
    public void test2()
    {
        CRUD crud=new CRUD();
        System.out.println(crud.QueryUser(new user1("yss21",null,null,null,null)));

    }

    @Test
    public void test3()
    {
        UserServiceimpl userServiceimpl=new UserServiceimpl();
        System.out.println(userServiceimpl.existUsername("yss13"));

    }

    @Test
    public void test4()
    {
        UserServiceimpl userServiceimpl=new UserServiceimpl();
    }

    @Test
    public void test5()
    {
        UserServiceimpl userServiceimpl=new UserServiceimpl();
        System.out.println(  userServiceimpl.login("hhy69","12345y"));
    }

    ////commodity Test
    @Test
    public void test6()
    {
        commodityDaoimpl.addCommodity(new commodity_1(null,"HUAWEI",new BigDecimal(9999.99),300,9999,"static/img/bg3.jpg"));
    }

    @Test
  public void test7()
  {
   commodityDaoimpl.delCommodityById(2);
  }

  @Test
  public void test8()
  {
      commodityDaoimpl.updateCommodity(new commodity_1(4,"APPLE",new BigDecimal(9999),9999,9999,""));
  }

  @Test
  public void test9()
  {
      System.out.println( commodityDaoimpl.QueryCommodity(3));
  }

  @Test
  public void test10()
  {
      List<commodity_1> list=commodityDaoimpl.QueryCommodities();
      for(commodity_1 list1:list)
      {
          System.out.println(list1);
      }
  }

  @Test
    public void test11()
  {
      CommodityServiceimpl commodityServiceimpl=new CommodityServiceimpl();
      List<commodity_1> list=commodityServiceimpl.QueryCommodities();
      for(commodity_1 list1:list)
      {
          System.out.println(list1.getId()+list1.getSales()+list1.getStock()+list1.getName()+list1.getPrice());
      }
  }

  @Test
  public void test12()
  {
      CommodityService commodityServiceimpl=new CommodityServiceimpl();
      List<commodity_1> list=commodityServiceimpl.QueryCommodities();
      for(commodity_1 page:list)
      {
          System.out.println(page);
          System.out.println( page.getName()+
          page.getPrice()+
          page.getStock()+
          page.getSales()+
          page.getImg_path());
      }
  }

  @Test
  public void test13()
  {

      UserService userService=new UserServiceimpl();
      userService.register(new user1("James","yss132231","839782307@qq.com",null,"13902771347"));
  }

  @Test
  public void test14()
  {
      orderDao orderDao=new orderDaoimpl();
      orderDao.saveOrder(new Order("12135354",new Date(),new BigDecimal(333),0,"qmd333"));
  }

  @Test
  public void test15()
  {
      orderItemDao orderItemDao=new orderItemDaoimpl();
      orderItemDao.saveOrderItem(new orderItem(null,"HUAWEI",20,new BigDecimal(100),new BigDecimal(2000),"12135354"));

  }

  @Test
  public void test16()
  {
      CRUD crud=new CRUD();
     System.out.println(crud.LoginUser(new user1("ztt233","ztt521988",null,null,null)));

    //  System.out.println(crud.LoginUser(new user1(null,"yss132231",null,null,"13902771347")));

  }

  @Test
  public void test17()
  {
      OrderService orderService=new OrderServiceImpl();
      System.out.println( orderService.queryOrder("qmd333"));
      orderService.queryOrder("qmd333").getStatus();

  }

  @Test
  public void test18()
  {
      OrderService orderService=new OrderServiceImpl();
      System.out.println( orderService.queryOrderItem("12135354"));

  }
}
