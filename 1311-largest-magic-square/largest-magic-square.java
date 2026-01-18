class Solution {

    private boolean isMagic(int[][] g, int size, int r, int c) {
        int n = g.length, m = g[0].length;
        if (r + size > n || c + size > m) return false;

        int target = 0;
        int endR = r + size - 1;
        int endC = c + size - 1;

        // rows
        for (int i = r; i <= endR; i++) {
            int rowSum = 0;
            for (int j = c; j <= endC; j++) rowSum += g[i][j];
            if (i == r) target = rowSum;
            else if (rowSum != target) return false;
        }

        // columns
        for (int j = c; j <= endC; j++) {
            int colSum = 0;
            for (int i = r; i <= endR; i++) colSum += g[i][j];
            if (colSum != target) return false;
        }

        // main diagonal
        int d1 = 0;
        for (int i = 0; i < size; i++)
            d1 += g[r + i][c + i];
        if (d1 != target) return false;

        // anti diagonal
        int d2 = 0;
        for (int i = 0; i < size; i++)
            d2 += g[r + i][endC - i];
        if (d2 != target) return false;

        return true;
    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        for (int size = Math.min(n, m); size > 1; size--) {
            for (int i = 0; i + size <= n; i++) {
                for (int j = 0; j + size <= m; j++) {
                    if (isMagic(grid, size, i, j)) return size;
                }
            }
        }
        return 1;
    }
}
