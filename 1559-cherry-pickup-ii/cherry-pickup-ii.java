class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                for(int k =0;k<m;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return help(0,0,m-1,grid);
    }

    public int help(int i,int j1,int j2,int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        if(i>=n || i<0 || j1<0 || j1>=m || j2<0 || j2>=m){
            return (int)-1e8;
        }

        if(i==n-1){
            if(j1==j2) return grid[i][j1];
            else{
                return (grid[i][j1]+grid[i][j2]);
            }
        }

        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];

        int ans = 0;

        for(int k = -1;k<=1;k++){
            int nj1 = j1+k;
            for(int a = -1;a<=1;a++){
                int nj2 = j2+a;
                if(j1 == j2){
                    ans = Math.max(ans,grid[i][j1] + help(i+1,nj1,nj2,grid));
                }else{
                    ans = Math.max(ans,grid[i][j1]+grid[i][j2]+help(i+1,nj1,nj2,grid));
                }
            }
        }

        dp[i][j1][j2] = ans;

        return ans;
    }
}