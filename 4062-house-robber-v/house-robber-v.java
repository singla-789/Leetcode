class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long dp[] = new long[n+1];

        dp[1] = nums[0];

        for(int i =2;i<n+1;i++){
            long taken = colors[i-1]==colors[i-2] ? dp[i-2] + nums[i-1] : dp[i-1]+nums[i-1];
            dp[i] = Math.max(taken,dp[i-1]);
        }

        return dp[n];
    }
}