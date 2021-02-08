package com.yss.market.utils.mybatis_user1;

import com.yss.market.Pojo.user1;

import java.util.List;

public interface UserMapper {
    ////指定插入的用户
    void IdInsertUserList(user1 user);
    List<user1> QueryInf(user1 user1);
    List<user1> LoginUser(user1 user1);
}
