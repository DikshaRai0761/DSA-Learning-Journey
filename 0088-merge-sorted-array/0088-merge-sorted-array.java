class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m + n];

        int id = 0;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {
                res[id] = nums1[i];
                id++;
                i++;
            } else {
                res[id] = nums2[j];
                id++;
                j++;
            }
        }

        while (i < m) {
            res[id] = nums1[i];
            id++;
            i++;
        }

        while (j < n) {
            res[id] = nums2[j];
            id++;
            j++;
        }

        // res ko nums1 mein copy karo
        for (int k = 0; k < m + n; k++) {
            nums1[k] = res[k];
        }
    }
}