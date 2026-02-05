class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int N = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        result.add(new ArrayList<>());
        recursion(0, nums, result, temp,N);
        return result;
    }
    public void recursion(int idx,int[] nums, List<List<Integer>> result, List<Integer> temp, int N){
        if(temp.size()==N) return;
        for(int i=idx; i<N; i++){
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            recursion(i+1, nums, result, temp, N);
            temp.remove(temp.size()-1);
        }
    }
}