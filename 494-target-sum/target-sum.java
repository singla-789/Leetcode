class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;

        if (sum < Math.abs(target)) return 0;

        if ((target + sum) % 2 != 0) return 0;

        int t = (target + sum) / 2;
        int dp[][] = new int[n+1][t+1];
        dp[0][0] =1;
        for(int i =1;i<n+1;i++){
            for(int j =0;j<t+1;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][t];

    }
}