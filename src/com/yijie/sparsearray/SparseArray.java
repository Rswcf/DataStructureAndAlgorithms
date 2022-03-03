package com.yijie.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //create a original two-dimensional array 11*11
        //0:
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("Original twp-dimensional array: ");
        //output the original two-dimensional array
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // transfer the two-dimensional array to sparse array
        // 1. traverse the two-dimensional array to get the number of non-zero items
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum: " + sum);

        //2.create the corresponding sparse matrix
        int sparseArr[][] = new int[sum + 1][3];
        //assign the values to sparse array
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //traverse the two-dimensional array and store the non-zero items in the sparse array
        int count = 0;//counter: records the order of the non-zero item
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //output the sparse array
        System.out.println();
        System.out.println("the sparse array: ");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        //reverse the sparse array => original two-dimensional array
        /*
        1. read the first row of the sparse array, create the corresponding two-dimensional array
        2. read the following rows of the sparse array and assign the non-zero values tom two-dimensional array
         */

        //1. read the first row of the sparse array, create the corresponding two-dimensional array

        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][0]];

        //2. read the following rows of the sparse array and assign the non-zero values tom two-dimensional array

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println();
        //output the recovered two-dimensional array

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }
}
