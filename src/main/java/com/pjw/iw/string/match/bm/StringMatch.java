package com.pjw.iw.string.match.bm;

/**
 * @author pangjiawei - [Created on 2019/4/13 14:46]
 */
public class StringMatch {

    public static int BF(String text, String pattern) {

        if (text == null || pattern == null) {
            return -1;
        }

        char[] textArray = text.toCharArray();
        char[] patternArray = pattern.toCharArray();

        int textLength = textArray.length;
        int patternLength = patternArray.length;

        int i = 0;
        int j = 0;

        while (i < textLength && j < patternLength) {
            if (textArray[i] == patternArray[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == patternLength) {
            return i - j;
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "dsfjk3ksfdk";
//        String pattern = "ksf";
        String pattern = null;
        System.out.println(BF(text, pattern));
    }
}
