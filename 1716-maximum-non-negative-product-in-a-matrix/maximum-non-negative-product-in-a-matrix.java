class Solution {

    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[][] maxDp = new long[n][m];
        long[][] minDp = new long[n][m];

        int MOD = (int)1e9 + 7;

        // Base case
        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];

        // First column
        for (int i = 1; i < n; i++) {
            maxDp[i][0] = maxDp[i - 1][0] * grid[i][0];
            minDp[i][0] = maxDp[i][0];
        }

        // First row
        for (int j = 1; j < m; j++) {
            maxDp[0][j] = maxDp[0][j - 1] * grid[0][j];
            minDp[0][j] = maxDp[0][j];
        }

        // Fill DP
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                long val = grid[i][j];

                long a = maxDp[i - 1][j] * val;
                long b = minDp[i - 1][j] * val;
                long c = maxDp[i][j - 1] * val;
                long d = minDp[i][j - 1] * val;

                maxDp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minDp[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long ans = maxDp[n - 1][m - 1];

        if (ans < 0) return -1;
        return (int)(ans % MOD);
    }
}