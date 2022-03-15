package com.yijie.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        //infix expression => suffix expression
        /*
        1. turn the infix expression into a List
        2. for example: "1+((2+3)*4)-5" => ArrayList [1, +, (, (, 2, +,3, ), *, 4, ), -, 5]
        3. turn the list of a infix expression to a list of suffix expression
         */
        String expression = "1+((2+3)*4)-5";
        System.out.println("the original infix expression is: " + expression);

        List<String> infixExpression = toInfixExpressionList(expression);
        System.out.println("the extracted list of infix expression is:");
        System.out.println(infixExpression);

        List<String> parseSuffixExpression = parseSuffixExpressionList(infixExpression);
        System.out.println("the extracted list of suffix expression is: ");
        System.out.println(parseSuffixExpression);


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

    //Method: turn the infix expression list to suffix expression list
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //create two stacks => one stack and one list
        Stack<String> s1 = new Stack<String>();//to store the operators

        //Stack<String> s2 = new Stack<String>();//to temporally store the process data, but for purpose of convenience just replace one stack with a list
        List<String> s2 = new ArrayList<String>();

        //traverse the list
        for (String item : ls) {
            //if the item is a number, push into the s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//pop the "("
            } else {
                //if the priority level of the item not greater than the operator at the top of the s1, pop the operator
                //at the top of stack and push into the s2.
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //pop the remaining items in s1 and push them to s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }


    //Method: Transfer the infix expression to suffix expression
    public static List<String> toInfixExpressionList(String s) {
        //Define a List to store the infix expression
        List<String> ls = new ArrayList<String>();
        int i = 0;//pointer used to traverse the infix expression
        String str;//concatenate the multi-digit number
        char c;//the traversed digit will be put into the char
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {//if number, consider if that could be a multi-digit number
                str = "";
                while (i < s.length() && ((c = s.charAt(i)) >= 48) && ((c = s.charAt(i)) <= 57)) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());


        return ls;

    }

    //put the numbers and operators of suffix expression into the ArrayList
    public static List<String> getListString(String suffixExpression) {
        //split the suffixExpression
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    /*
    Execute the calculation of a suffix expression
    1.read expression from left to right, if number, push into stack
    2.if operand, pop two numbers from the stack and execute the calculation


     */
    public static int calculate(List<String> ls) {
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

//Class Operation, which returns the priority level of the corresponding operator
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //Method to return the priority level (number)
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("operator doesn't exist!");
                break;
        }
        return result;
    }
}