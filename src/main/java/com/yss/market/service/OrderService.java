package com.yss.market.service;

import com.yss.market.Pojo.Cart;
import com.yss.market.Pojo.Order;
import com.yss.market.Pojo.orderItem;

import java.util.List;

public interface OrderService {
    String createOrder(Cart cart, String userId);
    Order queryOrder(String userId);
    List<orderItem> queryOrderItem(String orderId);

}
