class Solution {
    public int totalMoney(int n) {
        int t=n, ans=0;
        for (int i=0; i<=n/7; i++) {
            int k=i+1;
            if (t/7==0) {
                for (int j=0; j<t; j++) ans+=k++;
            } else {
                for(int j=0; j<7; j++) ans+=k++;
                t-=7;
            }
        }
        return ans;
    }
}