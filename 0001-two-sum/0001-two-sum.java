class Solution {
    public int[] twoSum(int[] arr1, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        //map.put(0,-1);
        for(int i=0; i<arr1.length; i++){
            int comp = target-arr1[i];
            if(map.containsKey(comp)){
                result[0]=map.get(comp);
                result[1]=i;
                //System.out.println(map.get(comp)+" "+i);
                break;
            }
            map.put(arr1[i],i);
        }
        return result;
    }
}