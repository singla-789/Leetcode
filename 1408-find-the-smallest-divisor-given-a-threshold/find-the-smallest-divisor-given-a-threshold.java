class Solution {
    public int smallestDivisor(int[] nums, int t) {
        int n = nums.length;
        int l = 1;
        int r = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            r = Math.max(r,nums[i]);
        }
        while(l<r){
            int m = l+(r-l)/2;
            if(help(m,nums,t)){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }

    public boolean help(int m,int[] nums,int t){
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            double a = Math.ceil((double) nums[i] / m);
            sum += (int)a;
        }

        return sum<=t ? true : false;
    }

}