//package com.company;

import java.util.Scanner;

public class kol{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double c = sc.nextDouble();
        double l = 0, r = c;
        for (int i = 0; i < 10000; i++) {
            double m = (r + l) / 2;
            double temp = m * m + Math.sqrt(m);
            if (temp < c) {
                l = m;
            } else {
                r = m;
            }
        }
        System.out.println(r);
    }
}