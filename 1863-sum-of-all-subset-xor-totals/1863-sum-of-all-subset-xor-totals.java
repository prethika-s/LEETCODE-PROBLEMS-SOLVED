class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }
    
    private int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }
        int include = dfs(nums, index + 1, currentXor ^ nums[index]);
        int exclude = dfs(nums, index + 1, currentXor);
        return include + exclude;
    }
}