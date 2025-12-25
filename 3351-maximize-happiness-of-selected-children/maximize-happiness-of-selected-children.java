class Solution {
    public long maximumHappinessSum(int[] hap, int k) {
        Arrays.sort(hap);
        int count =0;
        long ans = 0;
        int n = hap.length;
        for(int i=n-1;i>=n-k;i--,count++){
            long curr = (hap[i]-count)>0? hap[i]-count : 0;

            ans += curr;

            
        }   

        return ans;
    }
}