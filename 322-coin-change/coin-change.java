class Solution {
    public int coinChange(int[] coins, int am) {
        int n = coins.length;
        int dp[][] = new int[n+1][am+1];
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        dp[0][0] = 0;

        for(int i =1;i<n+1;i++){
            for(int j =1;j<am+1;j++){
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1] && dp[i][j - coins[i-1]] != Integer.MAX_VALUE) {
    dp[i][j] = Math.min(dp[i][j],
                        dp[i][j - coins[i-1]] + 1);
}

            }
        }

        return dp[n][am]>=0 && dp[n][am]!=Integer.MAX_VALUE ? dp[n][am]: -1;
    }
}