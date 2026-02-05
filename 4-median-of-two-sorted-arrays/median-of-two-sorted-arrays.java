class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int l = 0, r = n;

        while (l <= r) {
            int m1 = l + (r - l) / 2;
            int m2 = (n + m + 1) / 2 - m1;

            int leftX  = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1 - 1];
            int rightX = (m1 == n) ? Integer.MAX_VALUE : nums1[m1];

            int leftY  = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2 - 1];
            int rightY = (m2 == m) ? Integer.MAX_VALUE : nums2[m2];

            if (leftX <= rightY && leftY <= rightX) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                } else {
                    return Math.max(leftX, leftY);
                }
            }
            else if (leftX > rightY) {
                r = m1 - 1;
            }
            else {
                l = m1 + 1;
            }
        }
        return 0.0;
    }
}
