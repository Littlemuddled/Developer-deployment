package com.kun.team.domain;

import com.kun.team.service.Status;

/**
 * Created with IntelliJ IDEA.
 * Description:程序员
 * User:Administrator
 * Date:2022-06-11
 * Time:17:01
 */
public class Programmer extends Employee {
    private int memberId;//用来记录成员加入开发团队后在团队中的ID
    private Status status = Status.FREE;//声明三个对象属性，分别表示成员的状态
    private Equipment equipment;//表示该成员领用的设备

    public Programmer() {
        super();
    }
    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\t程序员\t" + this.status + "\t\t\t" + this.equipment.getDescription();
    }

    public String getDetailsForTeam() {
        return memberId
                + "/" + getId()
                + "\t" + getName()
                + "\t" + getAge()
                + "\t" + getSalary()
                + "\t" + "\t程序员";
    }
}
