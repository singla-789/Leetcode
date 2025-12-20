class Solution {
    public int minDeletionSize(String[] strs) {
        int n  = strs[0].length();
        int ans =0;
        for(int i =0;i<n;i++){
            int prev = strs[0].charAt(i)-'a';
            for(String s : strs){
                int a  = s.charAt(i)-'a';
                if(prev>a){
                    ans++;
                    break;
                }
                prev = a;
            }
        }
        return ans;
    }
}