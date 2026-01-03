class Solution {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[][] isZero = new boolean[M][N];
        for(int row=0; row<M; row++){
            for(int col=0; col<N; col++){
                if(matrix[row][col]==0) isZero[row][col]=true;
            }
        }
        for(int row=0; row<M; row++){
            for(int col=0; col<N; col++){
                if(isZero[row][col]==true){
                    int tR = 0;
                    int tC = 0;
                    for(;tR<M; tR++){
                        matrix[tR][col]=0;
                    }
                    for(;tC<N; tC++){
                        matrix[row][tC]=0;
                    }
                }
            }
        }
    }
}