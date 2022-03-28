package com.yijie.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //create a binary tree
        BinaryTree binaryTree = new BinaryTree();
        //create the nodes
        HeroNode root = new HeroNode(1, "superman");
        HeroNode node2 = new HeroNode(2, "batman");
        HeroNode node3 = new HeroNode(3, "antman");
        HeroNode node4 = new HeroNode(4, "ironman");
        HeroNode node5 = new HeroNode(5, "pigman");

        //manually organize the binary tree
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //TEST
        //pre-order reversal
        System.out.println("pre-order reversal:");
        binaryTree.preOrder(); //exp. output: 1, 2, 3, 5, 4

        //in-order reversal
        System.out.println("in-order reversal:");
        binaryTree.inOrder(); //exp. output: 2, 1, 5, 3, 4

        //post-order reversal
        System.out.println("post-order reversal:");
        binaryTree.postOrder(); //exp. output: 2, 5, 4, 3, 1

        //pre-order search
        System.out.println("pre-order search:");
        HeroNode resNode = binaryTree.preOrderSearch(5); //exp. output: 1, 2, 3, 5, 4
        if (resNode != null){
            System.out.printf("the hero is found! no = %d name = %s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.println("the hero is not found!" );
        }

        //in-order search
        System.out.println("in-order search:");
        resNode = binaryTree.inOrderSearch(5); //exp. output: 1, 2, 3, 5, 4
        if (resNode != null){
            System.out.printf("the hero is found! no = %d name = %s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.println("the hero is not found!" );
        }

        //pre-order search
        System.out.println("post-order search:");
        resNode = binaryTree.postOrderSearch(5); //exp. output: 1, 2, 3, 5, 4
        if (resNode != null){
            System.out.printf("the hero is found! no = %d name = %s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.println("the hero is not found!" );
        }
    }
}

//define BinaryTree class
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //pre-oder traversal
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("the binary tree is empty!");
        }
    }

    //in-oder traversal
    public void inOrder() {
        if (this.root != null) {
            this.root.inOrder();
        } else {
            System.out.println("the binary tree is empty!");
        }
    }

    //post-oder traversal
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("the binary tree is empty!");
        }
    }

    //pre-oder search
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //in-oder search
    public HeroNode inOrderSearch(int no) {
        if (this.root != null) {
            return this.root.inOrderSearch(no);
        } else {
            return null;
        }
    }

    //post-oder search
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

//define HeroNode class
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //default null
    private HeroNode right; //default null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //Pre-Order Traversal in Binary Search Trees
    public void preOrder() {
        System.out.println(this);//display the current node
        //traverse the left sub-tree
        if (this.left != null) {
            this.left.preOrder();
        }
        //traverse the right sub-tree
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //In-Order Traversal in Binary Search Trees
    public void inOrder() {
        //traverse the left sub-tree
        if (this.left != null) {
            this.left.inOrder();
        }
        //display the current node
        System.out.println(this);
        //traverse the right sub-tree
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    //Post-Order Traversal in Binary Search Trees
    public void postOrder() {
        //traverse the left sub-tree
        if (this.left != null) {
            this.left.postOrder();
        }
        //traverse the right sub-tree
        if (this.right != null) {
            this.right.postOrder();
        }
        //display the current node
        System.out.println(this);
    }

    //Pre-Order Search in Binary Search Trees
    public HeroNode preOrderSearch(int no) {
        if (this.no == no){
            return this;
        }

        HeroNode resNode = null;

        //traverse the left sub-tree to search the target
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        //traverse the right sub-tree
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //In-Order Search in Binary Search Trees
    public HeroNode inOrderSearch(int no) {

        HeroNode resNode = null;

        //traverse the left sub-tree to search the target
        if (this.left != null) {
            resNode = this.left.inOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        if (this.no == no){
            return this;
        }

        //traverse the right sub-tree
        if (this.right != null) {
            resNode = this.right.inOrderSearch(no);
        }
        return resNode;
    }

    //In-Order Search in Binary Search Trees
    public HeroNode postOrderSearch(int no) {

        HeroNode resNode = null;

        //traverse the left sub-tree to search the target
        if (this.left != null) {
            resNode = this.left.inOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        //traverse the right sub-tree
        if (this.right != null) {
            resNode = this.right.inOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        if (this.no == no){
            return this;
        }

        return resNode;
    }

}
