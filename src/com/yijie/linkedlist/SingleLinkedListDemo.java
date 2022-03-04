package com.yijie.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "superman", "sup");
        HeroNode hero2 = new HeroNode(2, "batman", "bat");
        HeroNode hero3 = new HeroNode(3, "antman", "ant");
        HeroNode hero4 = new HeroNode(4, "ironman", "iron");

        //add to Linkedlist
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();


    }
}

//Define a SingleLinkedList to manage the heros
class SingleLinkedList {
    //initialize the head node
    private HeroNode head = new HeroNode(0, "", "");

    //add Node
    //1. find the last node of the linkedlist
    //2. let the "next" of the last node point to the new node
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        //traverse to find the last node
        while (true) {
            //if the last node
            if (temp.next == null) {
                break;
            }
            //if node the last node
            temp = temp.next;
        }
        temp.next = heroNode;

    }

    public void list() {
        //determine if null
        if (head.next == null) {
            System.out.println("linkedlist is empty!");
            return;
        }
        //build an auxiliary variable
        HeroNode temp = head.next;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //output the info of the node
            System.out.println(temp);
            temp = temp.next;

        }
    }
}

//define a HeroNode, every HeroNode is a node
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//pointing to the next node

    //constructor
    public HeroNode(int hNo, String hName, String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;

    }

    //for display purpose, redefine the toString method
    @Override
    public String toString() {
        return "HeroNode [no= " + no + ", name= " + name + ", nickname= " + this.nickname + "]";
    }
}