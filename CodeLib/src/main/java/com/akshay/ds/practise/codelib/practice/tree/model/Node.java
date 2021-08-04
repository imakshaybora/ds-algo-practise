package com.akshay.ds.practise.codelib.practice.tree.model;

/* Class containing left and right child of current
 node and key value*/
public class Node {
    public int data;
    public Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}