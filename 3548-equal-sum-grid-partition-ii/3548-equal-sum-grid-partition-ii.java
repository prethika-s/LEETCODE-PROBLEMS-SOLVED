class Solution {

    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        for (int k = 0; k < 4; k++) {
            Set<Long> exist = new HashSet<>();
            exist.add(0L);
            long sum = 0;
            m = grid.length;
            n = grid[0].length;
            if (m < 2) {
                grid = rotation(grid);
                continue;
            }
            if (n == 1) {
                for (int i = 0; i < m - 1; i++) {
                    sum += grid[i][0];
                    long tag = sum * 2 - total;
                    if (tag == 0 || tag == grid[0][0] || tag == grid[i][0]) {
                        return true;
                    }
                }
                grid = rotation(grid);
                continue;
            }
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    exist.add((long) grid[i][j]);
                    sum += grid[i][j];
                }
                long tag = sum * 2 - total;
                if (i == 0) {
                    if (
                        tag == 0 || tag == grid[0][0] || tag == grid[0][n - 1]
                    ) {
                        return true;
                    }
                    continue;
                }
                if (exist.contains(tag)) {
                    return true;
                }
            }
            grid = rotation(grid);
        }
        return false;
    }

    public int[][] rotation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][m - 1 - i] = grid[i][j];
            }
        }
        return tmp;
    }
}