class Solution {
    public double champagneTower(int pour, int i, int j) {
        double dp[][] = new double[i+1][i+1];
        dp[0][0] = pour;
        for(int a=1;a<i+1;a++){
            for(int b = 0;b<=a;b++){
                double l = b-1>=0 ?Math.max(0,dp[a-1][b-1]-1)/2.0:0;
                double r= b<=i-1?Math.max(0,dp[a-1][b]-1)/2.0:0;
                dp[a][b] = l+r;
            }
        }
        return Math.min(1,dp[i][j]);
    }
}