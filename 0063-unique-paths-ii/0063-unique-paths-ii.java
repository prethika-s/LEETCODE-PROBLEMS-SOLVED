class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[R-1][C-1]==1) return 0;
        int[][] dp = new int[R][C];
        dp[R-1][C-1]=1;
        for(int row=R-1; row>=0; row--){
            for(int col=C-1; col>=0; col--){
                if(row==R-1 && col==C-1) continue;
                if(obstacleGrid[row][col]==1) continue;
                if(row==R-1){
                    dp[row][col]=dp[row][col+1];
                }
                else if(col==C-1){
                    dp[row][col]=dp[row+1][col];
                }
                else{
                    dp[row][col]=dp[row][col+1]+dp[row+1][col];
                }
            }
        }
        for(int row=0; row<R; row++){
            for(int col=0; col<C; col++){
                System.out.print(dp[row][col]+" ");
            }
            System.out.println();
        }
        return dp[0][0];
    }
}