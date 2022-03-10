package com.yijie.linkedlist;

public class JosephuProblem {
    public static void main(String[] args) {
        //test the CircleSingleLinkedList
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(1000);

        circleSingleLinkedList.showBoy();

        //test the countBoy
        circleSingleLinkedList.countBoy(1,5,1000);

    }
}

//Create a CircleSingleLinkedList
class CircleSingleLinkedList {
    //create a "first" node, without no
    private Boy first = new Boy(-1);

    //add the Boy Node to build a circle single linked list
    public void addBoy(int num) {
        //validate the data
        if (num < 1) {
            System.out.println("the value of num isn't correct!");
            return;
        }
        //auxiliary variable
        Boy cur = null;
        //use the for loop to build the circle single linked list
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }

        }

    }

    //traverse the circle linked list
    public void showBoy() {
        //determine if empty
        if (first == null) {
            System.out.println("the linked list is empty!");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.println("the no of the boy: " + cur.getNo());
            if (cur.getNext() == first) {
                //traverse if finished
                break;
            }
            cur = cur.getNext();
        }
    }

    //according to the user input, count the order that the boys goes out of the circle
    /*
    @param startNo: the node from which the count starts
    @param countNum: the number of counts
    @param nums: indicates how many boys in the circle at first
     */
    public void countBoy(int startNo, int countNum, int nums){
        //validate
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("the input parameters are wrong!");
            return;
        }
        //auxiliary pointers/variables
        Boy helper = first;
        while (true){
            if(helper.getNext() == first){
                //helper points to the last node in the circle linked list
                break;
            }
            helper = helper.getNext();
        }
        // move the first and helper nodes k - 1 times
        for (int j = 0; j < startNo - 1; j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //move the first and helper ndoes m - 1 times
        //iterate until there is only one node left
        while (true){
            if (helper == first){
                break;
            }
            for (int j = 0; j < countNum -1; j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //the node to be out
            System.out.printf("the node %d is out\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("the last one is %d ", helper.getNo());

    }
}


//Create a Class BOY, i.e. a node
class Boy {
    private int no;
    private Boy next;//default null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return this.next;
    }

    public void setNext(Boy boy) {
        this.next = boy;
    }
}