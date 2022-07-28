package com.hadjshell.main.datastructures;

import java.util.Set;

public interface MyHashMap {
    boolean isEmpty();
    int size();
    int get(String key);
    void remove(String key);
    void put(String key, int value);
    Set<String> keySet();

    @Override
    String toString();
}
