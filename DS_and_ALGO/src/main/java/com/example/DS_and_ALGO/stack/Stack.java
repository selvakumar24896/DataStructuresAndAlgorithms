package com.example.DS_and_ALGO.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable {
    private LinkedList<T> list = new LinkedList<T>();
    Stack(){

    }
    Stack(T item){
        push(item);
    }

    public int size(){
        return list.size();
    }

    public  boolean isEmpty(){
        return size() == 0;
    }

    public void push(T item){
        list.addLast(item);
    }
    public T pop(){
        if(isEmpty())
            throw new EmptyStackException();
        return list.removeLast();
    }

    public T peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return list.getLast();
    }
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
