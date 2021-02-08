package com.yss.market.service.serviceimpl;

import com.yss.market.Pojo.user1;
import com.yss.market.dao.daoimpl.user1impl.CRUD;
import com.yss.market.service.UserService;

public class UserServiceimpl implements UserService {
    private  CRUD crud=new CRUD();
    public void register(user1 user1) {
         crud.InsertUser(user1);
    }

    public String login(String username,String password) {
        if(crud.LoginUser(new user1(username,password,null,null,null))!=null)
        {
            return "exist";
        }
        else if(crud.LoginUser(new user1(null,password,null,null,username))!=null)
        {
            return "exist";
        }
        else {
            return null;
        }
    }

    public String existUsername(String username) {
        if(crud.QueryUser(new user1(username,null,null,null,null))!=null)
        {
            /////如果用户名存在则返回存在
            return "exist";
        }
        else {
            return null;
        }

    }

    public String existEmail(String email) {
        CRUD crud=new CRUD();
        if(crud.QueryUser(new user1(null,null,email,null,null))!=null)
        {
            /////如果用户名存在则返回true
            return "exist";
        }
        else {
            return null;
        }

    }

    public String existPhone(String phone) {
        CRUD crud=new CRUD();
        if(crud.QueryUser(new user1(null,null,null,null,phone))!=null)
        {
            /////如果手机号存在则返回true
            return "exist";
        }
        else {
            return null;
        }
    }

    public user1 getUser(String username,String password)
    {
        user1 user1=new user1(username,password,null,null,null);
        if(crud.LoginUser(user1)!=null)
        {
            return crud.LoginUser(user1);
        }
        else {
            return null;
        }
    }

}
