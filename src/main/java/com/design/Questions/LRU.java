package com.design.Questions;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRU {
    public int cache_size;
    HashSet<Integer> hashSet = new HashSet<>();
    Deque<Integer> deque = new LinkedList<>();
    public void refer(Integer page){
        if(!hashSet.contains(page)){
             if(deque.size() >= cache_size) {
                 hashSet.remove(deque.removeLast());
             }
            deque.addFirst(page);
            hashSet.add(page);
        }else{
            if(deque.size()>= cache_size){
                deque.add(page);
                hashSet.add(page);
            }
        }
    }
    public static void main(String[] args) {

    }
}
