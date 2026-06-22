class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        // Total elements needed on left side
        int left = (n1 + n2 + 1) / 2;

        // Total size
        int total = n1 + n2;

        while (low <= high) {

            // Partition for nums1
            int mid1 = (low + high) / 2;

            // Partition for nums2
            int mid2 = left - mid1;

            // Default values for boundaries
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            // Check right side of nums1
            if (mid1 < n1) {
                r1 = nums1[mid1];
            }

            // Check right side of nums2
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }

            // Check left side of nums1
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }

            // Check left side of nums2
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {

                // Odd total elements
                if (total % 2 == 1) {
                    return Math.max(l1, l2);
                }

                // Even total elements
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            // Move left
            else if (l1 > r2) {
                high = mid1 - 1;
            }

            // Move right
            else {
                low = mid1 + 1;
            }
        }

        return 0.0; 
    }
}