class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int l = 0;
        int r = 0;

        for (int a : weights) {
            l = Math.max(l, a);
            r += a;
        }

        while (l < r) {
            int m = l + (r - l) / 2;

            if (help(weights, m, days)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public boolean help(int[] arr, int m, int d) {
        int t = 1;
        int w = 0;

        for (int a : arr) {
            if (w + a > m) {
                t++;
                w = 0;
            }
            w += a;
        }

        return t <= d;
    }
}