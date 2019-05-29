package com.pjw.iw.magic;

import java.util.Arrays;
import java.util.Scanner;

public class U592p51 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String[] array = text.split("-");

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            String str = array[i];

            int num = calculateSum(str.split("\\+"));
            if (i > 0) {
                num = -num;
            }

            result += num;
        }

        System.out.println(result);

    }

    public static int calculateSum(String[] array) {
        return Arrays.stream(array)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
