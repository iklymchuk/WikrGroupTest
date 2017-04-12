package com.klymchuk.rozetkaProject.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by iklymchuk on 4/11/17.
 */
@Entity
@Table(name="iphonePrice")
public class TestRunInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="TestId")
    private int userId;

    @Column(name = "Date")
    private Date date;

    @Column(name = "IphonePrice")
    private String iphone7Price;

    public int getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public String getIphone7Price() {
        return iphone7Price;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIphone7Price(String iphone7Price) {
        this.iphone7Price = iphone7Price;
    }
}
