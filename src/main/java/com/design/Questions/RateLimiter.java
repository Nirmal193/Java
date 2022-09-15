package com.design.Questions;

import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RateLimiter {
    public Map<String, Queue<Long>> loader;
    public int max_request = 5;
    public int max_time = 1000;
    public void hitRequest(String request){

    }
    public boolean is_possible(String request){
        Queue<Long> q = new LinkedList<>();
        long currentTime = System.currentTimeMillis();
        if(loader.containsKey(request)){
            Queue<Long> l = loader.get(request);
            while(!l.isEmpty() && l.peek() - currentTime <= max_time){
                l.poll();
            }
            if(q.size() > max_request) {
                l.add(currentTime);
                loader.put(request,l);
                return false;
            }
        }
            q.add(currentTime);
            loader.put(request,q);
            return true;
    }
    public static void main(String[] args) {

    }
}
