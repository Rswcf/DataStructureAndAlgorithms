package com.yijie.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectionSort {
    public static void main(String[] args) {
        //Test
        //int[] arr = {101, 34,119, 1};

        //create a array with 80000 random numbers
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        //System.out.println("array before selection sort is: " + Arrays.toString(arr));
        //time before sort
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("time before bubble sort: " + date1Str);

        selectionSort(arr);

        //time after sort
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("time after bubble sort: " + date2Str);

    }

    //Selection sort
    public static void selectionSort(int[] arr) {

        int minIndex;
        int min;

        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[minIndex];

            for (int j = 0 + i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];//Reset min and minIndex
                    minIndex = j;
                }
            }
            //swap the smallest number to the first position
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //System.out.printf("array after iteration %d: " + Arrays.toString(arr) + "\n", i + 1);
        }

        /*
        //Iteration 1
        int minIndex = 0;
        int min = arr[0];

        for (int j = 0 + 1; j < arr.length; j++){
            if (arr[j] < min){
                min = arr[j];//Reset min and minIndex
                minIndex = j;
            }
        }
        //swap the smallest number to the first position
        arr[minIndex] = arr[0];
        arr[0] = min;
        System.out.println("array after iteration 1: " + Arrays.toString(arr));


        //Iteration 2
        minIndex = 1;
        min = arr[1];

        for (int j = 0 + 2; j < arr.length; j++){
            if (arr[j] < min){
                min = arr[j];//Reset min and minIndex
                minIndex = j;
            }
        }
        //swap the smallest number to the first position
        arr[minIndex] = arr[1];
        arr[1] = min;
        System.out.println("array after iteration 1: " + Arrays.toString(arr));


        //Iteration 3
        minIndex = 2;
        min = arr[2];

        for (int j = 0 + 3; j < arr.length; j++){
            if (arr[j] < min){
                min = arr[j];//Reset min and minIndex
                minIndex = j;
            }
        }
        //swap the smallest number to the first position
        arr[minIndex] = arr[2];
        arr[2] = min;
        System.out.println("array after iteration 1: " + Arrays.toString(arr));
        */

    }
}
