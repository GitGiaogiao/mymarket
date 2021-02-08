package com.yss.market.utils.mybatis_order;

import com.yss.market.Pojo.Order;
import com.yss.market.Pojo.orderItem;

import java.util.List;

@SuppressWarnings("unused")
public interface UserMapper {
    ///保存订单
    void saveOrder(Order order);
    ///保存订单条目
    void saveOrderItem(orderItem orderItem);
    ///查询订单得到订单中的数据
    Order queryOrder(String userId);
    ///查询订单项
    List<orderItem> queryOrderItem(String orderId);
}
