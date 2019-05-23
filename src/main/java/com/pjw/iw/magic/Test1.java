package com.pjw.iw.magic;

public class Test1 {

    public static void main(String[] args) {
//        int n = 10;
//        int[] result = new int[n];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = fb1(i + 1);
//        }
//
//        System.out.println(Arrays.toString(result));


//        for (int i = 1; i <= 10; i++) {
//            System.out.println(fb(i));
//        }

        long num = fb(999);
        System.out.println(num);
//        System.out.println(num % 1000000);
    }

    public static long fb(int n) {
        if (n < 3) {
            return 1;
        }

        long a = 1;
        long b = 1;

        long num = 0;
        for (int i = 2; i < n; i++) {
            num = a + b;
            a = b;
            b = num;
        }

        return num % 1000000;
    }


    public static int[] fb2(int n) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int num;

            if (i == 0) {
                num = 0;
            } else if (i == 1) {
                num = 1;
            } else {
                num = result[i - 2] + result[i - 1];
            }

            result[i] = num;
        }

        return result;
    }

    public static int fb1(int n) {
        int num;

        if (n == 1 || n == 2) {
            num = 1;
        } else {
            num = fb1(n - 1) + fb1(n - 2);
        }
        return num;
    }

}
