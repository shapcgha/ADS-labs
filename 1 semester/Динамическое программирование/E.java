//package com.company;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        long[][] arr = new long[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str2.length(); i++) {
            arr[0][i] = i;
        }
        for (int i = 0; i <= str1.length(); i++) {
            arr[i][0] = i;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.min(Math.min(arr[i - 1][j - 1], arr[i - 1][j]), arr[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(arr[str1.length()][str2.length()]);
    }
}