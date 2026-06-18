class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;

        if (total % 2 == 1)
            return kth(nums1, nums2, total / 2 + 1);

        return (kth(nums1, nums2, total / 2) +
                kth(nums1, nums2, total / 2 + 1)) / 2.0;
    }

    private int kth(int[] nums1, int[] nums2, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int x : nums1) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }

        for (int x : nums2) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int cnt = upperBound(nums1, mid) + upperBound(nums2, mid);

            if (cnt >= k)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}