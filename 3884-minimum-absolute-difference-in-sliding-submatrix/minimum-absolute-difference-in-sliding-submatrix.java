class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                for(int x = i;x<i+k;x++){
                    for(int y = j;y<j+k;y++){
                        set.add(grid[x][y]);
                    }
                }

                Iterator<Integer> it = set.iterator();
                int pre = it.next();
                int min = Integer.MAX_VALUE;

                while(it.hasNext()){
                    int curr = it.next();
                    min = Math.min(min,Math.abs(curr-pre));
                    pre = curr;
                }
                ans[i][j] = min==Integer.MAX_VALUE ? 0:min ;
            }
        }
        return ans;
    }

    
}