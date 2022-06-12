package com.kun.team.view;

import com.kun.team.domain.Employee;
import com.kun.team.domain.Programmer;
import com.kun.team.service.NameListService;
import com.kun.team.service.TeamException;
import com.kun.team.service.TeamService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Administrator
 * Date:2022-06-11
 * Time:21:54
 */
public class TeamView {
    private final NameListService listSvc = new NameListService();
    private final TeamService teamSvc = new TeamService();

    //主界面显示及控制方法
    public void enterMenu() {

        boolean loopFlag = true;
        char menu = 0;
        while(loopFlag) {
            if (menu != '1') {
                listAllEmployees();
            }
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("退出");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    /**
     * listAllEmployees ()方法：以表格形式列出公司所有成员
     * getTeam()方法：显示团队成员列表操作
     * addMember ()方法：实现添加成员操作
     * deleteMember ()方法：实现删除成员操作
     */

    //以表格形式列出公司所有成员
    private void listAllEmployees() {
        System.out.println("显示所有员工信息");
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("公司中没有任何员工信息");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\t领用设备");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    //显示团队成员列表操作
    private void getTeam() {
        System.out.println("显示开发团队成员");
        System.out.println("\n--------------------团队成员列表---------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("开发团队目前没有成员！");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("-----------------------------------------------------");
    }

    //实现添加成员操作
    private void addMember() {
        System.out.println("添加成员");
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();

        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        // 按回车键继续...
        TSUtility.readReturn();
    }

    //实现删除成员操作
    private void deleteMember() {
        System.out.println("删除成员");
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int id = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N') {
            return;
        }
        try {
            teamSvc.removeMember(id);
            System.out.println("删除成功");
        } catch (TeamException e) {
            e.printStackTrace();
        }
        // 按回车键继续...
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMenu();
    }

}
