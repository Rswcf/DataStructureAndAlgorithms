package com.yijie.sort;

import java.util.Arrays;

public class ShellSort {

    /*
    ShellSort is mainly a variation of Insertion Sort.
    In insertion sort, we move elements only one position ahead.
    When an element has to be moved far ahead, many movements are involved.
    The idea of shellSort is to allow exchange of far items.
    In shellSort, we make the array h-sorted for a large value of h.
    We keep reducing the value of h until it becomes 1.
    An array is said to be h-sorted if all sublists of every h’th element is sorted.
     */

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("before shell sort: " + Arrays.toString(arr));
        shellSort(arr);
    }

    public static void shellSort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //divide
            for (int i = gap; i < arr.length; i++) {
                //traverse elements in the 5 sets, 2 elements per set
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("after the iteration: " + Arrays.toString(arr));
        }

        /*
        //Iteration 1 of shell sort
        //divide the 10 data points into 5 sets
        for (int i = 5; i < arr.length; i++){
            //traverse elements in the 5 sets, 2 elements per set
            for (int j = i - 5; j >= 0; j -= 5){
                if (arr[j] > arr[j + 5]){
                    int temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("after the iteration 1 of shell sort: " + Arrays.toString(arr));

        //Iteration 2 of shell sort
        //divide the 10 data points into 5/2 = 2 sets
        for (int i = 2; i < arr.length; i++){
            //traverse elements in the 5 sets, 2 elements per set
            for (int j = i - 2; j >= 0; j -= 2){
                if (arr[j] > arr[j + 2]){
                    int temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("after the iteration 2 of shell sort: " + Arrays.toString(arr));

        //Iteration 3 of shell sort
        //divide the 10 data points into 2/2 = 1 sets
        for (int i = 1; i < arr.length; i++){
            //traverse elements in the 5 sets, 2 elements per set
            for (int j = i - 1; j >= 0; j -= 1){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("after the iteration 3 of shell sort: " + Arrays.toString(arr));

         */
    }

    public static void shellSort2(int[] arr){

        //increment "gap"
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++){
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]){
                    while(j - gap >= 0 && temp < arr[j - gap]){
                        //move
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }

    }
}
