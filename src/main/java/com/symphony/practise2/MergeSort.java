package com.symphony.practise2;

import java.util.Arrays;

public class MergeSort {
    static void main() {
        int[] array = {1, 2, 1, 3, 4, 2, 3, 4, 5, 6, 5, 4, 5, 6, 5, 7, 8, 7, 8, 89};
        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println("After Sorting");
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return;
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, len - mid);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];

        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}
