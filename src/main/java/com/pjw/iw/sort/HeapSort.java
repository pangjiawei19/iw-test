package com.pjw.iw.sort;

import java.util.Arrays;

/**
 * @author pangjiawei - [Created on 2019/4/19 11:35]
 */
public class HeapSort {

    /**
     * 最小堆下沉算法
     */
    public static void minHeapDown(int[] nums, int start, int end) {
        int c = start;
        int next = c * 2 + 1;
        int tmp = nums[c];

        for (; next <= end; c = next, next = next * 2 + 1) {
            if (next < end && nums[next] > nums[next + 1]) {
                next++;
            }

            if (tmp <= nums[next]) {
                break;
            } else {
                nums[c] = nums[next];
                nums[next] = tmp;
            }
        }
    }

    /**
     * 降序排列
     */
    public static void sortDesc(int[] nums) {
        int n = nums.length;

        //构建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapDown(nums, i, n - 1);
        }

        System.out.println(Arrays.toString(nums));

        for (int i = n - 1; i > 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;

            minHeapDown(nums, 0, i - 1);
        }
    }

    /**
     * 最大堆下沉算法
     */
    public static void maxHeapDown(int[] nums, int start, int end) {
        int c = start;
        int next = c * 2 + 1;
        int tmp = nums[c];

        for (; next <= end; c = next, next = next * 2 + 1) {
            if (next < end && nums[next] < nums[next + 1]) {
                next++;
            }

            if (tmp >= nums[next]) {
                break;
            } else {
                nums[c] = nums[next];
                nums[next] = tmp;
            }
        }
    }

    /**
     * 升序排列
     */
    public static void sortAsc(int[] nums) {
        int n = nums.length;

        //构建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapDown(nums, i, n - 1);
        }

        System.out.println(Arrays.toString(nums));

        for (int i = n - 1; i > 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;

            maxHeapDown(nums, 0, i - 1);
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 7, 9, 4, 3, 6, 8};
//        sortAsc(a);
//        minHeapDown(a, 0, a.length - 1);
        sortDesc(a);
        System.out.println(Arrays.toString(a));
    }
}
