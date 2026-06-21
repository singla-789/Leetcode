class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100001];

        for (int cost : costs) {
            freq[cost]++;
        }

        int ans = 0;

        for (int cost = 1; cost <= 100000; cost++) {
            while (freq[cost] > 0 && coins >= cost) {
                coins -= cost;
                freq[cost]--;
                ans++;
            }
        }

        return ans;
    }
}