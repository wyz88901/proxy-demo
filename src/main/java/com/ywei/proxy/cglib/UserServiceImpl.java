package com.ywei.proxy.cglib;

/**
 * @author yingzhou.wei
 * @Description TODO
 * @date 2019/6/22
 */
public class UserServiceImpl extends UserService {

    @Override
    public void say(String content) {
        System.out.println(" cglib say msg: " + content);
    }

    @Override
    public void dance(String name) {
        System.out.println(" cglib dance music : " +name);
    }
}
