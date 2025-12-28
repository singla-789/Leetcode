class Solution {
    public int countNegatives(int[][] grid) {
        int  n = grid.length;
        int m = grid[0].length;
        int ans =0;
        for(int i =0;i<n;i++){
            // if(grid[i][0]<0) {
            //     ans+= (n-1) *m;
            //     break;
            // }
            for(int j=0;j<m;j++){
                if(grid[i][j]<0) {
                    ans += m-j;
                    break;
                }
            }
        }

        return ans;
    }
}