package com.kun.team.service;

import com.kun.team.domain.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 功能：负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * User:Administrator
 * Date:2022-06-11
 * Time:17:38
 */
public class NameListService {
    private final Employee[] employees;//保存公司所有员工对象

    /**
     * NameListService()构造器：
     * 根据项目提供的Data类构建相应大小的employees数组
     * 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
     * 将对象存于数组中
     *
     * 给employees及数组元素进行初始化
     */
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            //获取Employee的4个基本信息
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment equipment = null;
            double bonus = 0;
            int stock = 0;

            switch (type) {
                case Data.EMPLOYEE: //10
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER: //11
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case Data.DESIGNER: //12
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case Data.ARCHITECT: //13
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    /**
     * 获取指定index上的员工的设备
     * @return 指定index上的员工的设备
     */
    private Equipment createEquipment(int index) {
        int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        String modelOrName = Data.EQUIPMENTS[index][1];
        switch (key) {
            case Data.PC://21
                String display = Data.EQUIPMENTS[index][2];
                return new PC(modelOrName, display);
            case Data.NOTEBOOK://22
                double price = Double.parseDouble(Data.EQUIPMENTS[index][2]);
                return new NoteBook(modelOrName, price);
            case Data.PRINTER://23
                String type = Data.EQUIPMENTS[index][2];
                return new Printer(modelOrName, type);
        }
        return null;
    }

    /**
     * 获取当前所有员工。
     * @return 包含当前所有员工的数组
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 获取指定ID的员工对象。
     * @param id：指定员工的ID
     * @return 指定员工对象
     * 异常：找不到指定的员工
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工!");
    }
}
