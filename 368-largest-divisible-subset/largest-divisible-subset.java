import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums); 

        int[] dp = new int[n];
        int[] par = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(par, -1);

        int maxi = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    par[i] = j;
                }
            }
            if (dp[i] > dp[maxi]) {
                maxi = i;
            }
        }

        List<Integer> res = new ArrayList<>();

        int i = maxi;
        while (i != -1) {  
            res.add(nums[i]);
            i = par[i];
        }

        Collections.reverse(res);

        return res;
    }
}