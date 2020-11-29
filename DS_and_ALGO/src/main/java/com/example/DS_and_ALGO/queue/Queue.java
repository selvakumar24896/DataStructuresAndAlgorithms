package com.example.DS_and_ALGO.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable{
    private LinkedList<T> queue = new LinkedList<T>();

    public Queue(){

    }
    public Queue(T item){
        enqueue(item);
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.size()<=0;
    }

    public void enqueue(T item){
        queue.addLast(item);
    }

    public void dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Empty Queue");
        }
        queue.removeFirst();
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Empty Queue");
        }
        return queue.peekFirst();
    }

    @Override
    public Iterator iterator() {
        return queue.iterator();
    }
}
