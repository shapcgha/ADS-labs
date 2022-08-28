//package com.company;

import java.io.*;
import java.util.*;


public class A {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> deque1 = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String temp = sc.next();
            if (temp.charAt(0) == '+'){
                deque1.addLast(sc.nextInt());
            } else if (temp.charAt(0)=='*'){
                deque1.addFirst(sc.nextInt());
            } else if (temp.charAt(0) == '-'){
                System.out.println(deque.pollFirst());
            }
            if(deque1.size()>deque.size()){
                deque.addLast(deque1.pollFirst());
            }
        }
    }
}