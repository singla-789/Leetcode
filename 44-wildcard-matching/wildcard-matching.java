class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;
        for(int i =1;i<=m;i++){
            char a = p.charAt(i-1);
            if(i==1 && (a=='*')) dp[0][i] = true;
            if(a=='*' && dp[0][i-1]) dp[0][i] = true;
        }

        for(int i=1;i<=n;i++){
            for(int j =1;j<=m;j++){
                char a = s.charAt(i-1);
                char b = p.charAt(j-1);
                if(a==b || b=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(b=='*'){
                    dp[i][j] = dp[i-1][j] | dp[i][j-1] | dp[i-1][j-1]; 
                }
            }
        }

        return dp[n][m];
    }
}