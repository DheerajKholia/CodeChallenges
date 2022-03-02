package com.dheeraj.hackerrank.trees;

public class BinarySearchTree {
    Node root;

    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        System.out.println(bst);

    }
    public void insert(int value){
        Node newNode=new Node(value,null,null);
        if(root==null){
            root=newNode;
        }else{
            Node currentNode=root;
            while (true){
                if(value< currentNode.data){
                    if(currentNode.left==null){
                        currentNode.left=newNode;
                        return;
                    }
                    currentNode=currentNode.left;
                } else {
                    if(currentNode.right==null){
                        currentNode.right=newNode;
                        return;
                    }
                    currentNode=currentNode.right;
                }
            }
        }
    }

    public Node lookup(int value){
        if(root==null){
            return null;
        }
        Node currentNode=root;
        while(currentNode!=null){
            if(value < currentNode.data){
                currentNode=currentNode.left;
            }else if(value > currentNode.data){
                currentNode=currentNode.right;
            }else if(currentNode.data==value){
                return currentNode;
            }
        }
        return currentNode;
    }
    public void remove(int value){
        if(root==null){
            return;
        }
        Node currentNode=root;
        Node parentNode=null;
        while(currentNode!=null){
            if(currentNode.data<value){
                parentNode=currentNode;
                currentNode=currentNode.right;
            }else if(currentNode.data>value){
                parentNode=currentNode;
                currentNode=currentNode.left;
            }else if(currentNode.data==value){
                //We have a match, get to work!

                //Option 1: No right child:
                if(currentNode.right==null){
                    if(parentNode==null){
                        root=currentNode.left;
                    } else {
                        //if parent > current value, make current left child a child of parent
                        if(currentNode.data < parentNode.data) {
                            parentNode.left = currentNode.left;

                            //if parent < current value, make left child a right child of parent
                        } else if(currentNode.data > parentNode.data) {
                            parentNode.right = currentNode.left;
                        }
                    }
                }
                //Option 2: Right child which doesn't have a left child
            } else if (currentNode.right.left == null) {
                currentNode.right.left = currentNode.left;
                if(parentNode == null) {
                    this.root = currentNode.right;
                } else {
                    //if parent > current, make right child of the left the parent
                    if(currentNode.data < parentNode.data) {
                        parentNode.left = currentNode.right;

                        //if parent < current, make right child a right child of the parent
                    } else if (currentNode.data > parentNode.data) {
                        parentNode.right = currentNode.right;
                    }
                }

            }else {
                //Option 3: Right child that has a left child
                //find the Right child's left most child
                Node leftmost = currentNode.right.left;
                Node leftmostParent = currentNode.right;
                while(leftmost.left != null) {
                    leftmostParent = leftmost;
                    leftmost = leftmost.left;
                }

                //Parent's left subtree is now leftmost's right subtree
                leftmostParent.left = leftmost.right;
                leftmost.left = currentNode.left;
                leftmost.right = currentNode.right;

                if(parentNode == null) {
                    this.root = leftmost;
                } else {
                    if(currentNode.data < parentNode.data) {
                        parentNode.left = leftmost;
                    } else if(currentNode.data > parentNode.data) {
                        parentNode.right = leftmost;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}

