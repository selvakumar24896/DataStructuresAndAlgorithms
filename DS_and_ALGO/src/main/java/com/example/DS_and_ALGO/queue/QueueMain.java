package com.example.DS_and_ALGO.queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(4);
        q.dequeue();
        q.enqueue(5);
        q.enqueue(8);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        //q.dequeue();
        System.out.println(q.size());

    }
}
