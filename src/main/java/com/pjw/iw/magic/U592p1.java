package com.pjw.iw.magic;

import java.util.Scanner;

public class U592p1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        if (isPower(num)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isPower(int n) {
        if (n == 1) {
            return true;
        }

        if (n % 2 != 0) {
            return false;
        } else {
            return isPower(n >> 1);
        }
    }
}
