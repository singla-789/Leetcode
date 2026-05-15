class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;

        int[] pre = new int[n];

        pre[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {

            int left = (i == 0) ? 0 : pre[i - 1];
            int right = pre[n - 1] - pre[i];

            if (left == right) {
                return i;
            }
        }

        return -1;
    }
}