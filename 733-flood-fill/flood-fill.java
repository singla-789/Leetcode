class Solution {

    int[] dr = new int[]{0,-1,0,1};
    int[] dc = new int[]{1,0,-1,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        if(image[sr][sc] == color) return image;

        boolean vis[][] = new boolean[n][m];

        dfs(image,vis,sr,sc,color,image[sr][sc]);

        return image;
    }

    public void dfs(int[][] arr,boolean vis[][],int sr,int sc,int color,int st){
        int n = arr.length;
        int m = arr[0].length;
        vis[sr][sc] = true;
        arr[sr][sc] = color;
        for(int i =0;i<4;i++){
            int r = sr + dr[i];
            int c = sc + dc[i];
            if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && arr[r][c]==st){
                dfs(arr,vis,r,c,color,st);
            }
        }
    }
}