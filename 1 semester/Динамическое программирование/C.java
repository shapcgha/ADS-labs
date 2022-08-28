//package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] count = new int[n];
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int pos = 0;
        int max = count[0];
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                pos = i;
                max = count[i];
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        while (pos != -1) {
            answer.add(arr[pos]);
            pos = prev[pos];
        }
        System.out.println(answer.size());
        for (int i = answer.size() - 1; i >= 0; i--) {
            System.out.print(answer.get(i)+" ");
        }
    }
}