package com.yijie.hashtable;

import java.util.Locale;
import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        //TEST
        HashTable hashTable = new HashTable(8);

        //create a menu to test the hashtable
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: add employee");
            System.out.println("list: show employees");
            System.out.println("search: search employee");
            System.out.println("exit: quit");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("enter the id:");
                    int id = scanner.nextInt();
                    System.out.println("enter the name:");
                    String name = scanner.next();
                    Employee employee = new Employee(id, name);
                    hashTable.add(employee);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "search":
                    System.out.println("enter the id to be searched in hash table:");
                    id = scanner.nextInt();
                    hashTable.searchEmployeeById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//Create the HashTable to manage the several linked lists
class HashTable {
    private EmployeeLinkedList[] employeeLinkedLists;
    private int size;

    //constructor
    public HashTable(int size) {
        this.size = size;
        //initialize the employeeLinkedLists
        employeeLinkedLists = new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }
    }

    //add employees
    public void add(Employee employee) {
        int emloyeeLinkedListNum = hashFun(employee.id);
        //add the employee to the corresponding linked list
        employeeLinkedLists[emloyeeLinkedListNum].add(employee);
    }

    //traverse the linked list
    public void list() {
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i].list(i);
        }
    }

    //search the employee by id
    public void searchEmployeeById(int id) {
        int employeeLinkedListNum = hashFun(id);
        Employee employee = employeeLinkedLists[employeeLinkedListNum].searchEmployeeById(id);

        if (employee != null) {
            System.out.printf("the employee is found in the linked list %d, the id = %d", employeeLinkedListNum, employee.id);
        } else {
            System.out.println("the employee is not found in the hash table!");
        }
    }

    public int hashFun(int id) {
        return id % size;
    }
}

class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//create a EmployeeLinkedList
class EmployeeLinkedList {
    //head pointing to the first Employee
    private Employee head;

    //add Employees to the linked list
    public void add(Employee employee) {
        //suppose id increases with the number of employees
        //when adding the first employee
        if (head == null) {
            head = employee;
            return;
        }
        //when continually adding the employees after the first employee
        Employee curEmployee = head;
        while (true) {
            if (curEmployee.next == null) {
                break;
            }
            curEmployee = curEmployee.next;
        }
        //add the new employee to the end
        curEmployee.next = employee;
    }

    //traverse the employee
    public void list(int num) {
        if (head == null) {
            System.out.println("the linked list " + num + " is empty!");
            return;
        }
        System.out.println("the linked list " + num + " includes:");
        Employee curEmployee = head;
        while (true) {
            System.out.printf("=> id = %d name = %s\n", curEmployee.id, curEmployee.name);
            if (curEmployee.next == null) {
                break;
            }
            curEmployee = curEmployee.next;
        }
    }

    //search the employee by id
    public Employee searchEmployeeById(int id) {
        if (head == null) {
            System.out.println("the linked list is empty!");
            return null;
        }
        Employee curEmployee = head;
        while (true) {
            if (curEmployee.id == id) {
                break;
            }
            if (curEmployee.next == null) {
                System.out.println("the employee is not found in the current linked list");
                break;
            }
            curEmployee = curEmployee.next;
        }
        return curEmployee;
    }
}