package com.dheeraj.leetcode;

public class OddNumBetween {
    public static void main(String[] args) {
        OddNumBetween demo=new OddNumBetween();
        System.out.println("[0,3]:" +demo.countOdds(0,3));
        System.out.println("[0,10]:"+demo.countOdds(0,10));
    }
    public int countOdds(int low, int high) {

        int nums= high-low+1;
        if(low %2 != 0 && high % 2 !=0){
            return nums/2 +1;
        }else {
            return nums/2;
        }
    }
}

