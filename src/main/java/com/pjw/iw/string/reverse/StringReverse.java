package com.pjw.iw.string.reverse;

/**
 * @author pangjiawei - [Created on 2019/4/17 16:31]
 */
public class StringReverse {

    public static void reverse(char[] array, int start) {
        if (start >= array.length / 2) {
            System.out.println(new String(array));
            return;
        }

        char tmp = array[array.length - 1 - start];
        array[array.length - 1 - start] = array[start];
        array[start] = tmp;

        reverse(array, start + 1);

        tmp = array[array.length - 1 - start];
        array[array.length - 1 - start] = array[start];
        array[start] = tmp;
    }

    public static void reverse2(String text) {
        StringBuilder builder = new StringBuilder(text);
        builder.reverse();
        System.out.println(builder.toString());
    }

    public static void reverse3(String text) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            char tmp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i];
            array[i] = tmp;
        }
        System.out.println(new String(array));
    }

    public static String reverse4(String text) {
        int length = text.length();
        if (length <= 1) {
            return text;
        }
        return reverse4(text.substring(length / 2, length)) + reverse4(text.substring(0, length / 2));
    }

    public static void main(String[] args) {
        String a = "我们都是好孩子";
//        reverse(a.toCharArray(), 0);
        System.out.println(reverse4(a));
    }
}
