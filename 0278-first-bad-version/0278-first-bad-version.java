public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                // mid bad hai
                // first bad mid ya usse pehle ho sakta hai
                high = mid;
            } else {
                // mid good hai
                // first bad mid ke baad hoga
                low = mid + 1;
            }
        }

        return low;
    }
}