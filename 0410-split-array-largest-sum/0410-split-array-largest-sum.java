class Solution {
    public boolean canAllocate(int[] arr, int k, int limit){
        int students = 1;
        int pages = 0;
        for(int b: arr){
            if(pages+b > limit){
                students++;
                pages = b;
            }
            else{
                pages+=b;
            }
        }
        return students<=k;
    }
    public int findPages(int[] arr, int k) {
        if(arr.length<k) return -1;
        // code here
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        int low = max;
        int high = sum;
        int result = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canAllocate(arr, k, mid)){
                result = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return result;
    }
    public int splitArray(int[] nums, int k) {
        return findPages(nums,k);
    }
}