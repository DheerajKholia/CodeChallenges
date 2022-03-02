package com.dheeraj.microsoft.codility;

public class MaxNonIntersectingSegment {

    public static void main(String[] args) {
        MaxNonIntersectingSegment demo=new MaxNonIntersectingSegment();
        int[] input={10,1,3,1,2,2,1,0,4};
        System.out.println(demo.solution(input));
    }

    public int solution(int[] A) {
        int max=0;
        for(int i=0;i<A.length-1;i++){
            int sum=A[i] + A[i+1];
            int numberOfPairs=getSumPairs(sum, A, i+2);
            if(numberOfPairs>max) max=numberOfPairs;
        }
        return max;
    }

    private int getSumPairs(int sum, int[] a, int startIndex) {
        if(startIndex >= a.length-2) return 0;
        int noPairs=1;
        for(int i=startIndex; i<a.length-1; i++){
            if(a[i]+a[i+1] == sum){
                noPairs+=1;
                i++;
            }
        }
        return noPairs;
    }
}
