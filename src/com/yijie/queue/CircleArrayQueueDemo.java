package com.yijie.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {

        //test
        //create a circle queue
        CircleArray queue = new CircleArray(4);
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

class CircleArray {
    private int maxSize;// maximum size of the queue

    //front points to the first item of the queue, i.e. arr[front] is the head of the queue
    //initialize front = 0
    private int front;

    //rear points to the next position of the last item in the queue
    //initialize rear = 0
    private int rear;

    private int[] arr;//used to store the values

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //determine if the queue is full
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //determine if the queue is empty
    public boolean isEmpty() {
        return rear == front;
    }

    //add the item to the queue
    public void addQueue(int n) {
        //determin if full
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //get the item of the queue
    public int getQueue() {
        //determine if empty
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, can't get the data!");
        }
        //1. assign the value of front to a temporary variable
        //2. move the front to the next position, considering %
        //3. return the temporary variable
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //display all the values of the queue
    public void showQueue() {
        //traverse
        if (isEmpty()) {
            System.out.println("Empty!");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //figure out the effective number of the items in the queue
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // display the items at the head of the queue, not get
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty!");
        }
        return arr[front];
    }
}
