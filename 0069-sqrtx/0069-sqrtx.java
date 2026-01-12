class Solution {
    public int mySqrt(int N) {
        if(N==0 || N==1) return N;
        int left = 1;
        int right = N;
        int sqr = left;
        while(left<=right){
            int mid = left+(right-left)/2;
            if((long)mid*mid <= N){
                sqr = mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return sqr;
    }
}