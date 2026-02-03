class Solution {
    public int dpfun(int m,int n, int[][]dp){
        if(m==1 || n==1){
            return 1;
        }
        if(dp[m][n]!=0){
            return dp[m][n];
        }
        dp[m][n]=dpfun(m,n-1,dp)+dpfun(m-1,n,dp);
        return dp[m][n];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return dpfun(m,n,dp);
    }
}