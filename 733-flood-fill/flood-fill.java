class Solution {
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};

    public void dfs(int[][] arr,int i,int j,int col,boolean[][] vis,int s){
        arr[i][j] = col;
        vis[i][j] = true;

        for(int k=0;k<4;k++){
            int ni = i+dr[k];
            int nj = j+dc[k];

            if(ni>=0 && ni<arr.length && nj>=0 && nj<arr[0].length && arr[ni][nj] ==s){
                if(!vis[ni][nj]) dfs(arr,ni,nj,col,vis,s);
            }
        }
    }

    public int[][] floodFill(int[][] arr, int sr, int sc, int col) {
        if(arr[sr][sc] == col) return arr;
        boolean[][] vis = new boolean[arr.length][arr[0].length];
        dfs(arr,sr,sc,col,vis,arr[sr][sc]);
        return arr;  
    }
}