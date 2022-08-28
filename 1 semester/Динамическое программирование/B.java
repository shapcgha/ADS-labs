//package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] money = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                money[i][j] = sc.nextInt();
            }
        }
        int[][][] information = new int[2][n][k];
        information[0][0][0] = money[0][0];
        information[1][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0 && j == 0) {
                    information[0][i][j] = money[i][j];
                } else if (i == 0) {
                    information[0][i][j] = information[0][i][j - 1] + money[i][j];
                    information[1][i][j] = 1;
                } else if (j == 0) {
                    information[0][i][j] = information[0][i - 1][j] + money[i][j];
                    information[1][i][j] = 2;
                } else {
                    if (information[0][i][j - 1] > information[0][i - 1][j]) {
                        information[0][i][j] = information[0][i][j - 1] + money[i][j];
                        information[1][i][j] = 1;
                    } else {
                        information[0][i][j] = information[0][i - 1][j] + money[i][j];
                        information[1][i][j] = 2;
                    }
                }
            }
        }
        System.out.println(information[0][n - 1][k - 1]);
        StringBuilder str = new StringBuilder();
        int i = n - 1;
        int j = k - 1;
        while (i!=0 || j!=0){
            if(information[1][i][j] == 1){
                j = j-1;
                str.append('R');
            } else {
                i = i-1;
                str.append('D');
            }
        }
        str.reverse();
        System.out.println(str);
    }
}