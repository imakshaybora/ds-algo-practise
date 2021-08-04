package com.akshay.ds.practise.codelib.practice.linkedlist;

import com.akshay.ds.practise.codelib.practice.linkedlist.model.LinkedListNode;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public class ReverseInPairs {

    @Nullable
    @Contract(pure = true)
    public LinkedListNode swapPairs(LinkedListNode head) {

        LinkedListNode temp = new LinkedListNode(0);
        temp.nextNode = head;

        LinkedListNode current = temp;
        while (current.nextNode!=null && current.nextNode.nextNode!= null ) {
            LinkedListNode first = current.nextNode;
            LinkedListNode second = current.nextNode.nextNode;
            first.nextNode = second.nextNode;
            current.nextNode = second;
            current.nextNode.nextNode = first;
            current = current.nextNode.nextNode;
        }
        return temp.nextNode;
    }

    // 1->2->3->4
    /*
    * temp = 0->1->2->3->4 = current
    *
    * itr 1:
    * first = 1, second = 2 , current = 0
    * 0->1->2->3->4
    * 1-> 3-> 4
    * 0->2 -> 1 -> 3->4
    * Itr 2:
    * current = 1
    * first = 3, second = 4
    * 3-> null
    * 0->2 -> 1 -> 4 -> 3
    *
    * return 2 -> 1 -> 4 -> 3
    *
    *
    * */

}
