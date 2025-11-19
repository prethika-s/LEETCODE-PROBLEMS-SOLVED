class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int counter = 2;
        int[] result = new int[2];
        if(nums[0]!=1){
            result[1]=1;
        }
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){
                result[0]=nums[i];
                continue;
            }
            if(nums[i]!=counter && result[1]==0){
                result[1]=counter;
            }
            counter++;
        }
        if(result[1]==0){
            result[1]=counter++;
        }
        return result;
    }
}