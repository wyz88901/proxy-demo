package com.ywei.proxy.jdk.service.impl;

import com.ywei.proxy.jdk.service.IUserService;

import java.util.Random;

/**
 * @author yingzhou.wei
 * @Description TODO
 * @date 2019/6/22
 */
public class UserServiceImpl implements IUserService {

    @Override
    public void say(String content) {
        System.out.println(" jdk say msg: " + content);
    }

    @Override
    public void dance(String name) {
        System.out.println(" jdk dance music : " +name);
    }
}
