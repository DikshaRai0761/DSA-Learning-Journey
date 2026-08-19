class Solution {
    public int maxVowels(String s, int k) {

        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int max = count;

        // Sliding window
        for (int i = k; i < s.length(); i++) {

            // New character add
            if (isVowel(s.charAt(i))) {
                count++;
            }

            // Old character remove
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }
}