class Solution {
    public int coinChange(int[] nums, int am) {
        int n = nums.length;
        int inf = am + 1;
        int dp[][] = new int[n+1][am+1];
        for(int i = 1;i<=am;i++){
            dp[0][i] = inf;
        }
        for(int i =1;i<=n;i++){
            for(int j =1;j<=am;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i-1]<=j){
                    dp[i][j] = Math.min(dp[i][j],1+dp[i][j-nums[i-1]]);
                }
            }
        }
        return dp[n][am]>=inf ? -1: dp[n][am];
    }
}