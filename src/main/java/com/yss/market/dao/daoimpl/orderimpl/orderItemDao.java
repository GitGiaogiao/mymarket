package com.yss.market.dao.daoimpl.orderimpl;

import com.yss.market.Pojo.orderItem;

import java.util.List;

public interface orderItemDao {
    void saveOrderItem(orderItem orderItem);
    ///查询订单项
    List<orderItem> queryOrderItem(String orderId);
}
