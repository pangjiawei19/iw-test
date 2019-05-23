package com.pjw.iw.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author pangjiawei - [Created on 2019/4/15 20:15]
 */
public class Sort {

    /**
     * 冒泡排序：O(n*n)，稳定
     */
    public static void bubble(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    /**
     * 插入排序：O(n*n)，稳定
     */
    public static void insert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int j = i - 1;

            while (j >= 0 && target < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = target;
        }
    }

    /**
     * 希尔排序：O(n*n)，平均O(n 1.3)，不稳定
     */
    public static void shell(int[] nums) {
        int increment = nums.length / 3;
        while (increment >= 1) {
            for (int i = increment; i < nums.length; i++) {
                int target = nums[i];
                int j = i - increment;

                while (j >= 0 && target < nums[j]) {
                    nums[j + increment] = nums[j];
                    j -= increment;
                }

                nums[j + increment] = target;
            }

            increment /= 3;
        }


    }

    /**
     * 选择排序：O(n*n)，不稳定
     */
    public static void select(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }

            if (index != i) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
    }

    /**
     * 快速排序，O(n*logN)，不稳定
     */
    public static void quick(int[] nums) {
        quickInner(nums, 0, nums.length - 1);
    }

    private static void quickInner(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int baseNum = nums[startIndex];

        int left = startIndex;
        int right = endIndex;

        while (left < right) {
            while (left < right
                    && nums[right] >= baseNum) {
                right--;
            }

            while (left < right
                    && nums[left] <= baseNum) {
                left++;
            }

            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }

        int tmp = nums[left];
        nums[left] = nums[startIndex];
        nums[startIndex] = tmp;


        quickInner(nums, startIndex, left - 1);
        quickInner(nums, left + 1, endIndex);
    }




    public static void main(String[] args) {
        List<Integer> list = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        System.out.println(Arrays.toString(array));
//        bubble(array);
//        quick(array);
//        insert(array);
//        select(array);
//        shell(array);
//        radix(array);
        ss(array);
        System.out.println(Arrays.toString(array));
    }

    private static void ss(int[] nums) {
    }

    private static void qs(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int base = nums[start];
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && nums[right] >= base) {
                right--;
            }

            while (left < right && nums[left] <= base) {
                left++;
            }

            if (left < right) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
            }
        }

        int tmp = nums[left];
        nums[left] = nums[start];
        nums[start] = tmp;

        qs(nums, start, left - 1);
        qs(nums, left + 1, end);

    }

}
