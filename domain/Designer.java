package com.kun.team.domain;

/**
 * Created with IntelliJ IDEA.
 * Description:设计师
 * User:Administrator
 * Date:2022-06-11
 * Time:17:26
 */
public class Designer extends Programmer {
    private double bonus;//奖金

    public Designer() {
        super();
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary,equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.getDetails()
                + "\t设计师\t" + super.getStatus()
                + "\t" + this.getBonus()
                + "\t\t" + super.getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getMemberId()
                + "/" + getId()
                + "\t" + getName()
                + "\t" + getAge()
                + "\t" + getSalary()
                + "\t"
                + "\t设计师\t"
                + getBonus();
    }
}
