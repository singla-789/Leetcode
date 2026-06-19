class Solution {
    public boolean searchMatrix(int[][] mat, int t) {
        int n = mat.length;
        int m = mat[0].length;
        int r = 0;
        int c = m-1;

        while(r<n && c>=0){
            int mid = mat[r][c];

            if(mid<t){
                r++;
            }else if(mid>t){
                c--;
            }else{
                return true;
            }
        }

        return false;
    }
}