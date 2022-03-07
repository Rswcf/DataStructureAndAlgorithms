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
        System.out.println();

        //test the delete()
        singleLinkedList.del(2);
        System.out.println("the SingleLinkedList after deletion is: \n");
        singleLinkedList.list();

        //test the getLength()
        System.out.println("the length of the singleLinkedList: " + getLength(singleLinkedList.getHead()));

        //test the findLastIndexNode()
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println(res);
    }

    //Question: get the number of the nodes in the linked list (if head node exists, don't count)
    /*
    @param head=>head of the linkedlist
    @return=>number of the nodes
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //define a auxiliary variable
        HeroNode cur = head.next;

        while (cur != null) {
            length++;
            cur = cur.next;//traverse
        }
        return length;
    }

    //Question:  get the k-th node from the last of a linked list
    /*
    1.create a method to receive the head and the index simultaneously
    2.index indicates the index-th node from the last of the linked list
    3.traverse the linked list and get the length
    4.after getting the size, traverse (size - index) items
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //if empty return null
        if (head.next == null) {
            return null;
        }
        //first traverse, get the length of the linked list
        int size = getLength(head);
        //second traverse, to the position of (size - index), i.e. the index-th item from teh last
        if (index <= 0 || index > size) {
            return null;
        }
        //create a auxiliary variable
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

}

//Define a SingleLinkedList to manage the heros
class SingleLinkedList {
    //initialize the head node
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

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
    public void update(HeroNode newHeroNode) {
        //determine if null
        if (head.next == null) {
            System.out.println("the Linkedlist is null!");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;//indicates whether the node is found
        while (true) {
            if (temp.next == null) {
                //at the rear of the Linkedlist
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
    //1. keep the head node, use the auxiliary node to find the previous node of the to be deleted node
    //2. compare the temp.next.no and the no of the to be deleted node
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//indicated whether the node is found
        while (true) {
            if (temp.next == null) {//rear of the linkedlist
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("the node %no doesn't exist!", no);
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