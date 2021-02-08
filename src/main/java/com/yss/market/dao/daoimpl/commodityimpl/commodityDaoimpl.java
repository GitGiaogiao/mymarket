package com.yss.market.dao.daoimpl.commodityimpl;

import com.yss.market.Pojo.commodity_1;
import com.yss.market.utils.mybatis_commodity1.UserMapper;
import org.apache.ibatis.session.SqlSession;
import com.yss.market.utils.mybatis_utils.mybatis_utils;
import java.util.List;

public class commodityDaoimpl implements commodityDao {
    private SqlSession sqlSession;
    public void addCommodity(commodity_1 commodity_1) {
        try{
            sqlSession=mybatis_utils.getSqlSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            userMapper.addCommodity(commodity_1);
            System.out.println("successful");
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public int delCommodityById(Integer id) {
        try{
            sqlSession=mybatis_utils.getSqlSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            userMapper.delCommodityById(id);
            System.out.println("Delete completed!");
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return 0;
    }

    public int updateCommodity(commodity_1 commodity_1) {
       try {
           sqlSession=mybatis_utils.getSqlSession();
           UserMapper mapper=sqlSession.getMapper(UserMapper.class);
           mapper.updateCommodity(commodity_1);
           System.out.println("Update completed!");
           sqlSession.commit();
       }catch (Exception e)
       {
          e.printStackTrace();
           System.out.println("Error!!plz try again!");
       }
       finally {
           sqlSession.close();
       }
       return 0;
    }

    public commodity_1 QueryCommodity(Integer id) {
       try {
           sqlSession=mybatis_utils.getSqlSession();
           UserMapper mapper=sqlSession.getMapper(UserMapper.class);
           commodity_1 commodity_1=mapper.QueryCommodity(id);
           return commodity_1;
       }finally {
           sqlSession.close();
       }
    }


    public List<commodity_1> QueryCommodities() {
        try {
            sqlSession=mybatis_utils.getSqlSession();
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            List<commodity_1> list=mapper.QueryCommodities();
            return list;
        }catch (Exception e)
        {
          e.getStackTrace();
            return null;
        }
        finally {
            sqlSession.close();
        }
    }
}
