package com.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/7.
 */
public class Player implements Serializable {

    public Player(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Player() {
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int id ;
    private String name;
    private int age ;


    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
