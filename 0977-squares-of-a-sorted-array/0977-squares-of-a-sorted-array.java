import java.util.*;

class Solution {
    public int[] sortedSquares(int[] nums) {

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // Separate negative and positive numbers
        for (int num : nums) {
            if (num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        // Square negative numbers
        for (int i = 0; i < neg.size(); i++) {
            neg.set(i, neg.get(i) * neg.get(i));
        }

        // Reverse because negative squares are in decreasing order
        Collections.reverse(neg);

        // Square positive numbers
        for (int i = 0; i < pos.size(); i++) {
            pos.set(i, pos.get(i) * pos.get(i));
        }

        int n1 = neg.size();
        int n2 = pos.size();

        int[] res = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int id = 0;

        // Merge neg and pos
        while (i < n1 && j < n2) {

            if (neg.get(i) <= pos.get(j)) {
                res[id++] = neg.get(i++);
            } else {
                res[id++] = pos.get(j++);
            }
        }

        // Remaining negative elements
        while (i < n1) {
            res[id++] = neg.get(i++);
        }

        // Remaining positive elements
        while (j < n2) {
            res[id++] = pos.get(j++);
        }

        return res;
    }
}