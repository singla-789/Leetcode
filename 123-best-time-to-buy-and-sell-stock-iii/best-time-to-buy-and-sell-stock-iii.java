class Solution {
    int[][][] dp ;
    public int maxProfit(int[] p) {
        int n = p.length;
        dp = new int[n][2][2];
        for(int i =0;i<n;i++){
            for(int j =0;j<2;j++){
                for(int k =0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return help(p,0,0,2);
    }

    public int help(int[] p,int buy,int idx ,int l){
        int n = p.length;
        if(idx == n) return 0;
        if(l==0) return 0;
        int ans =Integer.MIN_VALUE;

        if(dp[idx][l-1][buy] != -1) return dp[idx][l-1][buy];

        if(buy==0){
            int c1= -p[idx] + help(p,1,idx+1,l);
            int c2 = help(p,0,idx+1,l);
            ans = Math.max(c1,c2);
        }else{
            int c1 = p[idx]+help(p,0,idx+1,l-1);
            int c2 = help(p,1,idx+1,l);
            ans = Math.max(c1,c2);
        }
        dp[idx][l-1][buy] = ans;

        return ans;
    }
}