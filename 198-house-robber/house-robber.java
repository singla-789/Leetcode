class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();

    public int rob(int[] nums) {
        return util(nums, 0);
    }

    int util(int[] nums, int i) {
        int n = nums.length;
        if (i >= n) return 0;

        if (map.containsKey(i)) return map.get(i);

        
        int p1 = nums[i] + util(nums, i + 2);
       
        int p2 = util(nums, i + 1);

        int profit = Math.max(p1, p2);
        map.put(i, profit);
        return profit;
    }
}