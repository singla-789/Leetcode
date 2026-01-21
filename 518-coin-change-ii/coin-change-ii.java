class Solution {
    public int change(int am, int[] nums) {
        int n  = nums.length;

        int dp[][] = new int[n+1][am+1];

        for(int i =0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i =1;i<=n;i++){
            for(int j=1;j<=am;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j] += dp[i][j-nums[i-1]];
                }
            }
        }

        return dp[n][am];
    }
}