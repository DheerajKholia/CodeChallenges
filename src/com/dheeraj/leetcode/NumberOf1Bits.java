package com.dheeraj.leetcode;

public class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits=new NumberOf1Bits();
        int n=1001000101;
        System.out.println("Input: "+n);
        System.out.println(numberOf1Bits.hammingWeight(n));
    }
    public int hammingWeight(int n) {
        int result=0;
        String numString=Integer.toString(n);
        for(int i=0;i<numString.length();i++){
            if(numString.charAt(i)=='1') result++;
        }
        return result;
    }
}
