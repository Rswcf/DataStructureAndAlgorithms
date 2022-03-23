package com.yijie.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);

    }

    public static void radixSort(int[] arr) {

        //the 1st Round
        //define a two-dimensional array to represent the 10 buckets

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        int index = 0;

        int max = arr[0];
        for (int h = 0; h < arr.length; h++) {
            if (arr[h] > max) {
                max = arr[h];
            }
        }
        //TRICK to get the length of max
        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            bucket = new int[10][arr.length];
            bucketElementCounts = new int[10];

            //Array => Buckets
            for (int j = 0; j < arr.length; j++) {

                int digitOfElement = arr[j] / n % 10;

                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //traverse the buckets and take out the elements from the buckets to the array
            index = 0;

            for (int k = 0; k < bucketElementCounts.length; k++) {
                //if bucket is not empty
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //take out the elements and put into the array
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
            }
        }
        System.out.println("after radix sort: " + Arrays.toString(arr));
    }
}
