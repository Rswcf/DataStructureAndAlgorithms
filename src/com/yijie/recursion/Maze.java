package com.yijie.recursion;

public class Maze {
    public static void main(String[] args) {

        //create a two-dimensional array to simulate the maze
        int[][] map = new int[8][7];
        //use number 1 to represent the wall
        //set the top and bottom side of the maze to 1
        for (int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //set the left and right side of the maze to 1
        for (int j = 0; j < 8; j++){
            map[j][0] = 1;
            map[j][6] = 1;
        }

        //set the wall in the maze
        map[3][1] = 1;
        map[3][2] = 1;

        //show the maze
        System.out.println("the current map:");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //use recursion to reach the final position
        setWay(map, 1, 1);
        //show the new maze
        System.out.println("the current map:");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    //use the recursion to find the path
    //1. map represents the maze
    //2. (i,j)represents the place to begin
    //3. if finally reaching the map[6][5], finished
    //4. agreement: if map[i][j] = o the position hasn't been walked, = 1 means there is a wall at the position
    //   =2 means the position can be walked, = 3 means the position has benn walked and shows not to be the right position
    //5. when walking in the maze, a strategy should be set up (down -> right -> up -> left), if does'n work, recursion
    /*
    @param map represents the map
    @param i i and j represent the place where the path searching begins
    @param i
    @return if the path is found, return true, if not return false
     */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){//reaching the final point
            return true;
        } else {
            if (map[i][j] == 0){//hasn't been walked, execute the strategy
                //strategy: down -> right -> up -> left
                map[i][j] = 2;
                if (setWay(map, i + 1, j)){
                    //down
                    return true;
                } else if (setWay(map, i, j +1)){
                    return true;
                }else if (setWay(map, i - 1, j)){
                    return true;
                } else if (setWay(map, i, j - 1)){
                    return true;
                } else {
                    //the position is a dead end
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //if map[i][j] != 0, may be 1, 2, 3
                return false;
            }
        }
    }
}
