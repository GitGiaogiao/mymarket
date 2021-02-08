package com.yss.market.service;

import com.yss.market.Pojo.commodity_1;

import java.util.List;

public interface CommodityService {
    ///添加商品
    void addCommodity(commodity_1 commodity_1);
    ///删除商品
    int delCommodityById(Integer id);
    ///更新商品信息
    int updateCommodity(commodity_1 commodity_1);
    ///精确查询
    commodity_1 QueryCommodity(Integer id);
    ///全部查询
    List<commodity_1> QueryCommodities();
}
