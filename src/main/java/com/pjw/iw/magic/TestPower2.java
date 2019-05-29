package com.pjw.iw.magic;

public class TestPower2 {

    public static void main(String[] args) {
        for (int i = 1; i <= 32; i++) {
            if (isPower(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPower(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 != 0) {
            return false;
        } else {
            return isPower(n >> 1);
        }
    }

    public static boolean isPower1(int n) {
        if (n <= 0) {
            return false;
        }

        int b = n & (n - 1);
        return b == 0;
    }

    public static boolean isPower2(int n) {
        if (n <= 0) {
            return false;
        }

        while (true) {

            if (n == 1) {
                return true;
            }

            if (n % 2 == 0) {
                n = n >> 1;
            } else {
                return false;
            }
        }
    }
}
