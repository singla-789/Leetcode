import java.util.*;

class Solution {
    public int minimumEffort(int[][] tasks) {

        int l = 0;
        int r = 0;

        for (int[] t : tasks) {
            l += t[0];
            r += t[1];
        }

        while (l < r) {

            int m = l + (r - l) / 2;

            if (help(tasks, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public boolean help(int[][] arr, int m) {

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return Integer.compare(
                    (o2[1] - o2[0]),
                    (o1[1] - o1[0])
                );
            }
        });

        for (int[] a : arr) {

            if (m >= a[1]) {
                m = m - a[0];
            } else {
                return false;
            }
        }

        return true;
    }
}