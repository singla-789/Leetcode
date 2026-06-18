class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int l =0;
        int r =0;

        for(int a :nums){
            l = Math.max(l,a);
            r += a;
        }

        while(l<r){
            int m = l+(r-l)/2;
            if(help(nums,m,k)){
                r = m;
            }else{
                l = m+1;
            }
        }

        return l;
    }

    public boolean help(int[] arr,int m,int k){
        int count =1;
        int t =0;

        for(int a : arr){
            if(t+a<=m){
                t+=a;
            }else{
                count++;
                t = a;
            }
        }

        return count<=k;
    }
}