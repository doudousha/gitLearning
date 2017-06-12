package com.pojo;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/7.
 */
public class Club {


    private int id ;
    private String name;
    private String info ;
    private Date  createDate ;
    private int rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Club [id=" + id + ", clubName=" + name + ", clubInfo=" + info + ", createDate=" + createDate
                + ", rank=" + rank + "]";
    }
}
