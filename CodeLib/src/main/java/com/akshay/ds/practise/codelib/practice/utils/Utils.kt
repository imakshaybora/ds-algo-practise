package com.akshay.ds.practise.codelib.practice.utils

import com.akshay.ds.practise.codelib.practice.linkedlist.model.LinkedListNode

object Utils {
    fun getLinkedList(): LinkedListNode {
        val start = LinkedListNode(1)
        val two = LinkedListNode(2)
        val three = LinkedListNode(3)
        val four = LinkedListNode(4)
        val five = LinkedListNode(5)
        start.nextNode = two
        two.nextNode = three
        three.nextNode = four
        four.nextNode = five
        five.nextNode = null
//        four.nextNode = two // Cycle here 1-> 2 ->

        //            |     3
        //         4  <-
        return start
    }

    fun printLinkedList(head: LinkedListNode?) {
        var start: LinkedListNode? = head ?: return
        while (start != null) {
            print(start.data)
            start = start.nextNode
        }
        println()
    }
}
