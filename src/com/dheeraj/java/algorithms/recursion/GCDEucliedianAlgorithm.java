package com.dheeraj.java.algorithms.recursion;

public class GCDEucliedianAlgorithm {
    public static void main(String[] args) {
        GCDEucliedianAlgorithm g=new GCDEucliedianAlgorithm();
        System.out.println(g.getGCD(21,11));

    }
    public int getGCD(int a,int b){
        if(a % b ==0) return b;
        return getGCD(b, a%b);
    }

    public int getGCDIteration(int a,int b){
        int temp=0;

        while(b!=0){
            temp=b;
            b=a%b;
            a=temp;
        }

        return a;
    }
}
