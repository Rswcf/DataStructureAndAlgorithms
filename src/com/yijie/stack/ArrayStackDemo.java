package com.yijie.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //test
        //create an ArrayStack
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//control whether to quit the menu

        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: show the stack");
            System.out.println("exit: exit the stack");
            System.out.println("push: push the item to stack");
            System.out.println("pop: pop the item from stack");
            System.out.println("please enter your option:");

            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("please enter an integer:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("the poped value is %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                default:
                    break;
            }

        }
        System.out.println("program ends!");
    }
}

//define an ArrayStack
class ArrayStack {
    private int maxSize;//size of the stack
    private int[] stack;//stack
    private int top = -1;//initialize top to -1

    //constructor
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //determine if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //determine if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    //push
    public void push(int value) {
        if (isFull()) {
            System.out.println("the stack is full!");
            return;
        }
        top++;
        stack[top] = value;
    }

    //pop
    public int pop() {
        if (isEmpty()) {
            //throw an exception
            throw new RuntimeException("stack is empty!");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //traverse the stack
    public void list() {
        if (isEmpty()) {
            System.out.println("the stack is empty!");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] is %d\n", i, stack[i]);
        }
    }
}