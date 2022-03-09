package com.yijie.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //test
        System.out.println("The test of DoubleLinkedList: ");
        HeroNode2 hero1 = new HeroNode2(1, "superman", "sup");
        HeroNode2 hero2 = new HeroNode2(2, "batman", "bat");
        HeroNode2 hero3 = new HeroNode2(3, "antman", "ant");
        HeroNode2 hero4 = new HeroNode2(4, "ironman", "iron");

        //add to Linkedlist

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
        System.out.println();

        //test the update
        HeroNode2 hero5 = new HeroNode2(4, "dogman", "dog");
        doubleLinkedList.update(hero5);

        doubleLinkedList.list();
        System.out.println();

        //test the delete
        doubleLinkedList.del(3);

        doubleLinkedList.list();


    }
}

//create a DoubleLinkedList class
class DoubleLinkedList {
    //initialize the head node
    private HeroNode2 head = new HeroNode2(0, "", "");

    //return the head node
    private HeroNode2 getHead() {
        return head;
    }

    //traverse the double linked list
    public void list() {
        //determine if null
        if (head.next == null) {
            System.out.println("linkedlist is empty!");
            return;
        }
        //build an auxiliary variable
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //output the info of the node
            System.out.println(temp);
            temp = temp.next;

        }
    }

    //add Node to the end of the double linked list
    //1. find the last node of the linked list
    //2. let the "next" of the last node point to the new node
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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
        heroNode.pre = temp;
    }

    //update the data of the node, keep the no of the node unchanged
    public void update(HeroNode2 newHeroNode) {
        //determine if empty
        if (head.next == null) {
            System.out.println("the Linkedlist is null!");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//indicates whether the node is found
        while (true) {
            if (temp == null) {
                //at the rear of the linked list
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("no node found, node %d can't be updated!", newHeroNode.no);
        }
    }

    //delete the node
    //1. for double linked list we can directly find the node
    //2. delete the node
    public void del(int no) {

        //determine if empty
        if (head.next == null) {
            System.out.println("linked list is empty, the node can't be deleted");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;//indicated whether the node is found
        while (true) {
            if (temp == null) {//rear of the linked list
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //RISK!!!IF THE TEMP MOVES TO THE END OF THE LINKED LIST
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.printf("the node %no doesn't exist!", no);
        }
    }


}

//define a HeroNode2, every HeroNode is a node
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//pointing to the next node
    public HeroNode2 pre;//pointing to the previous node

    //constructor
    public HeroNode2(int hNo, String hName, String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;

    }

    //for display purpose, redefine the toString method
    @Override
    public String toString() {
        return "HeroNode2 [no= " + no + ", name= " + name + ", nickname= " + nickname + "]";
    }
}