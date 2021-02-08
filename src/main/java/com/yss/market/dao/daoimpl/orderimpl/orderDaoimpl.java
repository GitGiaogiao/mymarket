package com.yss.market.dao.daoimpl.orderimpl;

import com.yss.market.Pojo.Order;
import com.yss.market.utils.mybatis_order.UserMapper;
import com.yss.market.utils.mybatis_utils.mybatis_utils;
import org.apache.ibatis.session.SqlSession;

///用来保存用户订单，内含订单号，金额，下单状态，下单时间，订单用户编号
public class orderDaoimpl implements  orderDao{
    private SqlSession sqlSession;

    public void saveOrder(Order order) {
        try {
            sqlSession= mybatis_utils.getSqlSession();
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            mapper.saveOrder(order);
            System.out.println("successful!");
            sqlSession.commit();
        }catch (Exception e)
        {
            System.out.println("error!");
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }
    }

    public Order queryOrder(String userId) {
        try {
            sqlSession = mybatis_utils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Order order = mapper.queryOrder(userId);
            return order;
        } catch (Exception e) {
            System.out.println("error!");
            return null;
        } finally {
            sqlSession.close();
        }
    }
}
