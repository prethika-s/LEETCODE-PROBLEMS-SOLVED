class Solution {
    public long getSum(int[] nums, int mid){
        long sum = 0;
        for(int x : nums){
            sum+= (x+mid-1)/mid;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) max = Math.max(max, nums[i]);
        int low = 1;
        int high = max;
        int result = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            long sum = getSum(nums, mid);
            if(sum<=threshold){
                result = mid;
                high = mid-1;
            } 
            else low = mid+1;
        }
        return result;
    }
}