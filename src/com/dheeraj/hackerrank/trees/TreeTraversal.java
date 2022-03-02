package com.dheeraj.hackerrank.trees;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeTraversal t=new TreeTraversal();
        Node root=new Node(1,null, new Node(2, null,new Node(5, new Node(3,null,
                new Node(4,null,null)), new Node(6,null,null))));
        t.preorder(root);
        System.out.println();
        t.postOrder(root);
    }

    public void preorder(Node node){
        if(node==null) return;
        System.out.print(node.data+"\t");
        preorder(node.left);
        preorder(node.right);
    }
    public void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+"\t");
    }
}
