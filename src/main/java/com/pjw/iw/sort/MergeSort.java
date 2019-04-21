package com.pjw.iw.sort;

import java.util.Arrays;

/**
 * 归并排序：O(n*logN)，稳定
 *
 * @author pangjiawei - [Created on 2019/4/19 14:42]
 */
public class MergeSort {

    public static void sort(int[] nums) {
        int[] tmp = new int[nums.length];
        sort(nums, 0, tmp.length - 1, tmp);
    }

    private static void sort(int[] nums, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, tmp);
            sort(nums, mid + 1, right, tmp);
            merge(nums, left, mid, right, tmp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[t++] = nums[i++];
            } else {
                tmp[t++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[t++] = nums[i++];
        }

        while (j <= right) {
            tmp[t++] = nums[j++];
        }

        t = 0;
        while (left <= right) {
            nums[left++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 7, 9, 4, 3, 6, 8};
        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
