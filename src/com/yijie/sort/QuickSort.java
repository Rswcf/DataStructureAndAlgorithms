package com.yijie.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, 0, -9, 500, 70, -9};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println("after quick sort: " + Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//left index
        int r = right;//right index
        //pivot
        int pivot = arr[(left + right) / 2];
        int temp = 0; //auxiliary variable
        while (l < r) {
            //searching to the left of pivot, if an element grater than pivot was found, quit
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }

            //swap the left and right
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //if arr[l] == pivot, r--
            if (arr[l] == pivot) {
                r--;
            }
            //if arr[r] == pivot, l++
            if (arr[r] == pivot) {
                l++;
            }
            //if l == r, l++, r--
            if (l == r) {
                l++;
                r--;
            }

            //recursion to the left
            if (left < r) {
                quickSort(arr, left, r);
            }
            //recursion to the left
            if (right > l) {
                quickSort(arr, l, right);
            }
        }
    }

    public static void quickSort2(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        do {
            while (arr[l] < pivot) {
                l++;
            }

            while (arr[r] > pivot) {
                r--;
            }

            if (l <= r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        } while (l <= r);
        if (left < r) {
            quickSort2(arr, left, r);
        }
        if (l < right) {
            quickSort2(arr, l, right);
        }
    }
}
