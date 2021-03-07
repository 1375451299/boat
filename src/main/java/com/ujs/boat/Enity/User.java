package com.ujs.boat.Enity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
        private static final long serialVersionUID = 1L;
        /**
         * open_id
         */
        private String openId;
        /**
         * skey
         */
        private String skey;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 最后登录时间
         */
        private Date lastVisitTime;
        /**
         * session_key
         */
        private String sessionKey;
        /**
         * 市
         */
        private String city;
        /**
         * 省
         */
        private String province;
        /**
         * 国
         */
        private String country;
        /**
         * 头像
         */
        private String avatarUrl;
        /**
         * 性别
         */
        private Integer gender;
        /**
         * 网名
         */
        private String nickName;


    public User() {
    }

        public Date getCreateTime() {
                return createTime;
        }

        public Date getLastVisitTime() {
                return lastVisitTime;
        }

        public Integer getGender() {
                return gender;
        }

        public static long getSerialVersionUID() {
                return serialVersionUID;
        }

        public String getAvatarUrl() {
                return avatarUrl;
        }

        public String getCity() {
                return city;
        }

        public String getCountry() {
                return country;
        }

        public String getNickName() {
                return nickName;
        }

        public String getOpenId() {
                return openId;
        }

        public String getProvince() {
                return province;
        }

        public String getSessionKey() {
                return sessionKey;
        }

        public String getSkey() {
                return skey;
        }

        public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }

        public void setGender(Integer gender) {
                this.gender = gender;
        }

        public void setLastVisitTime(Date lastVisitTime) {
                this.lastVisitTime = lastVisitTime;
        }

        public void setNickName(String nickName) {
                this.nickName = nickName;
        }

        public void setOpenId(String openId) {
                this.openId = openId;
        }

        public void setProvince(String province) {
                this.province = province;
        }

        public void setSessionKey(String sessionKey) {
                this.sessionKey = sessionKey;
        }

    public void setSkey(String skey) {
        this.skey = skey;
    }
}
