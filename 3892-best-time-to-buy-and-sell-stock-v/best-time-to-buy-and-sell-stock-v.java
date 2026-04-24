class Solution {
    long[][][] dp;

    public long maximumProfit(int[] p, int k) {
        int n = p.length;
        dp = new long[n][3][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int a = 0; a < k; a++) {
                    dp[i][j][a] = Long.MIN_VALUE;
                }
            }
        }

        return help(p, 0, 2, k);
    }

    public long help(int[] p, int idx, int tra, int lim) {
        int n = p.length;

        if (idx == n) {
            return (tra == 2) ? 0 : Long.MIN_VALUE;
        }

        if (lim == 0) {
            return (tra == 2) ? 0 : Long.MIN_VALUE;
        }

        if (dp[idx][tra][lim - 1] != Long.MIN_VALUE)
            return dp[idx][tra][lim - 1];

        long ans = Long.MIN_VALUE;

        if (tra == 2) {
            long skip = help(p, idx + 1, 2, lim);
            ans = Math.max(ans, skip);

            long next;
            next = help(p, idx + 1, 0, lim);
            if (next != Long.MIN_VALUE)
                ans = Math.max(ans, -p[idx] + next);
            next = help(p, idx + 1, 1, lim);
            if (next != Long.MIN_VALUE)
                ans = Math.max(ans, p[idx] + next);
        }

        else if (tra == 0) {
            long hold = help(p, idx + 1, 0, lim);
            ans = Math.max(ans, hold);

            long next = help(p, idx + 1, 2, lim - 1);
            if (next != Long.MIN_VALUE)
                ans = Math.max(ans, p[idx] + next);
        }

        else {
            long hold = help(p, idx + 1, 1, lim);
            ans = Math.max(ans, hold);

            long next = help(p, idx + 1, 2, lim - 1);
            if (next != Long.MIN_VALUE)
                ans = Math.max(ans, -p[idx] + next);
        }

        return dp[idx][tra][lim - 1] = ans;
    }
}