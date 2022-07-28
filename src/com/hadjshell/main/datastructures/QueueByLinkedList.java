package com.hadjshell.main.datastructures;

import java.util.NoSuchElementException;

public class QueueByLinkedList {
    private Node front;
    private Node rear;
    private int size;

    public QueueByLinkedList() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            front = newNode;
        }
        else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public int dequeue() {
        if(isEmpty())
            throw new NoSuchElementException("Empty queue. Nothing to dequeue");

        Node destroy = front;
        int val = front.value;
        front = front.next;
        destroy = null;
        size--;
        if(isEmpty())   rear = null;
        return val;
    }

    public int front() {
        if(isEmpty())
            throw new NoSuchElementException("Empty queue.");

        return front.value;
    }

    public int rear() {
        if(isEmpty())
            throw new NoSuchElementException("Empty queue.");

        return rear.value;
    }

    @Override
    public String toString() {
        if(isEmpty())
            return "Empty Queue";

        Node cur = front;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.value).append("->");
            cur = cur.next;
        }
        return builder.replace(builder.length() - 2, builder.length(), "").toString();
    }


    private static class Node {
        int value;
        Node next;

        Node() { }
        Node(int value) { this(value, null); }
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
