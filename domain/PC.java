package com.kun.team.domain;

/**
 * Created with IntelliJ IDEA.
 * Description:个人电脑
 * User:Administrator
 * Date:2022-06-11
 * Time:16:32
 */
public class PC implements  Equipment {
    private String model;//表示机器的型号
    private String display;//表示显示器名称

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }

    public PC() {
        super();
    }

    public PC(String model, String display) {
        super();
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
