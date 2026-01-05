class Solution {
    public long maxMatrixSum(int[][] nums) {
        int n = nums.length;
        int count=0;
        int min =Integer.MAX_VALUE;
        int nm = 0;
        long ans =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                int curr = nums[i][j];
                ans+=Math.abs(curr);
                if(curr<0){
                    count++;
                }
                min = Math.min(min, Math.abs(curr));
            }
        }
        if(count%2!=0){
            ans -= 2L * min;
        }

        return ans;
    }
}