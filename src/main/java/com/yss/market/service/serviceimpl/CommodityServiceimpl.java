package com.yss.market.service.serviceimpl;

import com.yss.market.Pojo.commodity_1;
import com.yss.market.dao.daoimpl.commodityimpl.commodityDao;
import com.yss.market.dao.daoimpl.commodityimpl.commodityDaoimpl;
import com.yss.market.service.CommodityService;
import java.util.List;

public class CommodityServiceimpl implements CommodityService {
    private commodityDao commodityDaoimpl=new commodityDaoimpl();
    private List<commodity_1> list;

    public void addCommodity(commodity_1 commodity_1) {
        commodityDaoimpl.addCommodity(commodity_1);
    }

    public int delCommodityById(Integer id) {
        commodityDaoimpl.delCommodityById(id);
        return 0;
    }

    public int updateCommodity(commodity_1 commodity_1) {
        commodityDaoimpl.updateCommodity(commodity_1);
        return 0;
    }

    public commodity_1 QueryCommodity(Integer id) {
        return commodityDaoimpl.QueryCommodity(id);
    }

    public List<commodity_1> QueryCommodities() {
        list=commodityDaoimpl.QueryCommodities();
        return list;
    }
}
