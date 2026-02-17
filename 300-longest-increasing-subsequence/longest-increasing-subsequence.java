class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>ans.get(ans.size()-1)){
                ans.add(nums[i]);
            }else if(nums[i]<ans.get(ans.size()-1)){
                ans.set(bs(ans,nums[i]),nums[i]);
            }
        }
        return ans.size();
    }

    public int bs(ArrayList<Integer> ans,int a){
        int l =0;
        int r = ans.size()-1;
        while(l<=r){
            int m = l +(r-l)/2;
            if(ans.get(m) == a) return m;
            if(ans.get(m)>a){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}