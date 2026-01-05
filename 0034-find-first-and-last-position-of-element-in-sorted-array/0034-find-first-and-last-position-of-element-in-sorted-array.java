class Solution {
    public int[] searchRange(int[] nums, int target) {
         int N = nums.length;
        int lowerBound = N;
        int first = 0;
        int last = N-1;
        while(first<=last){
            int mid = first+(last-first)/2;
            if(nums[mid]>=target){
                lowerBound = Math.min(lowerBound, mid);
                last = mid-1;
            }
            else{
                first = mid+1;
            }
        }
        //System.out.println(lowerBound);
        int upperBound = N;
        first = 0;
        last = N-1;
        while(first<=last){
            int mid = first+(last-first)/2;
            if(nums[mid]>target){
                upperBound = Math.min(upperBound, mid);
                last = mid-1;
            }
            else{
                first = mid+1;
            }
        }
        //System.out.println(upperBound);
        if(lowerBound==N || nums[lowerBound]!=target){
            return new int[]{-1,-1};
        }
        else{
            return new int[]{lowerBound, upperBound-1};
        }
    }
}