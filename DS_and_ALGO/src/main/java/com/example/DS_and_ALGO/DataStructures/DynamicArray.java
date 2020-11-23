package com.example.DS_and_ALGO.DataStructures;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    private  T[] array;
    private int length=0; // length user thinks array is
    private int capacity=0; // Actual array size

    public DynamicArray(){
        this(2);
    }

    public DynamicArray(int capacity){
        if(capacity < 0)
            throw new IllegalArgumentException("Invalid Size :"+capacity);

        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public T get(int index){
        if(index >= 0 && index < length)
            return array[index];
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public void set(int index, T elem){
        if(index >= 0 && index < length)
            array[index] = elem;
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public void clear(){
        for(int i=0; i<length ; i++){
            array[i] = null;
        }
        length = 0;
    }

    public void add(T elem){
        if(length+1 >= capacity){
            if (capacity == 0)
                capacity = 1;
            else
                capacity = length *2;
            T[] newArray = (T[]) new Object[capacity];

            for(int i=0; i<length ;i++){
                newArray[i] = array[i];// arr has extra nulls padded
            }
            array = newArray;
        }
        array[length++] = elem;
    }

    public T removeAt(int rm_index){
        if(rm_index >= 0 && rm_index < length){
            T data = array[rm_index];
            T[] newArray = (T[]) new Object[length-1];
            for(int i=0,j=0;i<length ; i++,j++){
                if(i == rm_index) {
                    j--;
                    continue;
                }
                newArray[j] = array[i];
            }
            array = newArray;
            capacity = length--;
            return data;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean remove(Object obj){
        int index = indexOf(obj);
        if(index >= 0){
            removeAt(index);
            return true;
        }
        return false;
    }

    public int indexOf(Object obj){
        for(int i=0; i<length; i++){
            if(obj == null){
                if (array[i] == null)
                    return i;
            }else{
                if(array[i] == obj)
                    return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        if(indexOf(obj) == -1)
            return false;

        return true;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return array[index++];
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (length == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++) sb.append(array[i] + ", ");
            return sb.append(array[length - 1] + "]").toString();
        }
    }
}
