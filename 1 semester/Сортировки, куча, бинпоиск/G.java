//package com.company;
import java.util.*;


public class fac {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), x=sc.nextInt(), y=sc.nextInt();
        int l=0, r=(n-1)*Math.max(x,y);
        while (r-l>1){
            int m=(r+l)/2;
            if((m/x+m/y)<n-1)
                l=m;
            else
                r=m;
        }
        System.out.println(r+Math.min(x,y));
    }
}
 