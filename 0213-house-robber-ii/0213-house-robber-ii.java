class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 1) return nums[0];
        int considerFirst = robLinear(nums, 0, N-2);
        int considerSecond = robLinear(nums, 1, N-1);
        return Math.max(considerFirst, considerSecond);
    }
    public int robLinear(int[] nums, int start, int end){
        int len = end-start+1;
        int[] dp = new int[len];
        dp[0] = nums[start];
        if(len==1) return dp[0];
        dp[1]=Math.max(nums[start], nums[start+1]);
        for(int i=2; i<len; i++){
            dp[i]=Math.max(dp[i-1], nums[start+i]+dp[i-2]);
        }
        return dp[len-1];
    }
}