class Solution {
    int[][][] dp;

    public int maxProfit(int[] p) {
        int n = p.length;
        dp = new int[n][2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int c = 0; c < 2; c++) {
                    dp[i][j][c] = Integer.MIN_VALUE;
                }
            }
        }

        return dfs(p, 0, 0, 0);
    }

    public int dfs(int[] p, int idx, int tra, int cool) {
        if (idx == p.length) return 0;

        if (dp[idx][tra][cool] != Integer.MIN_VALUE)
            return dp[idx][tra][cool];

        int ans = Integer.MIN_VALUE;

        if (cool == 1) {
            ans = dfs(p, idx + 1, 0, 0);
        }
        else if (tra == 0) {
            int buy = -p[idx] + dfs(p, idx + 1, 1, 0);
            int skip = dfs(p, idx + 1, 0, 0);
            ans = Math.max(buy, skip);
        }
        else {
            int sell = p[idx] + dfs(p, idx + 1, 0, 1);
            int hold = dfs(p, idx + 1, 1, 0);
            ans = Math.max(sell, hold);
        }

        return dp[idx][tra][cool] = ans;
    }
}