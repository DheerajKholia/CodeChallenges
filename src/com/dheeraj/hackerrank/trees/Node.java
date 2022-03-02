package com.dheeraj.hackerrank.trees;

class Node {
    int data;
    Node left;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    Node right;

    public Node(){

    }
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
