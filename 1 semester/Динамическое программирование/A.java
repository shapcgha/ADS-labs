//package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] money = new int[n];
        money[0] = 0;
        for (int i = 1; i < n - 1; i++) {
            money[i] = sc.nextInt();
        }
        money[n - 1] = 0;
        int[][] information = new int[3][n];
        information[0][0] = 0;
        information[1][0] = 0;
        information[2][0] = 0;
        for (int i = 1; i < n; i++) {
            int max = i - 1;
            for (int j = i - 1; j >= i - k; j--) {
                if (j < 0) {
                    break;
                }
                if (information[0][j] > information[0][max]) {
                    max = j;
                }
            }
            information[0][i] = information[0][max] + money[i];
            information[2][i] = max + 1;
        }
        System.out.println(information[0][n - 1]);
        int count = 0;
        ArrayList<Integer> path = new ArrayList<>();
        while (true) {
            if (n != 1) {
                path.add(n);
                count++;
                n = information[2][n - 1];
            } else {
                break;
            }
        }
        path.add(n);
        System.out.println(count);
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
}