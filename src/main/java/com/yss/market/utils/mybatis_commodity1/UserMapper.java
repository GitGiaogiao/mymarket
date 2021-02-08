package com.yss.market.utils.mybatis_commodity1;

import com.yss.market.Pojo.commodity_1;

import java.util.List;

@SuppressWarnings("unused")
public interface UserMapper {
    ///添加商品
    void addCommodity(commodity_1 commodity_1);
    ///删除商品
    void delCommodityById(Integer id);
    ///更新商品信息
    void updateCommodity(commodity_1 commodity_1);
    ///查询
    commodity_1 QueryCommodity(Integer id);
    ///多组查询
    List<commodity_1> QueryCommodities();
    ///商品数目
    Integer queryForPageTotalCount();
}
