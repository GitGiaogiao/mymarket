package com.yss.market.Pojo;

import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unused")
public class user1 {
   private String username;
   private String password;
   private String email;
   private Integer id;
   private String phone;

    public user1() {
    }

    public user1(String username, String password, String email, Integer id, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.id = id;
        this.phone = phone;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "user1{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                '}';
    }
}
