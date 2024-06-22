package com.hadjshell.test.datastructures;

import com.hadjshell.main.datastructures.QueueByLinkedList;

public class QueueTest {
    public static void main(String[] args) {
        QueueByLinkedList myQueue = new QueueByLinkedList();
        System.out.println(myQueue.isEmpty());
        for(int i = 0; i < 6; i++) {
            myQueue.enqueue(i);
        }
        System.out.println(myQueue);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.front());
        System.out.println(myQueue.rear());
        System.out.println(myQueue);
        for(int i = 0; i < 6; i++) {
            System.out.println(myQueue.dequeue());
            System.out.println(myQueue);
        }
    }
}
