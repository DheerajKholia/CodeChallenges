package com.dheeraj.java.algorithms.recursion;

public class ToweOfHanoi {
    public static void main(String[] args) {
        ToweOfHanoi t=new ToweOfHanoi();
        t.solve(2,'A','B','C');
    }
    public void solve(int disk, char source, char middle, char destination){
        if(disk==0){
            System.out.println("Plate "+disk+ " from "+source+" to "+destination);
            return ;
        }
        solve(disk-1, source,destination,middle);
        System.out.println("Plate "+disk+ " from "+source+" to "+destination);
        solve(disk-1, middle,source,destination);
    }

}
