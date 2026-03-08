class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        boolean[] res = new boolean[1 << n];  

        for (String a : nums) {
            int curr = Integer.parseInt(a, 2);
            res[curr] = true;
        }

        String ans = "";

        for (int i = 0; i < res.length; i++) {
            if (!res[i]) {
                ans = Integer.toBinaryString(i);
                break;
            }
        }

        while (ans.length() < n) {
            ans = "0" + ans;
        }

        return ans;
    }
}