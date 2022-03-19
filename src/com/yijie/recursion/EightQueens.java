package com.yijie.recursion;

public class EightQueens {
    /*
    The eight queens puzzle is the problem of placing eight chess queens on an 8×8 chessboard so that no two queens threaten each other;
    thus, a solution requires that no two queens share the same row, column, or diagonal.
    There are 92 solutions. The problem was first posed in the mid-19th century.
    In the modern era, it is often used as an example problem for various computer programming techniques.
     */

    //number of queens
    int max = 8;
    //array to store the position data of eight queens, for example: array = {0, 4, 7, 5, 2, 6, 1, 3}

    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        //TEST
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println("the number of solutions is; " + count);

    }

    // Method: to place the n-th queen on the chessboard
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        // place the queen to different positions and evaluate the position
        for (int i = 0; i < max; i++) {
            //place the queen to the first column of the row
            array[n] = i;
            //evaluate the position, of ok, place the next queen
            if (evaluate(n)) {
                check(n + 1);
            }
        }
    }

    //evaluate if the n-th queen threatens the former queens or not
    private boolean evaluate(int n) {

        for (int i = 0; i < n; i++) {
            //1. array[i] == array[n], the two queens are in the same column
            //2. Math.abs(n - i) == Math.abs(array[n] - array[i])), the two queens are in the same diagonal
            // e.g. the second queen is located in the second row, the second column.
            // n = 1, array[1] = 1
            // Math.abs(n - 0) = 1, Math.abs(array[n] - array[0])) = Math.abs(1 - 0) = 1
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;

    }

    //method to print the position of queens
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
