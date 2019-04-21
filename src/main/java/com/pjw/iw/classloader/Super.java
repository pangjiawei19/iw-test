package com.pjw.iw.classloader;

/**
 * @author pangjiawei - [Created on 2019/4/2 11:24]
 */
public class Super {

    static {
        System.out.println("super static");
    }

    public Super() {
        System.out.println("super construct");
    }
}
