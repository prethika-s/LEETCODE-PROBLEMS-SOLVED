class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        int maxJump = 0;
        for(int i=0; i<N-1; i++){
            if(maxJump>=i) maxJump = Math.max(maxJump, i+nums[i]);
        }
        return maxJump>=N-1;
    }
}