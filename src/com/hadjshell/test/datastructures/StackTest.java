package com.hadjshell.test.datastructures;

import com.hadjshell.main.datastructures.MyStack;
import com.hadjshell.main.datastructures.StackByArrayList;
import com.hadjshell.main.datastructures.StackByLinkedList;

public class StackTest {
    public static void main(String[] args) {
        MyStack s = new StackByArrayList();
        System.out.println(s.isEmpty());
        for(int i = 0; i < 6; i++) {
            s.push(i);
        }
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s);
//        for(int i = 0; i < 6; i++) {
//            System.out.println(s.pop());
//        }
    }
}
