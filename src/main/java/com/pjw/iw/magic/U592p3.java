package com.pjw.iw.magic;

import java.util.Scanner;

public class U592p3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        System.out.println(fb(num));
    }

    public static long fb(int n) {
        if (n < 3) {
            return 1;
        }

        long a = 1;
        long b = 1;

        long num = 0;
        for (int i = 2; i < n; i++) {
            num = (a + b) % 1000000;
            a = b % 1000000;
            b = num;
        }

        return num;
    }
}
