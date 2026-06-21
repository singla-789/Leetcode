class Solution {
    public int maxIceCream(int[] costs, int coins) {
        costs = countSort(costs);
        int ans = 0;
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            if (costs[i] <= coins) {
                ans++;
                coins -= costs[i];
            } else {
                break;
            }
        }

        return ans;
    }

    public int[] countSort(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            max = Math.max(a, max);
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <=max; i++) {
            count[i] += count[i - 1];
        }

        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int a = arr[i];
            ans[count[a] - 1] = a;

            count[a]--;

        }

        return ans;

    }
}