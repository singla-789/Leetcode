class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int l[] = new int[n];
        int ans[] = new int[n];

        for(int i =1;i<n;i++ ){
            l[i] = l[i-1]+nums[i-1];
        }
        int r =0;

        for(int i = n-1;i>=0;i--){
            ans[i] = Math.abs(l[i]-r);
            r = r+nums[i];
        }

        return ans;
    }
}