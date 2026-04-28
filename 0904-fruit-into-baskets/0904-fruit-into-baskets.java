class Solution {
    public int totalFruit(int[] fruits) {
        int N = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        int maxCount = 0;
        for(int right=0; right<N; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
            count++;
            while(map.size()>2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left])==0) map.remove(fruits[left]);
                left++;
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}