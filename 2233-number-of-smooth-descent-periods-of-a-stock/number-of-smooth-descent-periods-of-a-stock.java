class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans =0;
        int n = prices.length;
        int count=1;
        for(int i=0;i<n-1;i++){
            if(prices[i]==prices[i+1]+1) count++;
            else count=1;

            ans += count;
        }
        return ans+1;
    }
}