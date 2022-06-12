package com.kun.team.service;

import com.kun.team.domain.Architect;
import com.kun.team.domain.Designer;
import com.kun.team.domain.Employee;
import com.kun.team.domain.Programmer;

/**
 * Created with IntelliJ IDEA.
 * Description:  功能：关于开发团队成员的管理：添加、删除等。
 * User:Administrator
 * Date:2022-06-11
 * Time:20:27
 */
public class TeamService {
    private static int count = 1;//给memberId赋值用
    private final int MAX_MEMBER = 5;//限制开发团队的人数
    private final Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队人员
    private int total = 0;//记录开发团队中实际人数

    /**
     * + getTeam(): Programmer[]
     * + addMember(e: Employee) throws TeamException: void
     * + removeMember(memberId: int) throws TeamException: void
     */

    public TeamService() {
        super();
    }

    //获取开发团队中所有成员
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[this.total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }
    /**
     * 功能：将指定的员工添加到开发团队中
     *  失败信息包含以下几种：
     *      成员已满，无法添加
     *      该成员不是开发人员，无法添加
     *      该员工已在本开发团队中
     *      该员工已是某团队成员
     *      该员正在休假，无法添加
     *      团队中至多只能有一名架构师
     *      团队中至多只能有两名设计师
     *      团队中至多只能有三名程序员
     */
    public void addMember(Employee e) throws TeamException {
        if (this.total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if (isExist(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }
        Programmer p = (Programmer)e;//程序能走到这里一定不会出现ClassCastException(转换异常)
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工已是某团队成员");
        } else if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员正在休假，无法添加");
        }

        //获取team已有成员中设计师，构架师，程序员的数量
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < this.total; i++) {
            if (this.team[i] instanceof Architect) {
                numOfArch++;
            } else if (this.team[i] instanceof Designer) {
                numOfDes++;
            } else {
                numOfPro++;
            }
        }
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        //将p添加到现有team中
        this.team[this.total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(count++);
    }
    //判断指定员工是否已经存在于开发团队中
    private boolean isExist(Employee e) {
        for (int i = 0; i < this.total; i++) {
            if(this.team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    //从团队中删除成员
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < this.total; i++) {
            if (this.team[i].getMemberId() == memberId) {
                this.team[i].setStatus(Status.FREE);
                break;
            }
        }
        //没找到memberId的情况
        if (i == this.total) {
            throw new TeamException("找不到指定的memberId的员工，删除失败!");
        }

        for (int j = i + 1; j < this.total ; j++) {
            this.team[j - 1] = this.team[j];
        }
        this.team[--total] = null;

    }
}
