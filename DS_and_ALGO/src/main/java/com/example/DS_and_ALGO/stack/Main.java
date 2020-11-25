package com.example.DS_and_ALGO.stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("empty : "+stack.isEmpty());
       // stack.pop();
        stack.push(3);
        stack.push(2);
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.size());


    }
}
