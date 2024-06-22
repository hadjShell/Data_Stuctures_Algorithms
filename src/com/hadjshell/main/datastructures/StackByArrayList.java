package com.hadjshell.main.datastructures;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackByArrayList implements MyStack{
    private ArrayList<Integer> stack;

    public StackByArrayList() {
        stack = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void push(int value) {
        stack.add(value);
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.remove(stack.size() - 1);
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.get(stack.size() - 1);
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
