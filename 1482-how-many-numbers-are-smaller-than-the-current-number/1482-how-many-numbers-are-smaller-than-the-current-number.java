class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();
        int ctr = 0;
        for(int i:sorted) map.put(i,map.getOrDefault(i,ctr++));
        //System.out.println(map);
        for(int i=0;i<nums.length; i++) nums[i] = map.get(nums[i]);
        return nums;
    }
}