package com.example.DS_and_ALGO.DataStructures.dynamicArray;

import com.example.DS_and_ALGO.DataStructures.dynamicArray.DynamicArray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dArray = new DynamicArray();
        System.out.println(dArray.size());
        System.out.println(dArray.toString());
        dArray.add(3);
        dArray.add(4);
        dArray.add(6);
        dArray.add(1);
        System.out.println(dArray.size());
        System.out.println(dArray.toString());
        dArray.removeAt(3);
        System.out.println(dArray.toString());
        dArray.removeAt(0);
        System.out.println(dArray.toString());
        System.out.println(dArray.get(1));
        System.out.println(dArray.indexOf(4));

    }
}
