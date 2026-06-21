class Solution {

    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1}; 
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i =0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(board,vis,i,0);
            }
            if(board[i][m-1] == 'O'){
                dfs(board,vis,i,m-1);
            }
        }

        for(int i =0;i<m;i++){
            if(board[0][i] == 'O'){
                dfs(board,vis,0,i);
            }
            if(board[n-1][i] == 'O'){
                dfs(board,vis,n-1,i);
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] arr,boolean vis[][],int i,int j){
        int n = arr.length;
        int m = arr[0].length;
        vis[i][j] = true;
        for(int k =0;k<4;k++){
            int r = i + dr[k];
            int c = j + dc[k];
            if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && arr[r][c] == 'O'){
                dfs(arr,vis,r,c);
            }
        }
    }
}