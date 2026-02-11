class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];
       dp[m-1][n-1] = 1;
       for(int row=m-1; row>=0; row--){
        for(int col=n-1; col>=0; col--){
            if(row==m-1 && col==n-1) continue;
            if(row==m-1){
                dp[row][col]=dp[row][col+1];
            }
            else if(col==n-1){
                dp[row][col]=dp[row+1][col];
            }
            else{
                dp[row][col]=dp[row+1][col]+dp[row][col+1];
            }
        }
       } 
       for(int row=0; row<m; row++){
        for(int col=0; col<n; col++){
            System.out.print(dp[row][col]+" ");
        }
        System.out.println();
       }
       return dp[0][0];
    }
}