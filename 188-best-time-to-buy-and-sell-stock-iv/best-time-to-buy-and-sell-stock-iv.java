class Solution {
    public int maxProfit(int a, int[] p) {
        int n = p.length;
        int[][][] dp = new int[n+1][2][a+1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= a; k++) {

                    int ans;

                    if (j == 0) { 
                        int c1 = -p[i] + dp[i + 1][1][k];
                        int c2 = dp[i + 1][0][k];
                        ans = Math.max(c1, c2);
                    } else { 
                        int c1 = p[i] + dp[i + 1][0][k - 1];
                        int c2 = dp[i + 1][1][k];
                        ans = Math.max(c1, c2);
                    }

                    dp[i][j][k] = ans;
                }
            }
        }

        return dp[0][0][a];
    }
}