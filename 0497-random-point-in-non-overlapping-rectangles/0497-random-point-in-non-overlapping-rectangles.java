import java.util.*;

class Solution {

    int[][] rects;
    int[] prefix;
    int totalPoints;
    Random random;

    public Solution(int[][] rects) {

        this.rects = rects;
        random = new Random();

        prefix = new int[rects.length];

        int sum = 0;

        for (int i = 0; i < rects.length; i++) {

            int x1 = rects[i][0];
            int y1 = rects[i][1];
            int x2 = rects[i][2];
            int y2 = rects[i][3];

            sum += (x2 - x1 + 1) * (y2 - y1 + 1);

            prefix[i] = sum;
        }

        totalPoints = sum;
    }

    public int[] pick() {

        int k = random.nextInt(totalPoints);

        int index = binarySearch(k);

        int[] rect = rects[index];

        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }

    private int binarySearch(int target) {

        int low = 0;
        int high = prefix.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (target < prefix[mid])
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}