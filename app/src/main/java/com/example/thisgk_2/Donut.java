package com.example.thisgk_2;

import java.io.Serializable;

public class Donut implements Serializable {
    private int anh;
    private String name,des;
    private int price,anhPlus,soLuong;

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAnhPlus() {
        return anhPlus;
    }

    public void setAnhPlus(int anhPlus) {
        this.anhPlus = anhPlus;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Donut(int anh, String name, String des, int price, int anhPlus, int soLuong) {
        this.anh = anh;
        this.name = name;
        this.des = des;
        this.price = price;
        this.anhPlus = anhPlus;
        this.soLuong = soLuong;
    }
}
