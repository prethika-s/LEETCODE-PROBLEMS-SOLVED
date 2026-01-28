class Solution {

    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                points.add(new int[] { i, j });
            }
        }
        points.sort(Comparator.comparingInt(p -> grid[p[0]][p[1]]));
        int[][] costs = new int[m][n];
        for (int[] row : costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int t = 0; t <= k; t++) {
            int minCost = Integer.MAX_VALUE;
            for (int i = 0, j = 0; i < points.size(); i++) {
                minCost = Math.min(
                    minCost,
                    costs[points.get(i)[0]][points.get(i)[1]]
                );
                if (
                    i + 1 < points.size() &&
                    grid[points.get(i)[0]][points.get(i)[1]] ==
                    grid[points.get(i + 1)[0]][points.get(i + 1)[1]]
                ) {
                    continue;
                }
                for (int r = j; r <= i; r++) {
                    costs[points.get(r)[0]][points.get(r)[1]] = minCost;
                }
                j = i + 1;
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        costs[i][j] = 0;
                        continue;
                    }
                    if (i != m - 1) {
                        costs[i][j] = Math.min(
                            costs[i][j],
                            costs[i + 1][j] + grid[i + 1][j]
                        );
                    }
                    if (j != n - 1) {
                        costs[i][j] = Math.min(
                            costs[i][j],
                            costs[i][j + 1] + grid[i][j + 1]
                        );
                    }
                }
            }
        }
        return costs[0][0];
    }
}