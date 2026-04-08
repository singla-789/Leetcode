class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int M = (int)1e9 + 7;
        long[] mul = new long[n];
        Arrays.fill(mul, 1);

        for (int[] q : queries) {
            int l = q[0], r = q[1], step = q[2], val = q[3];

            for (int i = l; i <= r; i += step) {
                mul[i] = (mul[i] * val) % M;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            long finalVal = (nums[i] * mul[i]) % M;
            ans ^= (int) finalVal;
        }

        return ans;
    }
}