class Solution {
    public int minimizedMaximum(int n, int[] q) {

        int l = 1;
        int r =Arrays.stream(q).max().getAsInt();
        int ans = -1;
        
        while(l<=r){
            int mid = l +(r-l)/2;
            if(can(n,mid,q)){
                r = mid -1;
                ans = mid;
            }else{
                l = mid +1;
            }
        }
        return ans;
    }

    public boolean can(int n,int k,int[] q){
        if(k==0) return false;
        int s = 0;
        for(int i: q){
            s += (i-1)/k+1;
            if(s>n) return false;
        }
        return true;

    }
}