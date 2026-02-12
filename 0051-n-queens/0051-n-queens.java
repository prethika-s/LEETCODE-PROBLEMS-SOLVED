class Solution {
    public List<List<String>> solveNQueens(int N) {
        List<List<String>> result = new ArrayList<>();
        boolean[] rFlag = new boolean[N];
        boolean[] cFlag = new boolean[N];
        boolean[] t1f = new boolean[2 * N - 1];
        boolean[] t2f = new boolean[2 * N - 1];
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(N, 0, result, rFlag, cFlag, t1f, t2f, board);
        return result;
    }

    private static void solve(int N, int row, List<List<String>> result,
                              boolean[] rFlag, boolean[] cFlag,
                              boolean[] t1f, boolean[] t2f,
                              char[][] board) {
        if (row == N) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                ans.add(new String(board[i]));
            }
            result.add(ans);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (rFlag[row] || cFlag[col] || t1f[row + col] || t2f[N - 1 - row + col]) continue;

            rFlag[row] = true;
            cFlag[col] = true;
            t1f[row + col] = true;
            t2f[N - 1 - row + col] = true;
            board[row][col] = 'Q';

            solve(N, row + 1, result, rFlag, cFlag, t1f, t2f, board);

            rFlag[row] = false;
            cFlag[col] = false;
            t1f[row + col] = false;
            t2f[N - 1 - row + col] = false;
            board[row][col] = '.';
        }
    }
}