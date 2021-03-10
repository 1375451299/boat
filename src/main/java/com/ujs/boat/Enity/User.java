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
        private Date createTime;
        /**
         * 最后登录时间
         */
        private Date lastVisitTime;



    public User() {
    }

        public void setUser_name(String user_name) {
                this.user_name = user_name;
        }

        public void setLastVisitTime(Date lastVisitTime) {
                this.lastVisitTime = lastVisitTime;
        }

        public String getUser_name() {
                return user_name;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }

        public Date getLastVisitTime() {
                return lastVisitTime;
        }

        public Date getCreateTime() {
                return createTime;
        }

        public void setId(String id) {
                Id = id;
        }

        public String getId() {
                return Id;
        }

        public String getAge() {
                return age;
        }

        public String getSex() {
                return sex;
        }

        public void setAge(String age) {
                this.age = age;
        }

        public void setSex(String sex) {
                this.sex = sex;
        }
}
