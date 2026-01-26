class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] stepArray = new int[n];
        stepArray[0]=1;
        stepArray[1]=2;
        for(int i=2;i<n;i++){
            stepArray[i]=stepArray[i-1]+stepArray[i-2];
        }
        return stepArray[n-1];
    }
}