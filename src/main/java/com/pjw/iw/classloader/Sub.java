package com.pjw.iw.classloader;

/**
 * @author pangjiawei - [Created on 2019/4/2 11:24]
 */
public class Sub extends Super {

    static {
        System.out.println("sub static");
    }

    public Sub() {
        System.out.println("sub construct");
    }

    public static void main(String[] args) {
        new Sub();
    }
}
