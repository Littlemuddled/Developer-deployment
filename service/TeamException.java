package com.kun.team.service;

/**
 * Created with IntelliJ IDEA.
 * Description:只定义异常类
 *              (一般基继承至 Exception(编译时报错) 或者 RuntimeException(运行时报错))
 * User:Administrator
 * Date:2022-06-11
 * Time:19:31
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -3387516124229948L;

    public TeamException() {
        super();
    }

    public TeamException(String msg) {
        super(msg);
    }
}
