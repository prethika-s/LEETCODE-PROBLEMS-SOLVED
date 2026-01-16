class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int row = 0;
        int col = N - 1;
        boolean flag = false;
        while (row < M && col >= 0) {
            if (matrix[row][col] == target) {
                flag = true;
                break;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return flag;
    }
}