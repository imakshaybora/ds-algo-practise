package com.walmart.move.nim.codelib.linkedlist;

import com.walmart.move.nim.codelib.linkedlist.model.LinkedListNode;
import com.walmart.move.nim.codelib.utils.Utils;

public class ReverseLinkedList {
    public static void main(String[] args) {
        System.out.println("Input: ");
        LinkedListNode inputNode = Utils.INSTANCE.getLinkedList();
        Utils.INSTANCE.printLinkedList(inputNode);
        System.out.println("Output: ");
        Utils.INSTANCE.printLinkedList(reverseLinkedList(inputNode));
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode headNode) {
        LinkedListNode prev = null;
        LinkedListNode curr = headNode;
        LinkedListNode next = null;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
