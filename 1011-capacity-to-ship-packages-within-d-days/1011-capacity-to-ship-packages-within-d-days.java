class Solution {
    public int calcDays(int[] weights, int limit){
        int days = 1;
        int weight = 0;
        for(int i=0; i<weights.length; i++){
            if(weight+weights[i]>limit){
                days++;
                weight = weights[i];
            }
            else{
                weight+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for(int i=0; i<weights.length; i++){
            max = Math.max(max, weights[i]);
            sum+=weights[i];
        }
        int low = max;
        int high = (int) sum;
        int result = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            int requiredDays = calcDays(weights, mid);
            if(requiredDays<=days){
                result = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return result;
    }
}