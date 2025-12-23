class Solution {
    public static long makeSimilar(int[] nums, int[] target) {
    	Arrays.sort(nums);
    	Arrays.sort(target);
    	ArrayList<Integer> evenNums =  new ArrayList<Integer>();
    	ArrayList<Integer> oddNums =  new ArrayList<Integer>();
    	ArrayList<Integer> evenTarget =  new ArrayList<Integer>();
    	ArrayList<Integer> oddTarget =  new ArrayList<Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		if(nums[i] % 2 == 0) {
    			evenNums.add(nums[i]);
    		}else {
    			oddNums.add(nums[i]);
    		}
		}
    	for (int i = 0; i < target.length; i++) {
    		if(target[i] % 2 == 0) {
    			evenTarget.add(target[i]);
    		}else {
    			oddTarget.add(target[i]);
    		}
		}
        long count = 0;
    	for (int i = 0; i < evenNums.size(); i++) {
			count += Math.abs(evenNums.get(i) - evenTarget.get(i)) / 2;
		}
    	for (int i = 0; i < oddNums.size(); i++) {
			count += Math.abs(oddNums.get(i) - oddTarget.get(i)) / 2;
		}
    	return count / 2;
    }
}