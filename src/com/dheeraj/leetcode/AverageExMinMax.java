package com.dheeraj.leetcode;

public class AverageExMinMax {
    public static void main(String[] args) {
        AverageExMinMax d=new AverageExMinMax();
        int[] salary={48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        System.out.println(d.average(salary));
    }
    public double average(int[] salary) {
        int length=salary.length;
        int min=Integer.MAX_VALUE;
        int max=0;
        int sum=0;
        for(int i=0;i<length;i++){
            if(salary[i]<min){
                min=salary[i];
            }
            if(salary[i]>max){
                max=salary[i];
            }
            sum=sum+salary[i];
        }
        sum=sum-min-max;
        length=length-2;
        System.out.println("Sum: "+ sum+"  length: "+length);
        double avg=(double)sum/length;
        return avg;
    }
}
