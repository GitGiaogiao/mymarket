package com.yss.market.utils.mybatis_utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class mybatis_utils {
    /////Step1:使用MyBatis获取sqlSessionFactory对象

    static private SqlSessionFactory sqlSessionFactory;
    ///静态代码块
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
       {
           try {
               inputStream = Resources.getResourceAsStream(resource);
               //////通过builder将流加载进来
               sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }

    //既然有了SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    // SqlSession提供了在数据库执行 SQL 命令所需的所有方法。
   public static SqlSession getSqlSession()
   {
       ////返回一个SqlSession 的实例，以执行sql语句
       return sqlSessionFactory.openSession();
   }
}
