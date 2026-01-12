class Solution {
    public int findPeakElement(int[] nums) {
        int N = nums.length;
        int left = 0;
        int right = N-1;
        int peak = Integer.MIN_VALUE;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[mid+1]){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}