class Solution {
    public int maxProfit(int[] p) {
        int b = p[0];
        int ans = 0;

        for(int  i: p){
            if(b>i){
                b = i;
            }
            ans = Math.max(ans,i-b);
        }

        return ans;

    }
}