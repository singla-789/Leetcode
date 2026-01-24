class Solution {
    public int minDistance(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i =1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(w1.charAt(i-1) == w2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return(n-dp[n][m]+m-dp[n][m]);
    }
}