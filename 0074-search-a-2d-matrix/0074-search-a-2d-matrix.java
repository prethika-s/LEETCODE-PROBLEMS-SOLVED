class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int row = 0;
        boolean flag = false;
        while(row<M){
            int first = matrix[row][0];
            int last = matrix[row][N-1];
            if(first<=target && last>=target){
                int low = 0;
                int high = N-1;
                while(low<=high){
                    int mid = low+(high-low)/2;
                    if(matrix[row][mid]==target){
                        flag = true;
                        break;
                    }
                    if(matrix[row][mid]>target){
                        high = mid-1;
                    }
                    else{
                        low = mid+1;
                    }
                }
                if(flag){
                    break;
                }
            }
            row++;
        }
        return flag;
    }
}