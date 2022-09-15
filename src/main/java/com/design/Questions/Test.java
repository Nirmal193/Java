package com.design.Questions;

import javafx.util.Pair;

import java.util.*;

public class Test {
    static int mod = (int) (1e9 + 7);
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public static String max;
    public static void solve(char[] str,int k){
        if(k==0)
            return;
        int n = str.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(str[i] < str[j])
                    swap(str,i,j);
                if(String.valueOf(str).compareTo(max) > 0)
                    max = String.valueOf(str);
                solve(str,k-1);
                swap(str,i,j);
            }
        }
    }
    public static void swap(char[] str, int i,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("nirmal kumar rout");
            }
        };
        Thread th = new Thread(task);
        th.start();
        List<String> list = new ArrayList<>();
    }
}
