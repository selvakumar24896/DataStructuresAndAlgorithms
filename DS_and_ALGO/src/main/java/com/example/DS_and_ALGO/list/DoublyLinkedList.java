package com.example.DS_and_ALGO.list;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T>{
        private T data;
        private Node<T> prev,next;
        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        Node<T> trav = head;
        while (trav != null){
            Node<T> next = trav.next;
            trav.prev=trav.next=null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public void add(T elem){
        addLast(elem);
    }

    public void addLast(T elem) {
        if(isEmpty()){
            head = tail = new Node<>(elem,null,null);
        }else {
            tail.next = new Node<>(elem,tail,null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T elem){
        if (isEmpty()){
            head = tail = new Node<>(elem,null,null);
        }else{
            head.prev = new Node<>(elem,null,head);
            head = head.prev;
        }
        size++;
    }

    public T  peekFirst(){
        if(isEmpty())
            throw new RuntimeException("Empty List");

        return head.data;
    }

    public T peekLast(){
        if(isEmpty())
            throw new RuntimeException("Empty List");

        return tail.data;
    }

    public T removeFirst(){
        if(isEmpty())
            throw new RuntimeException("Empty List");
        T data = head.data;
        head = head.next;
        size--;
        // If the list is empty set the tail to null
        if (isEmpty()) tail = null;
            // Do a memory cleanup of the previous node
        else head.prev = null;

        return data;
    }

    public T removeLast(){
        if(isEmpty())
            throw new RuntimeException("Empty List");
        T data = tail.data;
        tail = tail.prev;
        size--;
        if (isEmpty()) head = null;
            // Do a memory cleanup of the previous node
        else tail.next = null;
        return data;
    }

    public T remove(Node<T> node){
        if(node.prev == null)
            return removeFirst();
        if (node.next == null){
            return removeLast();
        }

        node.next.prev=node.prev;
        node.prev.next = node.next;

        T data = node.data;
        node.next = node.prev = null;
        node.data = null;
        size--;
        return data;
    }

    public int indexOf(Object obj){
    int index = 0;
    Node<T> trav = head;

    if(obj == null){
        for(;trav!=null;trav = trav.next,index++){
            if (trav.data == null){
                return index;
            }
        }
    }else
        for(;trav!=null;trav = trav.next,index++){
            if (trav.data.equals(obj)){
                return index;
            }
    }

    return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    public boolean remove(Object obj){
        Node<T> trav = head;
        if(obj == null){
            for (;trav!=null;trav=trav.next){
                if (trav.data == null){
                    remove(trav);
                    return true;
                }
            }
        }else{
            for (;trav!=null;trav=trav.next){
                if (trav.data.equals(obj)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    public T removeAt(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException();
        }

        int i;
        Node<T> trav;

        if(index < size/2){
            for(i=0,trav=head;i!=index;i++){
                trav=trav.next;
            }
        }else{
            for(i=0,trav=tail;i!=index;i--){
                trav=trav.prev;
            }
        }
        return remove(trav);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}