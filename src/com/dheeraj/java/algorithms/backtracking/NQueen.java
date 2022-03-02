package com.dheeraj.java.algorithms.backtracking;

public class NQueen {
    private int[][] chessTable;
    private int numOfQueens;

    public NQueen(int numOfQueens) {
        this.numOfQueens = numOfQueens;
        this.chessTable=new int[numOfQueens][numOfQueens];
    }

    public static void main(String[] args) {
        NQueen queen=new NQueen(4);
        queen.solve();

    }

    public void solve(){
        if(setQueens(0)){
            printQueen();
        }else {
            System.out.println("There is no solution....");
        }
    }

    private boolean setQueens(int colIndex){

        if(colIndex==numOfQueens) return true;
        for(int rowIndex=0;rowIndex<numOfQueens;rowIndex++){
            if(isPlacedValid(rowIndex,colIndex)){

                chessTable[rowIndex][colIndex]=1;
                if(setQueens(colIndex+1)) return true;

                chessTable[rowIndex][colIndex]=0;
            }
        }
        return false;
    }

    private boolean isPlacedValid(int rowIndex, int colIndex){
        for (int i = 0; i < colIndex; i++) {
            if (chessTable[rowIndex][i] ==1){
                return false;
            }
        }

        for (int i = rowIndex,j=colIndex; i >=0 && j>=0 ; i--,j--) {
            if (chessTable[i][j]==1){
                return false;
            }
        }

        for (int i = rowIndex,j=colIndex; i < chessTable.length && j>=0; i++,j--) {
            if (chessTable[i][j]==1){
                return false;
            }
        }
        return true;
    }
    private void printQueen(){
        for(int i=0; i<chessTable.length;i++){
            for(int j=0;j<chessTable.length;j++){
                if(chessTable[i][j]==1){
                    System.out.print("*\t");
                }else{
                    System.out.print("-\t");
                }
            }
            System.out.println();
        }
    }
}

