package com.yijie.search;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};
        int index = linearSearch(arr, 11);
        if (index == -1) {
            System.out.println("target not found");
        } else {
            System.out.println("the index of the target = " + index);
        }
    }

    public static int linearSearch(int[] arr, int value) {
        //sequentially check each element of the list until a match is found or the whole list has been searched
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
