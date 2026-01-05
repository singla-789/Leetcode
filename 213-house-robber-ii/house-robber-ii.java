class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int case1 = util(nums,0,n-2);
        int case2 = util(nums,1,n-1);

        return Math.max(case1,case2);
    }

    public int util(int[] arr, int s,int e){
        int n = e-s+1;

        int dp[] = new int[n+1];
        dp[0]  = 0;
        dp[1] = arr[s];
        for(int i=2;i<=n;i++){
            dp[i] = Math.max(dp[i-1],arr[s+i-1]+dp[i-2]);
        }

        return dp[n];
    }
}