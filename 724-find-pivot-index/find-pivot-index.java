class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        pre[0] = nums[0];
        for(int i =1;i<n;i++){
            pre[i] = pre[i-1]+nums[i];
        }

        for(int i =0;i<n;i++){
            if(pre[i]-nums[i] == pre[n-1]-pre[i]){
                return i;
            }
        }

        return -1;
    }
}