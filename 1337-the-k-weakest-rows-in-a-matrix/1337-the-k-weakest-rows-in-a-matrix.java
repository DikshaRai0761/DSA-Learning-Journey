import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int[][] rows = new int[m][2];

        for (int i = 0; i < m; i++) {
            int soldiers = countSoldiers(mat[i]);
            rows[i][0] = soldiers;
            rows[i][1] = i;
        }

        Arrays.sort(rows, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = rows[i][1];
        }

        return ans;
    }

    private int countSoldiers(int[] row) {
        int low = 0, high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}