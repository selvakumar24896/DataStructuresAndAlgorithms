package com.example.DS_and_ALGO.list;

public class LinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add("hi");
        System.out.println(dList.size());
        System.out.println("-----"+dList.toString());
        dList.add("hello");
        System.out.println("-----"+dList.toString());
        dList.addFirst("**");
        System.out.println("-----"+dList.toString());
        dList.add("world");
        System.out.println("-----"+dList.toString());
        System.out.println("peek first : "+dList.peekFirst());
        System.out.println(dList.size());

        dList.removeFirst();
        System.out.println("-----"+dList.toString());
        System.out.println(dList.indexOf("hi"));
        System.out.println(dList.size());

    }
}
