package com.pjw.iw.magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class U592p7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<String> nums = parse(text);

        List<Integer> plusList = new ArrayList<>();

        List<Integer> minusList = new ArrayList<>();
        boolean minus = false;

        for (String s : nums) {
            if (minus) {
                if (s.equals("+")) {
                    continue;
                } else if (s.equals("-")) {
                    int num = calculateSum(minusList);
                    plusList.add(-num);
                    minusList.clear();
                    minus = true;
                } else {
                    minusList.add(Integer.parseInt(s));
                }

            } else {
                if (s.equals("+")) {
                    continue;
                } else if (s.equals("-")) {
                    minus = true;
                } else {
                    plusList.add(Integer.parseInt(s));
                }

            }

        }

        if (!minusList.isEmpty()) {
            int num = calculateSum(minusList);
            plusList.add(-num);
        }

        System.out.println(calculateSum(plusList));

    }

    public static int calculateSum(List<Integer> stack) {
        int num = 0;
        for (Integer i : stack) {
            num += i;
        }
        return num;
    }


    public static List<String> parse(String text) {
        List<String> list = new ArrayList<>();

        int num = 0;

        for (int i = 0; i < text.length(); i++) {
            char word = text.charAt(i);
            if (word >= '0' && word <= '9') {
                int realNum = word - '0';
                num = 10 * num + realNum;
            } else {
                list.add(String.valueOf(num));
                list.add(String.valueOf(word));
                num = 0;
            }
        }

        list.add(String.valueOf(num));

        return list;
    }

}
