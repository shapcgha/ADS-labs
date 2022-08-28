//package com.company;

import java.util.Scanner;

public class C {
    public static int find(int[] SNM, int a) {
        if (a != SNM[a]) {
            return SNM[a] = find(SNM, SNM[a]);
        }
        return a;
    }

    public static void union(int[] SNM, int a, int b, int[] min, int[] max, int[] size) {
        int tempA = find(SNM, a);
        int tempB = find(SNM, b);
        if (tempA == tempB) {
            return;
        } else {
            if (size[tempA] < size[tempB]) {
                int temp = tempA;
                tempA = tempB;
                tempB = temp;
            }
            SNM[tempB] = tempA;
            if (min[tempA] > min[tempB]) {
                min[tempA] = min[tempB];
            }
            if (max[tempA] < max[tempB]) {
                max[tempA] = max[tempB];
            }
            size[tempA] += size[tempB];
        }
    }

    public static void get(int a, int[] min, int[] max, int[] size, int[] SNM) {
        a = find(SNM, a);
        System.out.println(min[a] + " " + max[a] + " " + size[a]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] SNM = new int[n + 1];
        int[] min = new int[n + 1];
        int[] max = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            SNM[i] = i;
            min[i] = i;
            max[i] = i;
            size[i] = 1;
        }
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.equals("union")) {
                union(SNM,sc.nextInt(), sc.nextInt(), min, max, size);
            } else if (str.equals("get")) {
                get(sc.nextInt(), min, max, size, SNM);
            }
        }
    }
}