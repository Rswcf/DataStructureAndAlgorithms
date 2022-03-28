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

        //deletion
        System.out.println("before deletion:");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("after deletion:");
        binaryTree.preOrder();
    }
}

//define BinaryTree class
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //delete the node
    public void delNode(int no){
        if (this.root != null){
            if (this.root.getNo() == no){
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("The tree is empty and can not be deleted!");
        }
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

    //DELETION
    //1. if the node to be deleted is a leaf node, just delete the node
    //2. if the node to be deleted is a non-leaf node, delete the whole sub-tree

    public void delNode(int no){
        /**
         * Consider: If the tree is empty, there is only a `root` node and set it to be null
         *
         * 1. Since the binary tree is unidirectional, we should **determine whether the children of the current node need to be
         *    deleted**, rather than determining whether the current node is a node to be deleted.
         * 2. If the left child of the current node is not empty and is the node to be deleted, `this.left = null`, return
         * 3. if the right child of the current node are not empty and is the node is to be deleted, `this.right = null`, return
         * 4. If no nodes have been deleted during the second and the third step, then recursive deletion to the left subtree
         * 5. If the fourth step does not delete the node, recursive deletion to the right subtree
         */
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }
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
