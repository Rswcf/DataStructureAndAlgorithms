package com.yijie.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {

        //the prerequisite of the binary search is that the array is already sorted
        int[] arr = {1,2,8,14,55,55,77,77,109,999};
        List<Integer> resIndexList = binarySearch(arr, 0, arr.length - 1, 14);
        System.out.println("resIndexList = " + resIndexList);
    }

    //Binary Search

    /***
     *
     * @param arr array
     * @param left left index
     * @param right right index
     * @param findVal the value to be searched
     * @return if found, return the index of the value, if not found, return -1
     */
    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        ArrayList<Integer> resIndexList;
        if (findVal > midVal) {//recursion to the right
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            /*
            1. find the index of the mid
            2. Scan continually to the left of the mid, add all the elements which fulfill the requirements to the ArrayList
            3. Scan continually to the right of the mid, add all the elements which fulfill the requirements to the ArrayList
            4. return the ArrayList
             */
            resIndexList = new ArrayList<Integer>();

            // Scan continually to the left of the mid, add all the elements which fulfill the requirements to the ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);

            // Scan continually to the right of the mid, add all the elements which fulfill the requirements to the ArrayList
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            resIndexList.add(mid);
        }
        return resIndexList;
    }
}
