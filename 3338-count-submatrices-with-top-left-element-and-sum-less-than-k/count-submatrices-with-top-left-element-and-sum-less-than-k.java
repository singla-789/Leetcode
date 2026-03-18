class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] pre = new int[n][m];

        for (int i = 0; i < n; i++) {
            pre[i][0] = grid[i][0];
            for (int j = 1; j < m; j++) {
                pre[i][j] = pre[i][j - 1] + grid[i][j];
            }
        }

        int res = 0;

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += pre[i][j];
                if (sum <= k)
                    res++;
                else
                    break;
            }
        }

        return res;
    }
}