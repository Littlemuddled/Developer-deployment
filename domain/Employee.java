package com.kun.team.domain;

/**
 * Created with IntelliJ IDEA.
 * Description:最普通的员工
 * User:Administrator
 * Date:2022-06-11
 * Time:16:56
 */
public class Employee {
    private int id;//人员工号
    private String name;//名字
    private int age;//年龄
    private double salary;//工资

    public Employee() {
        super();
    }
    public Employee(int id, String name, int age, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDetails() {
        return id + "\t" + name + "\t\t" + age + "\t\t" + salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }

}
