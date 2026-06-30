class Solution {
    public int minBitFlips(int start, int goal) {
        int a = start ^ goal;
        int ans = 0;
        for(int i =0;i<32;i++){
            if((a>>i & 1) == 1) ans++;
        }

        return ans;
    }
}