package com.yijie.stack;

public class Calculator {
    //Stack based calculator
    public static void main(String[] args) {
        String expression = "111+2*3-2";

        //Create a number stack and an operator stack for storing numbers and operators respectively
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //define the relevant variables
        int index = 0;//for scanning
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        // while loop to scan the expression
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            //execute the corresponding response according to ch
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    //If current element is an operator and its priority level lower than or equal to the operand in the stack,
                    //pop last two operands from number stack, apply operator and push the result back to the stack
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //push the calculation result to the number stack
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                //if number, push to the numStack
                //handling the multi-digit numbers
                keepNum += ch;

                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //RESET keepNum!!!
                        keepNum = "";
                    }
                }

            }

            //index + 1, determine if to the last element of the expression
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //if the scan of the expression is over,
        // pop the items sequentially from the number stack and operator stack, execute the calculation
        while (true) {
            //if the operator stack is empty, then there will be only one number in the number stack
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("expression %s=%d\n", expression, numStack.pop());
    }
}

//create a stack
class ArrayStack2 {
    private int maxSize;//size of the stack
    private int[] stack;//stack
    private int top = -1;//initialize top to -1

    //constructor
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //return the item at the top of the stack but not pop
    public int peek() {
        return stack[top];
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

    //return the priority levels of the operators, the priority levels are expressed with the numbers
    //the greater the number, the higher the priority
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;//suppose we only have +, -, * /
        }
    }

    //determine if it is an operator
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //calculating methodology
    public int cal(int num1, int num2, int oper) {
        //store the calculating result
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;

        }
        return res;
    }

}