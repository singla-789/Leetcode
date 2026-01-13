class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int dp[][] = new int[n][n];

        for(int i=0;i<n;i++){
            dp[0][i] = mat[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j =0;j<n;j++){
                if(j==0) dp[i][j] = mat[i][j] +  Math.min(dp[i-1][j],dp[i-1][j+1]);
                else if(j==n-1) dp[i][j] = mat[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]);
                else{
                    dp[i][j] = mat[i][j] + Math.min(Math.min(dp[i-1][j+1],dp[i-1][j-1]),dp[i-1][j]);
                }
            }
        }   

        int ans = dp[n-1][0];

        for(int i =1;i<n;i++){
            ans = Math.min(ans,dp[n-1][i]);
        }

        return ans;
    }
}