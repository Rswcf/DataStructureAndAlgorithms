package com.yijie.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {

//        int[] array = {3, 9, -1, 10, -2};

        //Test the bubbleSort

        //create a array with 80000 random numbers
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 80000);
        }
        //System.out.println("the array before bubble sort: " + Arrays.toString(array));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("time before bubble sort: " + date1Str);

        bubbleSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("time after bubble sort: " + date2Str);

    }

    public static void bubbleSort(int[] array) {

        int temp = 0;//auxiliary variable
        boolean flag = false;
        //Iteration: swap the x-th largest number in the array to the x-th position from the bottom
        //Time Complexity of the bubble sort: O(n) = n^2

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if (!flag) {
                break;
            } else {
                flag = false;//RESET flag
            }
        }
        //System.out.println("the array after bubble sort: " + Arrays.toString(array));
    }
}
