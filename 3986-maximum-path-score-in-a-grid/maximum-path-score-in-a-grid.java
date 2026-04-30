class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][k+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int c = 0; c <= k; c++){
                    dp[i][j][c] = -1;
                }
            }
        }

        int startCost = grid[0][0] == 0 ? 0 : 1;
        if(startCost <= k) {
            dp[0][0][startCost] = grid[0][0];
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int c = 0; c <= k; c++){

                    // ✅ FIXED CONDITION
                    if(dp[i][j][c] == -1) continue;

                    // move down
                    if(i + 1 < n){
                        int val = grid[i+1][j];
                        int cost = (val == 0 ? 0 : 1);
                        int nc = c + cost;

                        if(nc <= k){
                            dp[i+1][j][nc] = Math.max(dp[i+1][j][nc],
                                                       dp[i][j][c] + val);
                        }
                    }

                    // move right
                    if(j + 1 < m){
                        int val = grid[i][j+1];
                        int cost = (val == 0 ? 0 : 1);
                        int nc = c + cost;

                        if(nc <= k){
                            dp[i][j+1][nc] = Math.max(dp[i][j+1][nc],
                                                       dp[i][j][c] + val);
                        }
                    }
                }
            }
        }

        int ans = -1;

        for(int i = 0; i <= k; i++){
            ans = Math.max(ans, dp[n-1][m-1][i]);
        }

        return ans;
    }
}