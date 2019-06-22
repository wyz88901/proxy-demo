package com.ywei.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yingzhou.wei
 * @Description CGLIB实现动态代理，目标类必须继承父类
 * @date 2019/6/22
 */
public class ProxyInterceptor implements MethodInterceptor {



    /**
     * 创建代理对象
     * @param targetClass
     * @return
     */
    public <T> T newInstance(Class targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return (T) enhancer.create();
    }


    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName() + "() 调用前处理——————");
        Object result = methodProxy.invokeSuper(target, objects);
        System.out.println(method.getName() + "() 调用后处理——————");
        return result;
    }
}
