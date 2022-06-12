package com.kun.team.junit;

import com.kun.team.domain.Employee;
import com.kun.team.service.NameListService;
import com.kun.team.service.TeamException;

/**
 * Created with IntelliJ IDEA.
 * Description: 对NameListService类的测试
 * User:Administrator
 * Date:2022-06-11
 * Time:19:42
 */
public class NameListServiceTest {
    public static void main(String[] args) throws TeamException {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
        System.out.println(service.getEmployee(1));
    }

}
