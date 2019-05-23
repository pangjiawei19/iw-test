package com.pjw.iw.star;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author pangjiawei - [Created on 2019/5/9 20:24]
 */
public class StarDraw {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        rightAlign(6);
        for (Method method : StarDraw.class.getDeclaredMethods()) {
            if (!method.getName().equals("main")) {
                method.invoke(null, 6);
            }
//            System.out.println(method);
        }
    }

    /**
     * 金字塔
     */
    public static void pyramid(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = i; j < num; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /**
     * 奇数金字塔
     */
    public static void oddPyramid(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = i; j < num; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /**
     * 偶数金字塔
     */
    public static void evenPyramid(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = i; j < num; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /**
     * 左对齐
     */
    public static void leftAlign(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 右对齐
     */
    public static void rightAlign(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
