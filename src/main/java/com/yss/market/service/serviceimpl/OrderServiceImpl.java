package com.yss.market.service.serviceimpl;

import com.yss.market.Pojo.*;
import com.yss.market.dao.daoimpl.commodityimpl.commodityDao;
import com.yss.market.dao.daoimpl.commodityimpl.commodityDaoimpl;
import com.yss.market.dao.daoimpl.orderimpl.orderDaoimpl;
import com.yss.market.dao.daoimpl.orderimpl.orderItemDaoimpl;
import com.yss.market.service.OrderService;
import com.yss.market.dao.daoimpl.orderimpl.orderDao;
import com.yss.market.dao.daoimpl.orderimpl.orderItemDao;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private orderDao orderDao = new orderDaoimpl();
    private orderItemDao orderItemDao = new orderItemDaoimpl();
    private commodityDao commodityDao = new commodityDaoimpl();

    public String createOrder(Cart cart, String userId) {
        // 订单号===唯一性
        String orderId = userId+""+System.currentTimeMillis();
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(), 0,userId);
        // 保存订单
        orderDao.saveOrder(order);

        // 遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            orderItem orderItem = new orderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(), orderId);
            // 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存和销量
            //当库存足够才能购买
            commodity_1 commodity_1 = commodityDao.QueryCommodity(cartItem.getId());
            if((commodity_1.getSales() + cartItem.getCount())>=0&&(commodity_1.getStock() - cartItem.getCount())>=0)
            {
                commodity_1.setSales( commodity_1.getSales() + cartItem.getCount() );
                commodity_1.setStock( commodity_1.getStock() - cartItem.getCount() );
                commodityDao.updateCommodity(commodity_1);
            }
            else
            {
                return null;
            }

        }
        // 清空购物车
        cart.clear();
        return orderId;
    }

    public Order queryOrder(String userId) {
        return orderDao.queryOrder(userId);
    }

    public List<orderItem> queryOrderItem(String orderId) {
        return orderItemDao.queryOrderItem(orderId);
    }
}
