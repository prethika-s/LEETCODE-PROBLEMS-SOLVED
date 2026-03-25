class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int N = nums.length;
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }
            else{
                nums[i]=1;
            }
        }
        map.put(0l,1);
        int count = 0;
        long sum = 0;
        for(int i=0; i<N; i++){
            int num = nums[i];
            sum+=num;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}