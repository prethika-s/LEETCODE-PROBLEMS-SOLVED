class Solution {
    public void dfs(int r, int c, int R, int C, int[][] grid, int time) {
        if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == 0) {
            return;
        }
        if (grid[r][c] != 1 && grid[r][c] < time) {
            return;
        }
        grid[r][c] = time;
        dfs(r + 1, c, R, C, grid, time + 1);
        dfs(r - 1, c, R, C, grid, time + 1);
        dfs(r, c + 1, R, C, grid, time + 1);
        dfs(r, c - 1, R, C, grid, time + 1);
    }

    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    dfs(r, c, R, C, grid, 2);
                }
            }
        }
        int minutes = 2;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
                minutes = Math.max(minutes, grid[r][c]);
            }
        }
        return minutes - 2;
    }
}
