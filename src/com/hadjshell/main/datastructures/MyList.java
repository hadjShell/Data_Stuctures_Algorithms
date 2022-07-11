package com.hadjshell.main.datastructures;

public interface MyList {
    boolean isEmpty();

    int size();

    int get(int index);

    void prepend(int value);

    void append(int value);

    void insert(int value, int index);

    boolean search(int value);

    void pollHead();

    void pollTail();

    void delete(int pos);

    void reverse();

    @Override
    String toString();
}
