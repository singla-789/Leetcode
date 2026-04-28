class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int r = grid[0][0]%x;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                list.add(grid[i][j]);
                if(grid[i][j]%x!=r){
                    return -1;
                }
            }
        }
        Collections.sort(list);
        int n = list.size();
        int t = list.get((n)/2);
        int ans =0;
        for(int i : list){
            ans += Math.abs(i-t)/x;
        }
        return ans;
    }
}