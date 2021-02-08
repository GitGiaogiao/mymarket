package com.yss.market.dao.daoimpl.orderimpl;


import com.yss.market.Pojo.Order;

public interface orderDao {
    ///保存订单
    void saveOrder(Order order);
    ///查询订单得到订单中的数据
    Order queryOrder(String userId);
}
