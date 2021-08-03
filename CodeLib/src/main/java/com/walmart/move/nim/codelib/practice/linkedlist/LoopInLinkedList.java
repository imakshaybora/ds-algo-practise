package com.walmart.move.nim.codelib.practice.linkedlist;


import com.walmart.move.nim.codelib.practice.linkedlist.model.LinkedListNode;

public class LoopInLinkedList {

    public static boolean hasLoop(LinkedListNode start) {
        if (start == null) {
            return false;
        }
        LinkedListNode slow = start;
        LinkedListNode fast = start.nextNode;
        while (slow != null && fast.nextNode != null & fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListNode start = new LinkedListNode(1);
        LinkedListNode two = new LinkedListNode(2);
        LinkedListNode three = new LinkedListNode(3);
        LinkedListNode four = new LinkedListNode(4);
        start.nextNode = two;
        two.nextNode = three;
        three.nextNode = four;
        four.nextNode = two; // Cycle here 1-> 2 ->
        //            |     3
        //         4  <-

        System.out.println(hasLoop(start));
    }
}
