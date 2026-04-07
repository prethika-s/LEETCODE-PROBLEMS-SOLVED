class Solution {
    private int calcCoins(int[] nums, int l, int r, int[][] dp){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int max = Integer.MIN_VALUE;
        for(int k=l; k<=r; k++){
            int cost = (l-1<0 ? 1 : nums[l-1])*nums[k]*(r+1<nums.length? nums[r+1] : 1 )+calcCoins(nums, l, k-1, dp)+calcCoins(nums, k+1, r, dp);
            max = Math.max(cost, max);
        }
        dp[l][r]=max;
        return dp[l][r];
    }
    public int maxCoins(int[] nums) {
        int N = nums.length;
        int dp[][] = new int[N][N];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return calcCoins(nums, 0, N-1, dp);
    }
}