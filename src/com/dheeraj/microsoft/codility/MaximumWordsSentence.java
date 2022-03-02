package com.dheeraj.microsoft.codility;

public class MaximumWordsSentence {

    public static void main(String[] args) {
        MaximumWordsSentence demo=new MaximumWordsSentence();
        String s="Forget  CVs..Save time . x x";
        System.out.println(demo.solution(s));


    }

    public int solution(String S) {
        String regex="\\.|\\?|!" ;
        String[] data = S.split(regex);
        int result=0;
        for(String sentence:data){
            int senlength= getLength(sentence.trim());
            System.out.println("Sentence :"+sentence+":  length: "+senlength);
            if(senlength>result) result=senlength;
        }
        //System.out.println(data.length);
//        for(String i:data){
//            System.out.println(i);
//        }

        return result;
    }

    private int getLength(String sentence) {
        String[] words=sentence.split("\\s");
        int res=0;
        for (String word : words) {
            if(!word.isEmpty()) res++;
        }
        return res;
    }
}
