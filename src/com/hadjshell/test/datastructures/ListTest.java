package com.hadjshell.test.datastructures;

import com.hadjshell.main.datastructures.MyList;
import com.hadjshell.main.datastructures.SinglyLinkedList;

public class ListTest {
    public static void main(String[] args) {
        MyList list = new SinglyLinkedList();
        System.out.println(list.isEmpty());
        for(int i = 0; i < 9; i++) {
            list.append(i);
        }
        System.out.println(list);
        System.out.println("List size: " + list.size());
        System.out.println(list.get(5));
        // System.out.println(list.get(20));
        list.prepend(-1);
        System.out.println(list);
        System.out.println("List size: " + list.size());
        list.insert(100, 5);
        System.out.println(list);
        list.pollHead();
        list.pollTail();
        System.out.println(list);
        list.delete(4);
        System.out.println(list);
        System.out.println("List size: " + list.size());
        System.out.println(list.search(5));
        System.out.println(list.search(20));
        list.reverse();
        System.out.println(list);
    }
}
