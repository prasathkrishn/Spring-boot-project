package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.Table;

@Entity
public class Movie {
    @Id
    private int subscriberid;
    private int premiumfourkHDR;
    private int standard;
    private int basic;
    
    private int mobile;
    public Movie ()
    {

    }
    public Movie(int subscriberid, int premiumfourkHDR, int standard, int basic, int mobile) {
        this.subscriberid = subscriberid;
        this.premiumfourkHDR = premiumfourkHDR;
        this.standard = standard;
        this.basic = basic;
        this.mobile = mobile;
    }
    public void setSubscriberid(int subscriberid) {
        this.subscriberid = subscriberid;
    }
    public int getSubscriberid() {
        return subscriberid;
    }
    public int getPremiumfourkHDR() {
        return premiumfourkHDR;
    }
    public void setPremiumfourkHDR(int premiumfourkHDR) {
        this.premiumfourkHDR = premiumfourkHDR;
    }
    public int getStandard() {
        return standard;
    }
    public void setStandard(int standard) {
        this.standard = standard;
    }
    public int getBasic() {
        return basic;
    }
    public void setBasic(int basic) {
        this.basic = basic;
    }
    public int getMobile() {
        return mobile;
    }
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
   
   
}