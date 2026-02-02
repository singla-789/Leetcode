class Solution {
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};

    public void dfs(int i,int j,boolean[][] vis,char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;

        for(int k=0;k<4;k++){
            int ni = i+dr[k];
            int nj = j+dc[k];
            if(ni>=0 && ni<m && nj>=0 && nj<n && grid[i][j] != '0' && !vis[ni][nj]){
                dfs(ni,nj,vis,grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        int ans =0;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(vis[i][j]) continue;
                if(grid[i][j] == '1'){
                    dfs(i,j,vis,grid);
                    ans++;
                }
            }
        }

        return ans;


    }
}