class Solution {
    public static boolean isPossible(int[] bloomDay, int day, int m, int n){
        int boquet = 0;
        int flower = 0;
        for(int b:bloomDay){
            if(b<=day){
                flower++;
                if(flower==n){
                    boquet++;
                    flower = 0;
                }
            }
            else{
                flower = 0;
            }
        }
        return boquet >= m;
    }
    public int minDays(int[] bloomDay, int m, int n) {
        if((long)m*n > bloomDay.length){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<bloomDay.length; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int low = min;
        int high = max;
        int result = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(bloomDay,mid,m,n)){
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