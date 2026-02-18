class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            dp[i][0] = i;
        }

        for(int i =1;i<=m;i++){
            dp[0][i] = i;
        }

        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }

                int a = dp[i][j-1]+1;
                int b = dp[i-1][j] +1;
                int c = dp[i-1][j-1]+1;

                dp[i][j] = Math.min(Math.min(a,b),c);
            }
        }

        return dp[n][m];
    }

    // recusion
    // public int help(String str1 ,String str2,int i,int j){

    //     if(i==-1) return j+1;
    //     else if(j==-1) return i+1;


    //     if(str1.charAt(i)==str2.charAt(j)){
    //         return help(str1,str2,i-1,j-1);
    //     }

    //     //insert
    //     int a = help(str1,str2,i,j-1)+1;
    //     //delete
    //     int b = help(str1,str2,i-1,j)+1;
    //     //replace
    //     int c = help(str1,str2,i-1,j-1)+1;

    //     return Math.min(Math.min(a,b),c);
    // }
}