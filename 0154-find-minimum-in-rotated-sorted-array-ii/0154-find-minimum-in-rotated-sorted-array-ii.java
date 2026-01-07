class Solution {
    public int findMin(int[] nums) {
        int N = nums.length;
        int left = 0;
        int right = N-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[left]==nums[mid] && nums[right]==nums[mid]){
                left++;
                right--;
                continue;
            }
            if(nums[mid]>nums[right]){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return nums[left];
    }
}