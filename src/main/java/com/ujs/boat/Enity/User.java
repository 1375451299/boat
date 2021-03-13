package com.ujs.boat.Enity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
        /**
         * 用户昵称
         */
        private String user_name;
        /**
         * 用户唯一id
         */
        private String Id;
        /**
         * 用户密码
         */
        private String password;
        /**
         * 用户年龄
         */
        private String age;
        /**
         * 用户性别
         */
        private String sex;
        /**
         * 创建时间
         */
        private String createTime;
        /**
         * 最后登录时间
         */
        private String lastVisitTime;
        /**
         * 用户登录状态
         */
        private String status;


    public User() {
    }

}
