class Solution {

    int dr[] = { -1, 0, 1, 0 };
    int[] dc = { 0, 1, 0, -1 };

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int dist[][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];

            for (int k = 0; k < 4; k++) {
                int ni = i + dr[k];
                int nj = j + dc[k];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n && dist[ni][nj] == Integer.MAX_VALUE) {
                    dist[ni][nj] = dist[i][j] +1;
                    q.add(new int[] { ni, nj, dist[ni][nj] });
                }

            }

        }

        return dist;

    }
}