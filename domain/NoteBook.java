package com.kun.team.domain;

/**
 * Created with IntelliJ IDEA.
 * Description:笔记本电脑
 * User:Administrator
 * Date:2022-06-11
 * Time:16:44
 */
public class NoteBook implements Equipment{
    private String model;//表示机器的型号
    private double price;//机器的价格


    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }

    public NoteBook() {
        super();
    }

    public NoteBook(String model, double price) {
        super();
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
