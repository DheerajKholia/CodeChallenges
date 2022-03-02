package com.dheeraj.java.algorithms.selection;

import java.util.Random;

public class Quickselect {
    private int[] nums={1, -5, 10, 55, 2, 3, -7, 7, 11, 100};
    public static void main(String[] args) {

        Quickselect q=new Quickselect();
        System.out.println(q.select(3));
    }

    public int select(int k){
        return quickSlecet(0, nums.length-1,k-1);
    }

    public int quickSlecet(int firstIndex, int lastIndex, int k){
        int pivotIndex=partition(firstIndex, lastIndex);
        if(pivotIndex<k){
            return quickSlecet(pivotIndex+1, lastIndex,k);
        }else if(pivotIndex>k){
            return quickSlecet(firstIndex,pivotIndex-1,k);
        }
        return nums[pivotIndex];
    }

    private int partition(int firstIndex, int lastIndex) {
        int pivot=new Random().nextInt(lastIndex-firstIndex+1) +firstIndex;
        swap(pivot,lastIndex);

        for(int i=firstIndex; i<lastIndex;i++){
            if(nums[i]<nums[lastIndex]){
                swap(i,firstIndex);
                firstIndex++;
            }
        }
        swap(lastIndex,firstIndex);

        return firstIndex;
    }

    private void swap(int pivot, int lastIndex) {
        int temp=nums[pivot];
        nums[pivot]=nums[lastIndex];
        nums[lastIndex]=temp;
    }


}
