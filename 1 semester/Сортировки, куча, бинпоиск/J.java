//package com.company;

import java.util.*;

public class fac {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int v1=sc.nextInt(), v2=sc.nextInt();
        double x=sc.nextDouble();
        double l=0, r=1;
        while (r-l>0.00001){
            double m1=(2*l+r)/3, m2=(l+r*2)/3;
            if((Math.sqrt((1-x)*(1-x)+m1*m1)/v1+Math.sqrt(x*x+(1-m1)*(1-m1))/v2)<(Math.sqrt((1-x)*(1-x)+m2*m2)/v1+Math.sqrt(x*x+(1-m2)*(1-m2))/v2))
                r=m2;
            else
                l=m1;
        }
        System.out.println((r+l)/2);
    }
}
 