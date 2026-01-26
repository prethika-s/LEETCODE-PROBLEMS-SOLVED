class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] travel = new boolean[lastDay + 1];
        for (int d : days) travel[d] = true;
        int[] dp = new int[lastDay + 1];
        dp[0] = 0;
        for (int d = 1; d <= lastDay; d++) {
            if (!travel[d]) {
                dp[d] = dp[d - 1];
            } else {
                int cost1 = dp[d - 1] + costs[0];
                int cost7 = dp[Math.max(0, d - 7)] + costs[1];
                int cost30 = dp[Math.max(0, d - 30)] + costs[2];
                dp[d] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }
        return dp[lastDay];
    }
}
