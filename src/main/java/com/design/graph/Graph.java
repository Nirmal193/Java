package com.design.graph;

import java.util.*;

public class Graph {
    static class Pair<T,E>{
        T first;
        E second;
        public Pair(T first,E second){
            this.first = first;
            this.second = second;
        }
    }
    private int v;
    private ArrayList<ArrayList<Integer>>adj;
    public Graph(int v){
        this.v = v;
        adj = new ArrayList<>(v);
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int s,int d){
        adj.get(s).add(d);
        adj.get(d).add(s);
    }
    public int[] addColor(){
       int result[] = new int[v];
       Arrays.fill(result,-1);
        result[0] = 0;
        boolean[] used = new boolean[v];
        Arrays.fill(used,true);
        for(int i=1;i<v;i++){
            Iterator<Integer> it = adj.get(i).iterator();
            while(it.hasNext()){
                int j = it.next();
                if(result[j] != -1){
                    used[result[j]] = false;
                }
            }
            int max;
            for(max = 0;max<v;max++)
                if(used[max])
                    break;
            result[i] = max;
            Arrays.fill(used,true);
        }
        for(int i=0;i<v;i++){
            System.out.println(result[i]);
        }
        return result;
    }
    boolean biportite;
    public void isBiportite(int[] color,int node,int curr_color){
        color[node] = curr_color;
        Iterator<Integer> it = adj.get(node).iterator();
        while(it.hasNext()){
            int i = it.next();
            if(i==2)
            if(color[i] == curr_color)
                biportite =  false;
            else if(color[i] == 1-curr_color)
                continue;
            else
                   isBiportite(color,i,1-curr_color);
        }
    }
    int K, N;
    long tot;
    HashSet<String> st = new HashSet<>();
    String ans;

    boolean dfs() {
        if(st.size() == tot) {
            return true;
        }

        String tmp = "";
        if(N > 1) {
            tmp = ans.substring(ans.length()-N+1);
        }

        for(int i = 0; i < K; i++)
        {
            tmp += i;
            if(!st.contains(tmp)) {
                ans += i;
                st.add(tmp);
                if(dfs())
                    return true;
                st.remove(tmp);
                ans = ans.substring(0, ans.length()-1);
            }
            tmp = tmp.substring(0, tmp.length()-1);
        }

        return false;
    }

    public String findString(int n, int k){
        K = k;
        N = n;
        st.clear();
        if(n == 1) {
            char[] r = new char[k];
            for(int i = 0; i < k; i++)
                r[i] =(char)(i + '0');
            return new String(r);
        }
        tot=1;
        for(int i = 1; i <= n; i++)
            tot = (tot*k);
        char[] ansa = new char[n];
        Arrays.fill(ansa, '0');
        ans = new String(ansa);
        st.add(ans);
        dfs();
        return ans;
    }
    public static void main(String[] args) {
        Graph g1 = new Graph(3);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
//        g1.addEdge(3, 2);
//        g1.addEdge(1, 3);
//        g1.addEdge(4, 5);
        //g1.addEdge(3, 4);
        System.out.println(g1.findString(3,3));
    }
}