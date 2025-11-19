class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> result = new ArrayList<>();
        int counter = 0;
        int prev = Integer.MIN_VALUE;
        if(arr[0]!=1){
            int s = arr[0];
            for(int i=1; i<s; i++){
                result.add(i);
            }
        }
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=arr[i-1]){
                int diff = arr[i]-arr[i-1];
                if(diff>1){
                    for(int j=arr[i-1]+1; j<arr[i];j++){
                        result.add(j);
                    }
                }
            }
        }
        if(arr[arr.length-1]!=arr.length){
            int start = arr[arr.length-1]+1;
            for(int i=start; i<=arr.length; i++){
                result.add(i);
            }
        }
        if(arr.length==2 && result.size()==0){
            if(arr[0]==arr[1]){
                if(arr[0]!=1 && !result.contains(1)) result.add(1);
                else if(!result.contains(arr[0]+1)) result.add(arr[0]+1);
            }
        }
        return result;
    }
}