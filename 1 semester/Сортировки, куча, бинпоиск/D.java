//package com.company;

import java.util.*;

public class fac {
    public static void swap(int[] heap, int i, int j){
        int x = heap[j];
        heap[j]=heap[i];
        heap[i]=x;
    }
    public static void siftup(int[] heap, int heapsize){
        if (heapsize > 1) {
            int i=heapsize-1;
            while (heap[i]>heap[(i-1)/2]){
                swap(heap,i,(i-1)/2);
                i=(i-1)/2;
            }
        }
    }
    public static void siftdown(int[] heap, int heapsize){
        heap[0]=heap[heapsize-1];
        heap[heapsize-1]=0;
        heapsize--;
        if (heapsize>1){
            int i=0;
            while (2*i+1<heapsize){
                int left=2*i+1;
                int right= 2*i+2;
                int j=left;
                if (right<heapsize && heap[right]>heap[left])
                    j=right;
                if(heap[i]>=heap[j])
                    break;
                swap(heap,i,j);
                i=j;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),heapsize=0;
        int[] heap = new int[n];
        for (int i=0; i<n; i++){
            int m=sc.nextInt();
            if(m==0){
                heap[heapsize]=sc.nextInt();
                heapsize++;
                siftup(heap,heapsize);
            }
            else if(m==1){
                System.out.println(heap[0]);
                siftdown(heap,heapsize);
                heapsize--;
            }
        }
    }
}