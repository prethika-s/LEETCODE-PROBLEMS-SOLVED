class Solution {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] profitSum = new long[n + 1];
        long[] priceSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            profitSum[i + 1] = profitSum[i] + (long) prices[i] * strategy[i];
            priceSum[i + 1] = priceSum[i] + prices[i];
        }
        long res = profitSum[n];
        for (int i = k - 1; i < n; i++) {
            long leftProfit = profitSum[i - k + 1];
            long rightProfit = profitSum[n] - profitSum[i + 1];
            long changeProfit = priceSum[i + 1] - priceSum[i - k / 2 + 1];
            res = Math.max(res, leftProfit + changeProfit + rightProfit);
        }
        return res;
    }
}