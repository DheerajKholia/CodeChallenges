package com.dheeraj.java.algorithms.recursion;

public class Fibbonacci {
    public static void main(String[] args) {
        Fibbonacci f=new Fibbonacci();
        int num=30;
        System.out.println(f.head(num));
        System.out.println(f.head(num));
    }
    public int head(int n){
        if (n==0) return 0;
        if(n==1) return 1;

        int fibb1=head(n-1);
        int fibb2=head(n-2);

        int result=fibb1+fibb2;
        return result;
    }

    public int tail(int n, int a, int b) {
        if(n==0) return 0;
        if(n==1) return 1;
        return tail(n-1, b, a+b);
    }

    public void iteration(int n) {

        int a = 0;
        int b = 1;

        while(a<n) {
            System.out.println(a);
            int temp = b;
            b = a + b;
            a = temp;
        }
    }
}
