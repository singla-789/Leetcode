class Solution {
    int[][][] memo;
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n][k+1];
        for(int i=0;i<m;i+=1){
            for(int j=0;j<n;j+=1){
                Arrays.fill(memo[i][j],Integer.MIN_VALUE / 2);
            }
        }
        return helper(m,n,k,0,0,grid);
    }
    private int helper(int m, int n,int k,int i, int j,int[][] grid){
        if(i==m-1 && j==n-1){
            int cost = grid[i][j] == 0 ? 0 : 1;
            if( k >= cost){
                return grid[i][j];
            }
            return -1;
        }
        if(i >= m || j >= n){
            return -1;
        }
        if(memo[i][j][k] != Integer.MIN_VALUE / 2){
            return memo[i][j][k];
        }
        int score = -1, cost = grid[i][j] == 0 ? 0 : 1;
        if(i+1 < m && cost <= k){
            // down,
            int down = helper(m,n,k-cost,i+1,j,grid);
            if(down != -1){
                down += grid[i][j];
            }
            score = Math.max(down,score);
        }
        if(j+1 < n && cost <= k){
            // right,
            int right = helper(m,n,k-cost,i,j+1,grid);
            if(right != -1){
                right += grid[i][j];
            }
            score = Math.max(right,score);
        }
        return memo[i][j][k] = score;
    }
}