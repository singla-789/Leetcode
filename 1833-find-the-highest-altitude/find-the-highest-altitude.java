class Solution {
    public int largestAltitude(int[] gain) {
        int ans = Integer.MIN_VALUE;
        int t =0;
        for(int a : gain){
            t+=a;
            ans = Math.max(ans,t);
        }

        return ans<0? 0:ans;
    }
}