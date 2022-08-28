//package com.company;
import java.util.*;

public class fac {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i]=sc.nextLong();
        for (int i=0; i<k;i++){
            long x=sc.nextLong();
            int r = n, l = -1, m;
            while (r - l > 1) {
                m = (l + r) / 2;
                if (arr[m] < x)
                    l = m;
                else if (arr[m] >= x)
                    r = m;
            }
            if(x<=arr[0])
                System.out.println(arr[0]);
            else if (x>=arr[n-1])
                System.out.println(arr[n-1]);
            else if (x - arr[l] <= arr[r] - x)
                System.out.println(arr[l]);
            else
                System.out.println(arr[r]);
        }
    }
}
 