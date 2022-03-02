package com.dheeraj.leetcode;

import java.util.*;

public class MinimumBribes {
    public static void main(String[] args) {
        //List<Integer> queue= Arrays.asList(2, 1, 5, 3, 4);
        List<Integer> queue= Arrays.asList(2, 5, 1, 3, 4);
        getMinimumBribes(queue);
    }
    public static void getMinimumBribes(List<Integer> queue) {
       //2, 1, 5, 3, 4 ==>  1, 2, 5, 3, 4 ==> 1, 2, 3, 4, 5
        // (2: 1),(1: 2), (5:3), (3:4), (4:5)
        //2==>1  1==>2   :  1 >>>(2:2) (1:1)
        //5 ==>3  3==>4  :  1 >>> (5:4) (3:3)
        //5==>4  4==>5   :  1 >>> (5:4) (4:4)

        //2, 5, 1, 3, 4
        //(2: 1),(5: 2), (1:3), (3:4), (4:5)
        int result=0;
        Map<Integer,Integer> intMap=buildMap(queue);
        boolean skipFlag=false;
        for(Map.Entry<Integer,Integer> entry:intMap.entrySet()){
            System.out.println(intMap);
            if(!skipFlag){
                skipFlag=false;
                Integer k = entry.getKey();
                Integer v=entry.getValue();
                if(k!=v){
                    if(Math.abs(k - v)>2 ){
                        System.out.println("Too chaotic");
                        return;
                    }
                    intMap.put(k,intMap.get(v));
                    intMap.put(v,k);
                    System.out.println("Swapping : " + k +" : " +v);
                    skipFlag=true;
                    result++;
                }
            }else{
                skipFlag=false;
            }

        }
        System.out.println(result);
        /*for(int i=0; i<queue.size(); i++){
            Integer val = queue.get(i);
            if(val != i+1){
                if(Math.abs(i+1-val)>2){
                    System.out.println("Too chaotic");
                    return;
                }

            }
        }*/

    }

    private static Map<Integer, Integer> buildMap(List<Integer> queue) {
        final Map<Integer,Integer> intMap=new LinkedHashMap<>();
        for(int i=0; i< queue.size();i++){
            intMap.put(queue.get(i),i+1);
        }
        return intMap;
    }
}
