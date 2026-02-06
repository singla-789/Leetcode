class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)-> Integer.compare(a[1],b[1]));

        int n = pairs.length;
        int ans =1;
        int[] curr = pairs[0];
        for(int i=1;i<n;i++){
            int[] next = pairs[i];
            if(curr[1]<next[0]){
                ans++;
                curr = next;
            }
        }

        return ans;
    }
}