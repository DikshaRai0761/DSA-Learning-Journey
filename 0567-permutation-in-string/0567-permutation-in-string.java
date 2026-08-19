class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // s1 ki frequency
        for (char ch : s1.toCharArray()) {
            count1[ch - 'a']++;
        }

        int k = s1.length();

        // First window
        for (int i = 0; i < k; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(count1, count2))
            return true;

        // Sliding window
        for (int i = k; i < s2.length(); i++) {

            // New character add
            count2[s2.charAt(i) - 'a']++;

            // Old character remove
            count2[s2.charAt(i - k) - 'a']--;

            if (Arrays.equals(count1, count2))
                return true;
        }

        return false;
    }
}