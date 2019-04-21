package com.pjw.iw.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

/**
 * @author pangjiawei - [Created on 2019/4/2 10:40]
 */
public class SleepInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib interceptor action...");
        return methodProxy.invokeSuper(o, objects);
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Sleep.class);
        enhancer.setCallback(new SleepInterceptor());

        Sleep action = (Sleep) enhancer.create();
        action.action();
    }
}
