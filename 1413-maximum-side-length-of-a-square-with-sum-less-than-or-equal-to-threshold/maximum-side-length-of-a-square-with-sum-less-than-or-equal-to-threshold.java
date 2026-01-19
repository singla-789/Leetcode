class Solution {

    // check if there exists a square of size k with sum <= t
    private boolean exists(int[][] ps, int k, int t) {
        int n = ps.length - 1;
        int m = ps[0].length - 1;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int sum = ps[i][j]
                        - ps[i - k][j]
                        - ps[i][j - k]
                        + ps[i - k][j - k];

                if (sum <= t) return true;
            }
        }
        return false;
    }

    public int maxSideLength(int[][] mat, int t) {
        int n = mat.length;
        int m = mat[0].length;

        // 2D prefix sum
        int[][] ps = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ps[i][j] = mat[i - 1][j - 1]
                         + ps[i - 1][j]
                         + ps[i][j - 1]
                         - ps[i - 1][j - 1];
            }
        }

        int lo = 0, hi = Math.min(n, m), ans = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (exists(ps, mid, t)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}
