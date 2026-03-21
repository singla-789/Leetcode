class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int t = x;
        int b = x+k-1;

        while(t<b){
            for(int i =y;i<=y+k-1;i++){
                int temp = grid[t][i];
                grid[t][i] = grid[b][i];
                grid[b][i] = temp;
            }
            t++;
            b--;
        }

        return grid;
    }
}