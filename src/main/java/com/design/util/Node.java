package com.design.util;

public class Node {
    public int data;
    public Node next, arb;
    public Node left,right;

    public Node(int d)
    {
        data = d;
        next = arb = null;
        left = right = null;
    }
}
