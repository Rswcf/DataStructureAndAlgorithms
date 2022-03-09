package com.yijie.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {

        //test
        //create a queue
        ArrayQueue queue = new ArrayQueue(4);
        char key = ' ';//receive the user input
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //output a menu
        while (loop) {
            System.out.println("s(show): display the queue");
            System.out.println("e(exit): quit");
            System.out.println("a(add): add data to the queue");
            System.out.println("g(get): get the data from the queue");
            System.out.println("h(head): display the head of the queue");
            key = scanner.next().charAt(0);//receive the user input
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("Please enter a whole number:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("The fetched data is: %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("The head is: %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://quit
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Program ends!");
    }
}

//use array to build a queue: ArrayQueue
class ArrayQueue {
    private int maxSize;// maximum size of the queue
    private int front;//the front of the queue
    private int rear;//the rear of the queue
    private int[] arr;//used to store the values

    //create the constructor of the queue
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//point to the head of the queue,i.e. to the previous position at the head of the queue
        rear = -1;//point directly to the rear of the queue, i.e. to the last position of the queue
    }

    //determine if the queue is full
    public boolean isFull() {
        return rear == maxSize - 1;

    }

    //determine if the queue is empty
    public boolean isEmpty() {
        return rear == front;
    }

    //add the item to the queue
    public void addQueue(int n) {
        //determine if full
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //get the item of the queue
    public int getQueue() {
        //determine if empty
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, can't get the data!");
        }
        front++;//move the front to the next position
        return arr[front];
    }

    //display all the values of the queue
    public void showQueue() {
        //traverse
        if (isEmpty()) {
            System.out.println("Empty!");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // display the items at the head of the queue, not get
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty!");
        }
        return arr[front + 1];
    }

}