package com.kun.team.domain;

/**
 * Created with IntelliJ IDEA.
 * Description:构架师
 * User:Administrator
 * Date:2022-06-11
 * Time:17:31
 */
public class Architect extends Designer {
    private int stock;//表示公司奖励的股票数量

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return super.getDetails()
                + "\t设计师\t" + super.getStatus()
                + "\t" + super.getBonus()
                + "\t" + this.stock
                + "\t" + super.getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getMemberId()
                + "/" + getId()
                + "\t" + getName()
                + "\t" + getAge()
                + "\t" + getSalary()
                + "\t"
                + "\t架构师\t"
                + getBonus()
                + getStock();
    }
}
