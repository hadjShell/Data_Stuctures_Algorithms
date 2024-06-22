package com.hadjshell.main.datastructures;

import java.util.StringJoiner;

public class SinglyLinkedList implements MyList{
    private Node head;
    private int size;

    public SinglyLinkedList() { this(null, 0); }
    public SinglyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        return getNode(index).value;
    }

    private Node getNode(int index) {
        checkBounds(0, size - 1, index);

        Node ret = head;
        for(int i = 0; i < index; i++) {
            ret = ret.next;
        }

        return ret;
    }

    public void prepend(int value) {
        insert(value, 0);
    }

    public void append(int value) {
        insert(value, size);
    }

    public void insert(int value, int index) {
        checkBounds(0, size, index);

        Node node = new Node(value);
        // if list is empty
        if(isEmpty()) {
            head = node;
            size++;
            return;
        }
        // if insert into head
        if(index == 0) {
            node.next = head;
            head = node;
            size++;
            return;
        }

        Node previous = getNode(index - 1);
        node.next = previous.next;
        previous.next = node;
        size++;
    }

    public boolean search(int value) {
        Node cur = head;
        while(cur != null) {
            if(cur.value == value)
                return true;
            cur = cur.next;
        }
        return false;
    }

    public void pollHead() {
        delete(0);
    }

    public void pollTail() {
        delete(size - 1);
    }

    public void delete(int pos) {
        checkBounds(0, size - 1, pos);

        // delete head
        if(pos == 0) {
            head = head.next;
            size--;
            return;
        }

        Node previous = getNode(pos - 1);
        previous.next = previous.next.next;
        size--;
    }

    public void reverse() {
        if(isEmpty())   return;

        Node prev = null, cur = head, next;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("->");
        Node cur = head;
        while (cur != null) {
            joiner.add(cur.value + "");
            cur = cur.next;
        }
        return joiner.toString();
    }

    private void checkBounds(int start, int end, int pos) {
        if(pos < start || pos > end)
            throw new IndexOutOfBoundsException(pos + "");
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




