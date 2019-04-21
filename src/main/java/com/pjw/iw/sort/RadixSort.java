package com.pjw.iw.sort;

/**
 * 基数排序，O(d(r+n))，稳定
 *
 * @author pangjiawei - [Created on 2019/4/19 11:34]
 */
public class RadixSort {

    public static void radix(int[] nums) {
        int maxNum = radixGetMaxNum(nums);

        for (int exp = 1; maxNum / exp > 0; exp *= 10) {
            radixInner(nums, exp);
        }
    }

    private static void radixInner(int[] nums, int exp) {
        int[] result = new int[nums.length];
        int[] buckets = new int[10];

        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] / exp % 10]++;
        }

        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[buckets[nums[i] / exp % 10] - 1] = nums[i];
            buckets[nums[i] / exp % 10]--;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    private static int radixGetMaxNum(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
