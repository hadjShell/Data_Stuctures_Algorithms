package com.hadjshell.main.datastructures;

public interface MyStack {
    boolean isEmpty();
    void push(int value);
    int pop();
    int peek();

    @Override
    String toString();
}
