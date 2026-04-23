class Solution {
    public int maxProfit(int[] prices) {
        int a = prices[0];
        int ans = Integer.MIN_VALUE;

        for(int b : prices){
            if(a>b){
                a = b;
            }

            ans = Math.max(ans,b-a);
        }

        return ans;

    }
}