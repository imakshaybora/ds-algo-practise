package com.walmart.move.nim.codelib.practice.tree;

/* Class containing left and right child of current
 node and key value*/
public class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}