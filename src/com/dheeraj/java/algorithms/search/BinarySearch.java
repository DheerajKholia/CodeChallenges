package com.dheeraj.java.algorithms.search;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b=new BinarySearch();
        int[] arr={1, 2,3 ,4, 5,6,7,8,9,10};
        System.out.println(b.find(arr, 3, 0, arr.length-1));
    }

    public int find(int[] container, int item, int left, int right){
        if(right<left) return -1;
        int middleIndex=(left+right)/2;
        if(container[middleIndex]==item) return middleIndex;

        if(container[middleIndex] < item) return find(container,item,middleIndex+1,right);
        else return find(container,item,left,middleIndex-1);

    }
}
