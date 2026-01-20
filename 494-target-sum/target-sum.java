class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int x : nums) total += x;

        // Invalid cases
        if (total < Math.abs(target) || (total + target) % 2 != 0)
            return 0;

        int s = (total + target) / 2;

        int[] dp = new int[s + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = s; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[s];
    }
}
