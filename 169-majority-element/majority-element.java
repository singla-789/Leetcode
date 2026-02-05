class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int maj = 0;

        for(int i : nums){
            if(maj == 0){
                res = i;
            }

            maj += i == res ? 1 : -1; 
        }

        return res;
    }
}