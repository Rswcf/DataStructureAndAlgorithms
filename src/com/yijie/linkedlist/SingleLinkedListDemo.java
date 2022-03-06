package com.yijie.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "superman", "sup");
        HeroNode hero2 = new HeroNode(2, "batman", "bat");
        HeroNode hero3 = new HeroNode(3, "antman", "ant");
        HeroNode hero4 = new HeroNode(4, "ironman", "iron");

        //add to Linkedlist

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //singleLinkedList.add(hero1);
        //singleLinkedList.add(hero4);
        //singleLinkedList.add(hero2);
        //singleLinkedList.add(hero3);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //test the update
        HeroNode hero5 = new HeroNode(3, "dogman", "dog");
        singleLinkedList.update(hero5);


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
            if (temp == null) {
                break;
            }
            //output the info of the node
            System.out.println(temp);
            temp = temp.next;

        }
    }

    public void addByOrder(HeroNode heroNode) {
        //because the head is fixed, we need an auxiliary variable/pointer to help find the position
        //due to singleLinkedList, the temp should be located at the previous position of the being added item
        HeroNode temp = head;
        boolean flag = false;//indicates whether the to be added item already exists, default = false
        while (true) {
            if (temp.next == null) {
                //the auxiliary variable is located now at the rear of the singleLinkedList
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;//indicates that the item already exists
                break;
            }
            temp = temp.next;//move to the next position, traverse
        }

        //according to the value of the flag
        if (flag) {
            System.out.printf("the new item can`t be added because the node number %d already exists", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;

        }

    }
    //update the data of the node, keep the no of the node unchanged
    public void update(HeroNode newHeroNode){
        //determine if null
        if(head.next == null){
            System.out.println("the Linkedlist is null!");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;//indicates whether the node is found
        while (true){
            if (temp.next == null){
                //at the rear of the Linkedlist
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else{
            System.out.printf("no node found, node %d can't be updated!", newHeroNode.no);
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