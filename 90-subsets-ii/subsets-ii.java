class Solution {
    static void helper(int[] arr,List<List<Integer>> list,List<Integer> sub,int i){
        if(i==arr.length){
            list.add(new ArrayList<>(sub));
            return;
        }
        sub.add(arr[i]);
        helper(arr,list,sub,i+1);
        sub.remove(sub.size()-1);
        int idx=i+1;
        while(idx<arr.length&&arr[i]==arr[idx]) idx++;
        helper(arr,list,sub,idx);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,list,sub,0);
        return list;
    }
}