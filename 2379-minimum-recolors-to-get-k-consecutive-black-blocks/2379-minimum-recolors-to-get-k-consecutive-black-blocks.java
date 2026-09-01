class Solution {
    public int minimumRecolors(String blocks, int k) {

        int white = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < blocks.length(); i++) {

            // current block ko window me add karo
            if (blocks.charAt(i) == 'W') {
                white++;
            }

            // jab window size k ho jaye
            if (i >= k - 1) {

                min = Math.min(min, white);

                // window se left wala element remove karo
                if (blocks.charAt(i - k + 1) == 'W') {
                    white--;
                }
            }
        }

        return min;
    }
}