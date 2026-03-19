class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] colX = new int[m];
        int[] colY = new int[m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int totalX = 0;
            int totalY = 0;

            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') colX[j]++;
                else if (grid[i][j] == 'Y') colY[j]++;

                totalX += colX[j];
                totalY += colY[j];

                if (totalX > 0 && totalX == totalY) {
                    ans++;
                }
            }
        }

        return ans;
    }
}