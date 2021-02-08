package com.yss.market.dao.daoimpl.orderimpl;

import com.yss.market.Pojo.orderItem;
import com.yss.market.utils.mybatis_order.UserMapper;
import com.yss.market.utils.mybatis_utils.mybatis_utils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class orderItemDaoimpl implements orderItemDao {
    private SqlSession sqlSession;

    public void saveOrderItem(orderItem orderItem) {
        try {
            sqlSession= mybatis_utils.getSqlSession();
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            mapper.saveOrderItem(orderItem);
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

    public List<orderItem> queryOrderItem(String orderId) {
        try {
            sqlSession = mybatis_utils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<orderItem> orderItem = mapper.queryOrderItem(orderId);
            return orderItem;
        } catch (Exception e) {
            System.out.println("error!");
            return null;
        } finally {
            sqlSession.close();
        }
    }
}
