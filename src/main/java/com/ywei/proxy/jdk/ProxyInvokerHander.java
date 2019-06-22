package com.ywei.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yingzhou.wei
 * @Description jdk通过反射实现动态代理, 该方式必须是实现接口
 * @date 2019/6/22
 */
public class ProxyInvokerHander implements InvocationHandler {
    private Class targetClass;

    public  <T>  T newProxyInstance(Class targetClass){
        this.targetClass = targetClass;
        return (T) Proxy.newProxyInstance(targetClass.getClassLoader(),
                targetClass.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;

        System.out.println("调用前处理——————");
        //调用真正的业务方法
        result=method.invoke(targetClass.newInstance(), args);

        System.out.println("调用后处理——————");
        return result;
    }
}
