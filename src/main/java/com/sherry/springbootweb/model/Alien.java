package com.sherry.springbootweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alien {
    @Id
    @GeneratedValue
    int aid;
    String aname;
    String alang;



    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAlang() { return alang;    }

    public void setAlang(String alang) { this.alang = alang; }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", alang='" + alang + '\'' +
                '}';
    }
}
