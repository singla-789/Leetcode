class Solution {

    int[] dr = new int[]{0,1,0,-1};
    int[] dc = new int[]{1,0,-1,0};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans =0;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int  i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i =0;i<4;i++){
                int r = curr[0] + dr[i];
                int c = curr[1] + dc[i];
                int t = curr[2];
                if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && grid[r][c]==1){
                    q.add(new int[]{r,c,t+1});
                    vis[r][c] = true;
                    ans = Math.max(ans,t+1);
                    grid[r][c] = 2;
                }
            }
        }

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1;
            }
        }

        return ans;
    }
}