package com.walmart.move.nim.codelib.linkedlist;


import com.walmart.move.nim.codelib.linkedlist.model.LinkedListNode;
import com.walmart.move.nim.codelib.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class BreakFromMid {
    public static void main(String[] args) {
        System.out.println("Input: ");
        LinkedListNode inputNode = Utils.INSTANCE.getLinkedList();
        Utils.INSTANCE.printLinkedList(inputNode);
        System.out.println("Output: ");
        List<LinkedListNode> nodeList = breakListFromMid(inputNode);
        for (LinkedListNode node : nodeList) {
            Utils.INSTANCE.printLinkedList(node);
        }
    }

    public static List<LinkedListNode> breakListFromMid(LinkedListNode head) {
        LinkedListNode start = head;
        LinkedListNode fastPointer = head;
        LinkedListNode prev = null;

        while (start != null && fastPointer != null && fastPointer.nextNode!= null) {
            prev = start;
            start = start.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
        }
        prev.nextNode = null;
        List<LinkedListNode> result = new ArrayList<>();
        result.add(head);
        result.add(start);
        return result;
    }


}
