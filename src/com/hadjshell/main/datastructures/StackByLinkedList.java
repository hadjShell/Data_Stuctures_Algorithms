package com.hadjshell.main.datastructures;

import java.util.NoSuchElementException;

public class StackByLinkedList implements MyStack{
    private Node head;
    private int size;

    public StackByLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(int value) {
        Node newNode = new Node(value, head);
        head = newNode;
        size++;
    }

    @Override
    public int pop() {
        if(isEmpty())
            throw new NoSuchElementException("Empty stack. Nothing to pop");

        Node destroy = head;
        head = head.next;
        int ret = destroy.value;
        destroy = null; // clear to let GC does its work
        size--;
        return ret;
    }

    @Override
    public int peek() {
        if(isEmpty())
            throw new NoSuchElementException("Empty stack. Nothing to pop");
        return head.value;
    }

    @Override
    public String toString() {
        Node cur = head;
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
