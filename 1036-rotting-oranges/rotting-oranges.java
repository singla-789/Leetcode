class Solution {
    int[] dr = { -1, 0, 1, 0 };
    int[] dc = { 0, 1, 0, -1 };

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j, 0 });
                    vis[i][j] = true;
                }
            }
        }

        int ans = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int t = curr[2];

            for (int k = 0; k < 4; k++) {
                int ni = i + dr[k];
                int nj = j + dc[k];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] != 0 && !vis[ni][nj]) {
                    vis[ni][nj] = true;
                    grid[ni][nj] = 2;
                    q.add(new int[] { ni, nj, t + 1 });
                    ans = Math.max(ans, t + 1);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}