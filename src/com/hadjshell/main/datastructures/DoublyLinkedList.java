package com.hadjshell.main.datastructures;

import java.util.StringJoiner;

public class DoublyLinkedList implements MyList{
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        return getNode(index).value;
    }

    private Node getNode(int index) {
        checkBounds(0, size - 1, index);

        Node cur = (index < size / 2) ? head : tail;
        if(cur == head) {
            for(int i = 0; i < index; i++)
                cur = cur.next;
        }
        else {
            for(int i = size - 1; i > index; i--) {
                cur = cur.previous;
            }
        }

        return cur;

    }

    @Override
    public void prepend(int value) {
        insert(value, 0);
    }

    @Override
    public void append(int value) {
        insert(value, size);
    }

    @Override
    public void insert(int value, int index) {
        checkBounds(0, size, index);

        // if list is empty
        if(isEmpty()) {
            head = new Node(value);
            tail = head;
            size++;
            return;
        }
        // if insert into head
        if(index == 0) {
            Node newNode = new Node(value, null, head);
            head.previous = newNode;
            head = newNode;
            size++;
            return;
        }
        // if insert into tail
        if(index == size) {
            Node newNode = new Node(value, tail, null);
            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }

        Node next = getNode(index);
        Node newNode = new Node(value, next.previous, next);
        next.previous.next = newNode;
        next.previous = newNode;
        size++;
    }

    @Override
    public boolean search(int value) {
        Node cur = head;
        while(cur != null) {
            if(cur.value == value)
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void pollHead() {
        delete(0);
    }

    @Override
    public void pollTail() {
        delete(size - 1);
    }

    @Override
    public void delete(int pos) {
        checkBounds(0, size - 1, pos);

        // delete head
        if(pos == 0) {
            head = head.next;
            // new head may be null, need to be ckecked
            if(head == null) {
                tail = null;
            }
            else{
                head.previous = null;
            }
            size--;
            return;
        }
        // delete tail
        if(pos == size - 1) {
            tail = tail.previous;
            // new tail may be null, need to be checked
            if(tail == null) {
                head = null;
            }
            else {
                tail.next = null;
            }
            size--;
            return;
        }

        Node deletedNode = getNode(pos);
        deletedNode.previous.next = deletedNode.next;
        deletedNode.next.previous = deletedNode.previous;
        size--;
    }

    @Override
    public void reverse() {
        if(isEmpty()) return;

        Node oldHead = head;
        Node oldTail = tail;

        Node cur = head, prev, next;
        while(cur != null) {
            prev = cur.previous;
            next = cur.next;
            cur.next = prev;
            cur.previous = next;
            cur = next;
        }
        head = oldTail;
        tail = oldHead;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("->");
        DoublyLinkedList.Node cur = head;
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
        Node previous;
        Node next;

        Node() {}
        Node(int value) {
            this(value, null, null);
        }
        Node(int value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}
