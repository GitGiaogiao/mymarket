package com.yss.market.dao.daoimpl.user1impl;

import com.yss.market.Pojo.user1;
import com.yss.market.utils.mybatis_user1.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import com.yss.market.utils.mybatis_utils.mybatis_utils;

import java.util.List;

@Component
public class CRUD {
    private SqlSession sqlSession;

    public void InsertUser(user1 user1)
    {
      try {
    sqlSession=mybatis_utils.getSqlSession();
    UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    userMapper.IdInsertUserList(user1);
          System.out.println("successful!");
    sqlSession.commit();
          }finally {
    sqlSession.close();
     }

    }

    public user1 QueryUser(user1 user1 ) {
        try {
            sqlSession = mybatis_utils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            if(userMapper.QueryInf(user1)!=null)
            {
                List<user1> list = userMapper.QueryInf(user1);
                return list.get(0);
            }
           else {
                return null;
            }
        }catch (Exception e)
        {
            return null;
        }
        finally {
            sqlSession.close();
        }
    }

    public user1 LoginUser(user1 user1)
    {
        try {
            sqlSession = mybatis_utils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            if(user1.getUsername()==null&&user1.getPhone()==null)
            {
                return null;
            }
            else if(user1.getUsername()==""&&user1.getPhone()=="")
            {
                return null;
            }
            else if(user1.getUsername()==""&&user1.getPhone()==null)
            {
                return null;
            }
            else if(user1.getUsername()==null&&user1.getPhone()=="")
            {
                return null;
            }
            else {
                List<user1> list = userMapper.LoginUser(user1);
                return list.get(0);
            }
        }catch (Exception e)
        {
            return null;
        }
        finally {
            sqlSession.close();
        }
    }


}
