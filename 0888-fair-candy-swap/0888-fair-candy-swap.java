import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0, sumB = 0;

        for (int x : aliceSizes) {
            sumA += x;
        }

        for (int y : bobSizes) {
            sumB += y;
        }

        int diff = (sumB - sumA) / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int y : bobSizes) {
            set.add(y);
        }

        for (int x : aliceSizes) {
            if (set.contains(x + diff)) {
                return new int[]{x, x + diff};
            }
        }

        return new int[0];
    }
}