package com.jiyongjun.algorithm;

/**
 * description:冒泡排序
 *
 * @author yongjun.ji
 * @date 2018/5/15.
 */
public class BubbleSort {
    public static void sort(Long[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // 外循环
        for (int i = arr.length - 1; i > 0; i--) {
            // 内循环
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Long temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Long[] arr = {4L, 6L, 3L, 2L, 1L};
        sort(arr);
        for (Long aLong : arr) {
            System.out.println(aLong);
        }
    }
}
