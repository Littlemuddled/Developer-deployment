package com.kun.team.domain;

/**
 * Created with IntelliJ IDEA.
 * Description: 打印机
 * User:Administrator
 * Date:2022-06-11
 * Time:16:49
 */
public class Printer implements Equipment{
    private String name;//机器名字
    private String type;//机器类型

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }

    public Printer() {
        super();
    }

    public Printer(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
