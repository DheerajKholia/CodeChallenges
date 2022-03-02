package com.dheeraj.java.algorithms.backtracking;

public class HamiltonianCycle {
    private int numOfVertexes;
    private int[] hamiltonionPath;
    private int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numOfVertexes=adjacencyMatrix[0].length;
        this.hamiltonionPath=new int[numOfVertexes];
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix={
                                {0, 1, 0, 0, 0, 1},
                                {1, 0, 1, 0, 0, 0},
                                {0, 1, 0, 0, 1, 0},
                                {0, 0, 0, 0, 1, 1},
                                {0, 0, 1, 1, 0, 1},
                                {1, 0, 0, 1, 1, 0}
                                };
        HamiltonianCycle demo=new HamiltonianCycle(adjacencyMatrix);
        demo.solve();
    }

    public void solve(){
        hamiltonionPath[0]=0;
        if(findSolution(1)){
            showResult();
        }else{
            System.out.println("There is o solution");
        }
    }

    private boolean findSolution(int position){
        if(position == this.numOfVertexes){
            if(adjacencyMatrix[hamiltonionPath[position-1]][hamiltonionPath[0]] ==1){
                return true;
            } else{
                return false;
            }
        }
        for(int vertexIndex=1;vertexIndex < numOfVertexes; ++vertexIndex){
            if(isValid(vertexIndex,position)){
                hamiltonionPath[position]=vertexIndex;

                if(findSolution(position+1)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(int vertex, int actualPosition){
        if(adjacencyMatrix[hamiltonionPath[actualPosition-1]][vertex]==0){
            return false;
        }
        for(int i=0;i<actualPosition;++i){
            if(hamiltonionPath[i]==vertex){
                return false;
            }
        }
        return true;
    }
    private void showResult(){
        System.out.println("Hamiltonian cycle exists:  ");
        for(int i=0;i<hamiltonionPath.length;i++){
            System.out.print(hamiltonionPath[i] + "-");
        }
        System.out.println(hamiltonionPath[0]);
    }

}
