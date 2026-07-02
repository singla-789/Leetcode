class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        help(ans,new ArrayList<>(),nums,0);
        return ans;
    }

    public void help(List<List<Integer>> arr,List<Integer> temp,int[] nums,int k){
        int n = nums.length;
        arr.add(new ArrayList<>(temp));
        
        for(int i =k;i<n;i++){
            temp.add(nums[i]);
            help(arr,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}