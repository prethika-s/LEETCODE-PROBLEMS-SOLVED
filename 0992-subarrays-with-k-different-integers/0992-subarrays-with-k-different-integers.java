class Solution {
    public int atMost(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int first = 0;
        int last = 0;
        int count = 0;
        int distinct = 0;
        while(last!=nums.length){
            map.put(nums[last], map.getOrDefault(nums[last],0)+1);
            if(map.get(nums[last])==1){
                distinct++;
            }
            while(distinct>k){
                map.put(nums[first],map.get(nums[first])-1);
                if(map.get(nums[first])==0){
                    distinct--;
                    map.remove(nums[first]);
                }
                first++;
            }
            last++;
            count += last - first + 1;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
}