class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                int idx = val - 1;
                if (nums[idx] > 0) nums[idx] = -nums[idx];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }

        return res;
    }
}
