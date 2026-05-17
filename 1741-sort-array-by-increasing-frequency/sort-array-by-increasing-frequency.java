class Solution {
    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Convert to Integer[] for custom sorting
        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // Custom sort
        Arrays.sort(arr, (a, b) -> {

            int fa = freq.get(a);
            int fb = freq.get(b);

            // Increasing frequency
            if (fa != fb) {
                return fa - fb;
            }

            // Same frequency -> decreasing value
            return b - a;
        });

        // Convert back to int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}