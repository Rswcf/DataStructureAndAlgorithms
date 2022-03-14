package com.yijie.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        //define a suffix expression
        //(3+4)*5-6 => 3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 6 * 6 - ";
        //1. put the "3 4 + 5 * 6 -" into the ArrayList
        //2. Pass the ArrayList to a method，which works with the stack to complete the calculation
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);

        int res = calculate(rpnList);
        System.out.println("the result of the calculation is: ");
        System.out.println(res);
    }

    //put the numbers and operators of suffix expression into the ArrayList
    public static List<String> getListString(String suffixExpression){
        //split the suffixExpression
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split){
            list.add(ele);
        }
        return list;
    }

    /*
    Execute the calculation of a suffix expression
    1.read expression from left to right, if number, push into stack
    2.if operand, pop two numbers from the stack and execute the calculation


     */
    public static int calculate(List<String> ls){
        //create a stack
        Stack<String> stack = new Stack<String>();
        //traverse ls
        for (String item : ls) {
            //use regular expression to get the number
            if (item.matches("\\d+")) {
                //push into the stack
                stack.push(item);
            } else {
                //pop two numbers and calculate
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("operand error");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());

    }

}
