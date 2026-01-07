class Solution {
    public boolean search(int[] nums, int target) {
       int N = nums.length;
       int left = 0;
       int right = N-1;
       boolean isFound = false;
       while(left<=right){
        int mid = left+(right-left)/2;
        if(nums[mid]==target) return true;
        if(nums[mid]==nums[right] && nums[mid]==nums[left]){
            left++;
            right--;
        }
        else if(nums[left]<=nums[mid]){
            if(nums[mid]>target && nums[left]<=target){
                right = mid-1;
            }
            else left = mid+1;
        }
        else{
            if(nums[mid]<target && nums[right]>=target){
                left = mid+1;
            }
            else right = mid-1;
        }
       } 
       return false;
    }
}