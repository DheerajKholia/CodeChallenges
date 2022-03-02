package com.dheeraj.hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class JavaListInsertDelete {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        //System.out.println("Enter list size: ");
        int size= Integer.parseInt(sc.nextLine());
        //System.out.println("Enter list elements: ");
        String list=sc.nextLine();
        List<Integer> intList=new LinkedList<>();
        int[] data= Arrays.stream(list.split(" ")).mapToInt(i->Integer.valueOf(i)).toArray();

        int queries=Integer.parseInt(sc.nextLine());
        while(queries!=0){
            System.out.println("Enter queries: ");
            String action=sc.nextLine();
            String items=sc.nextLine();
            int index=-1;
            int item=-1;
            if(items.split(" ").length>1){
                index=Integer.valueOf(items.split(" ")[0]);
                item=Integer.valueOf(items.split(" ")[1]);
            }else{
                index=Integer.valueOf(items);
            }
            data=performOperation(data, action,index,item);
            queries--;
        }
        Arrays.stream(data).forEach(item->System.out.print(item+" "));
        //System.out.println("List after operations: "+data);
    }

    private static int[] performOperation(int[] data, String action, int index, int item) {
        int[] temp=null;
       if(action.equalsIgnoreCase("Insert")){
            temp=new int[data.length+1];
           if(index< data.length) {
               for (int i = 0; i < index - 1; i++) {
                   temp[i] = data[i];
               }
               temp[index]=item;
               for(int i=index; i<data.length;i ++){
                   temp[i]=data[i];
               }
           }else if(index==data.length){
               for (int i = 0; i < data.length; i++) {
                   temp[i] = data[i];
               }
               temp[index]=item;
           }
            data=temp;
       }else if(action.equalsIgnoreCase("Delete")){
               temp=new int[data.length-1];
               for(int i=0; i< data.length-1;i++){
                   if(i<index) {
                       temp[i] = data[i];
                   }else{
                       temp[i]=data[i+1];
                   }
               }
               data=temp;
       }
       return data;
    }
}
