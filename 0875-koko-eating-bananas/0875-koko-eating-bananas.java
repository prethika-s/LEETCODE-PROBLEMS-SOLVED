class Solution {
    public long calcTime(int[] piles, int mid){
        long timeTaken = 0;
        for (int p : piles) {
            timeTaken += (p+mid-1)/mid; 
        }
        return timeTaken;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++) max = Math.max(max, piles[i]);
        int low = 1;
        int high = max;
        int bananasToEat = max;
        while(low<=high){
            int mid = low+(high-low)/2;
            long timeTaken = calcTime(piles,mid);
            if(timeTaken<=h){
                bananasToEat = Math.min(bananasToEat, mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return bananasToEat;
    }
}