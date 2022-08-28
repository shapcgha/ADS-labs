//package com.company;

import java.util.Scanner;
import java.util.Stack;

public class A {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String temp = sc.next();
            if (!temp.isEmpty()) {
                if (Character.isDigit(temp.charAt(0))) {
                    stack.add(Integer.parseInt(temp));
                } else {
                    int x = stack.pop();
                    if (temp.equals("+")) {
                        stack.add(stack.pop() + x);
                    } else if (temp.equals("-")) {
                        stack.add(stack.pop() - x);
                    } else if (temp.equals("*")) {
                        stack.add(stack.pop() * x);
                    }
                }
            }
        }
        System.out.println(stack.peek());
    }
}