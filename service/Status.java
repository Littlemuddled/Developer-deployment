package com.kun.team.service;

/**
 * Created with IntelliJ IDEA.
 * Description:表示员工状态
 *              Status是项目service包下自定义的类，声明三个对象属性，分别表示成员的状态。
 *              FREE-空闲
 *              BUSY-已加入开发团队
 *              VOCATION-正在休假
 * User:Administrator
 * Date:2022-06-11
 * Time:17:07
 */

public class Status {
    private final String NAME;
    private Status(String name) {
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
