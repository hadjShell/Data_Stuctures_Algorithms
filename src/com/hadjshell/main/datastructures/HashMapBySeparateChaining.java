package com.hadjshell.main.datastructures;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringJoiner;

// Without rehashing
public class HashMapBySeparateChaining implements MyHashMap{
    private Node[] buckets;
    private int size;
    private static final int INITIAL_CAPACITY = 6;

    public HashMapBySeparateChaining() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    private int hashing(String key) {
        int hash = key.hashCode() % INITIAL_CAPACITY;
        if (hash < 0) {
            hash += INITIAL_CAPACITY;
        }
        return hash;
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
    public int get(String key) {
        if(isEmpty())
            throw new NoSuchElementException("Empty map.");

        int hash = hashing(key);
        if(buckets[hash] != null) {
            Node n = buckets[hash];
            while(n != null) {
                if(n.key.equals(key))
                    return n.value;
                n = n.next;
            }
        }

        throw new NoSuchElementException("No key found");

    }

    @Override
    public void remove(String key) {
        if(isEmpty())
            throw new NoSuchElementException("Empty map.");

        int hash = hashing(key);
        if(buckets[hash] != null) {
            Node n = buckets[hash];

            // if head node in the linked list is the removed node
            if(n.key.equals(key)) {
                Node destroy = n;
                buckets[hash] = n.next;
                destroy = null;
                size--;
                return;
            }
            // not head node
            else {
                Node prev = n;
                n = n.next;
                while (n != null) {
                    if (n.key.equals(key)) {
                        Node destroy = n;
                        prev.next = n.next;
                        destroy = null;
                        size--;
                        return;
                    }
                    prev = n;
                    n = n.next;
                }
            }
        }

        throw new NoSuchElementException("No key found");
    }

    @Override
    public void put(String key, int value) {
        int hash = hashing(key);
        if(buckets[hash] == null) {
            Node node = new Node(key, value);
            buckets[hash] = node;
        }
        else {
            Node node = buckets[hash], tail = null;
            while(node != null) {
                if(node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                tail = node;
                node = node.next;
            }
            tail.next = new Node(key, value);
        }
        size++;
    }

    @Override
    public Set<String> keySet() {
        if(isEmpty())
            return null;

        Set<String> s = new HashSet<>();
        for(Node node : buckets) {
            if(node != null) {
                while(node != null) {
                    s.add(node.key);
                    node = node.next;
                }
            }
        }
        return s;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for(Node node : buckets) {
            if(node != null) {
                while(node != null) {
                    joiner.add("{" + node.key + ", " + node.value + "}");
                    node = node.next;
                }
            }
        }
        return joiner.toString();
    }

    private static class Node {
        String key;
        int value;
        Node next;

        Node() { }
        Node(String key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }

    }
}
