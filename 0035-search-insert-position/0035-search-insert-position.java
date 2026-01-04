class Solution {
    public int searchInsert(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N-1;
        int index = N;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                index = Math.min(index, mid);
                right = mid-1;
            }
            else left = mid+1;
        }
        return index;
    }
}