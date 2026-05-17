class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int i =0;

        for(int j =0;j<n;j++){
            if(nums[j]==0)count++;
            else{
                nums[i] = nums[j];
                i++;
            }
        }

        while(count>0){
            nums[n-count] = 0;
            count--;
        }
        
    }
}