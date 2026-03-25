class Solution {
    public int findMaxLength(int[] nums) {
        int N = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<N; i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
        }
        int maxLength = 0;
        int sum = 0;
        for(int i=0; i<N; i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                maxLength=Math.max(maxLength,i-map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}