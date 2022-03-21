package com.yijie.sort;

import java.util.Arrays;

public class InsertionSort {
    /*
    Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.
    The array is virtually split into a sorted and an unsorted part.
    Values from the unsorted part are picked and placed at the correct position in the sorted part.
     */
    public static void main(String[] args) {
        //Test
        int[] arr = {101, 34, 119, 1};
        System.out.println("before insertion sort: " + Arrays.toString(arr));

        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {

        //element to be inserted
        int insertElem;
        int insertIndex;

        for (int i = 1; i < arr.length; i++) {
            insertElem = arr[i];
            insertIndex = i - 1;

            while (insertIndex >= 0 && insertElem < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //if break from the while loop, the position to insert has been found
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertElem;
            }

            System.out.printf("after the iteration %d: " + Arrays.toString(arr) + "\n", i);
        }
    }

}
