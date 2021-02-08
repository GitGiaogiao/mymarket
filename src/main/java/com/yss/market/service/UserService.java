package com.yss.market.service;

import com.yss.market.Pojo.user1;

public interface UserService {
     //用户注册
    void register(user1 user1);

   //用户登录
    String login(String username,String password);

   //查询用户名是否存在
    String existUsername(String username);

   //查询用户名是否存在
    String existEmail(String email);

    //查询用户名是否存在
    String existPhone(String phone);

    user1 getUser(String username,String password);
}
