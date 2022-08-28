//package com.company;
import java.util.*;


public class fac {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long w=sc.nextLong(), h=sc.nextLong(), n=sc.nextLong();
        long l=0, r=n*Math.max(w,h);
        while (r-l>1){
            long m=(r+l)/2;
            if((m/w)*(m/h)<n)
                l=m;
            else
                r=m;
        }
        System.out.println(r);
    }
}
 