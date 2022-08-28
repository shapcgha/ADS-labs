//package com.company;

import java.util.*;

public class fac {
    static long sum=0;
    public static void merge (long[] arr, int l, int mid, int r) {
        int i = 0, j = 0;
        long[] b = new long[r - l];
        while (l + i < mid && mid + j < r) {
            if (arr[i + l] < arr[j + mid]) {
                b[i + j] = arr[i + l];
                i++;
            } else {
                b[i + j] = arr[j + mid];
                j++;
                sum += mid - l - i;
            }
        }
        while (i+l<mid){
            b[i+j]=arr[i+l];
            i++;
        }
        while (j+mid<r){
            b[i+j]=arr[j+mid];
            j++;
        }
        for (int x=0; x<r-l;x++)
            arr[x+l]=b[x];
    }
    public static void sort(long[] arr,int l, int r){
        if ((r-l)<=1)
            return;
        sort(arr,l,(l+r)/2);
        sort(arr,(l+r)/2,r);
        merge(arr, l, (l+r)/2,r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i=0; i<n; i++){
            arr[i]=sc.nextLong();
        }
        sort(arr,0,n);
        System.out.println(sum);
    }
}