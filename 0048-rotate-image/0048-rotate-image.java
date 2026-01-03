class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for(int row=0; row<N; row++){
            for(int col=row+1; col<N; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        for(int row=0; row<N; row++){
            int left = 0;
            int right = N-1;
            while(left<right){
                int temp = matrix[row][left];
                matrix[row][left]=matrix[row][right];
                matrix[row][right]=temp; 
                left++;
                right--;
            }
        }
    }
}