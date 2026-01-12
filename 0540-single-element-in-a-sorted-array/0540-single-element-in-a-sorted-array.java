class Solution {
    public int singleNonDuplicate(int[] nums) {
       int N = nums.length;
        int left = 0;
        int right = N-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    left = mid+2;
                }
                else right = mid;
            }
            else{
                if(nums[mid]==nums[mid-1]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return nums[left];        
    }
}