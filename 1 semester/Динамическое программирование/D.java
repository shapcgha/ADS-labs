//package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class C {

    public static void ref(long[][] arr, int level, int n) {
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 1:
                    arr[level][i] = arr[level - 1][6] + arr[level - 1][8];
                    arr[level][i] %=Math.pow(10,9);
                    break;
                case 2:
                    arr[level][i] = arr[level - 1][7] + arr[level - 1][9];
                    arr[level][i] %=Math.pow(10,9);
                    break;
                case 3:
                    arr[level][i] = arr[level - 1][4] + arr[level - 1][8];
                    arr[level][i] %=Math.pow(10,9);
                    break;
                case 4:
                    arr[level][i] = arr[level - 1][3] + arr[level - 1][9];
                    arr[level][i] %=Math.pow(10,9);
                    arr[level][i] +=arr[level - 1][0];
                    arr[level][i] %=Math.pow(10,9);
                    break;
                case 5:
                    arr[level][i] = 0;
                    break;
                case 6:
                    arr[level][i] = arr[level - 1][1] + arr[level - 1][7];
                    arr[level][i] %=Math.pow(10,9);
                    arr[level][i]+= arr[level - 1][0];
                    arr[level][i] %=Math.pow(10,9);
                    break;
                case 7:
                    arr[level][i] = arr[level - 1][2] + arr[level - 1][6];
                    arr[level][i] %=Math.pow(10,9);
                    break;
                case 8:
                    arr[level][i] = arr[level - 1][1] + arr[level - 1][3];
                    arr[level][i] %=Math.pow(10,9);
                    break;
                case 9:
                    arr[level][i] = arr[level - 1][2] + arr[level - 1][4];
                    arr[level][i] %=Math.pow(10,9);
                    break;
                case 0:
                    arr[level][i] = arr[level - 1][4] + arr[level - 1][6];
                    arr[level][i] %=Math.pow(10,9);
                    break;
            }
        }
        if (level == n) {
            return;
        }
        ref(arr, level + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] arr = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }
        arr[1][0] = 0;
        arr[1][8] = 0;
        if (n >= 2) {
            ref(arr, 2, n);
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count += arr[n][i];
            count %= Math.pow(10,9);
        }
        System.out.println(count);
    }
}