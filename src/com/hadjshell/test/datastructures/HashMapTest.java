package com.hadjshell.test.datastructures;

import com.hadjshell.main.datastructures.HashMapBySeparateChaining;
import com.hadjshell.main.datastructures.MyHashMap;

public class HashMapTest {
    public static void main(String[] args) {
        MyHashMap m = new HashMapBySeparateChaining();
        // System.out.println(m.get("CS"));
        m.put("CS", 1);
        m.put("Math", 2);
        m.put("DS", 3);
        m.put("Algorithm", 4);
        m.put("Java", 5);
        m.put("Python", 6);
        m.put("C", 7);
        m.put("C++", 8);
        System.out.println(m);
        System.out.println(m.size());
        m.put("CS", 10);
        System.out.println(m.get("CS"));
        System.out.println(m.keySet());
        m.remove("C++");
        System.out.println(m);
        System.out.println(m.size());
        m.put("Scala", 9);
        System.out.println(m);
        // m.remove("BUG");
    }
}
