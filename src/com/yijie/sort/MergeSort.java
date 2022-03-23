package com.yijie.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println("after merge sort: " + Arrays.toString(arr));
    }

    //Method: Merge + Sort
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //Recursion to the left
            mergeSort(arr, left, mid, temp);
            //Recursion to the right
            mergeSort(arr, mid + 1, right, temp);
            //merge
            merge(arr, left, mid, right, temp);
        }
    }


    //Method Merge

    /***
     *
     * @param arr the original array to be sorted
     * @param left initialized index of the left array
     * @param mid middle index
     * @param right initialized index of the right array
     * @param temp auxiliary array
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//initialize i as original index of left array
        int j = mid + 1;//initialize i as original index of right array
        int t = 0;

        //1. put the left and right sorted lists to the temp array, until either array is empty
        while (i <= mid && j <= right) {
            //if the element in the left array is smaller than the element in the right array,
            //copy the element to the temp array
            //
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //2. transfer the remaining items in the not empty array to the end of the temp array
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3. Copy the elements in the temp to the arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
