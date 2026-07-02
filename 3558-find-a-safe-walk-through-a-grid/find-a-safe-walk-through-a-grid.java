class Solution {

    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};

    public boolean findSafeWalk(List<List<Integer>> grid, int h) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] maxHealth = new int[n][m];
        for(int[] row : maxHealth) Arrays.fill(row, -1);

        return dfs(grid, 0, 0, h, maxHealth);
    }

    public boolean dfs(List<List<Integer>> grid, int r, int c, int h, int[][] maxHealth){
        int n = grid.size();
        int m = grid.get(0).size();
        h -= grid.get(r).get(c);

        if(h <= 0) return false;

        if(r == n-1 && c == m-1) return true;

   
        if(maxHealth[r][c] >= h) return false;
        maxHealth[r][c] = h;

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                if(dfs(grid, nr, nc, h, maxHealth)) return true;
            }
        }

        return false;
    }
}