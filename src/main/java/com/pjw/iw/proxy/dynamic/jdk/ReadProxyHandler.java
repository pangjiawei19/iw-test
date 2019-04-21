package com.pjw.iw.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.pjw.iw.proxy.Action;

/**
 * @author pangjiawei - [Created on 2019/4/2 10:34]
 */
public class ReadProxyHandler implements InvocationHandler {

    private Read read;

    public ReadProxyHandler(Read read) {
        this.read = read;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("read proxy action...");
        return method.invoke(read, args);
    }

    public static void main(String[] args) {
        Action action = (Action) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Action.class},
                new ReadProxyHandler(new Read()));

        action.action();
    }
}
