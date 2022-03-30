package com.yijie.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {

        //int[] arr = {4, 6, 8, 5, 9};
        int[] arr = new int[1000000
                ];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * arr.length);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("time before execution: " + date1Str);

        //TEST
        //System.out.println("before heap sort:" + Arrays.toString(arr));

        for (int i = arr.length / 2 - 1; i >=0; i--){
            adjustToHeap(arr, i, arr.length);
        }

        //System.out.println("after heap sort:" + Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("time after execution: " + date2Str);
    }

    //Method Heap Sort
    public static void heapSort(int[] arr){
        System.out.println("heap sort!");
        int temp = 0;
        for (int j = arr.length - 1; j >= 0; j--){
            //SWAP
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustToHeap(arr, 0, j);
        }
    }

    //Adjust the tree (binary tree) to a max heap

    /**
     * Functionality of the Method: adjust the sub-tree of the non-leaf method to a max heap
     * @param arr the array to be adjusted
     * @param i the index of the non-leaf node
     * @param length the number of nodes left to be adjusted
     */
    public static void adjustToHeap(int[] arr, int i, int length){
        int temp = arr[i];

        //1. k = i * 2 + 1 is the left child node of the node i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){
            //pick out the largest child nodes
            if (k + 1 < length && arr[k] < arr[k + 1]){
                k++;
            }

            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k; //i points to k
            } else {
                break;
            }
            arr[i] = temp;
        }

    }
}
