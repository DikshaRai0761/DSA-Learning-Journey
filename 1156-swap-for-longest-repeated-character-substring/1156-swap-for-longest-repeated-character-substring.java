class Solution {
    public int maxRepOpt1(String text) {
        
        int[] freq = new int[26];

        // Total frequency of every character
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        int ans = 0;

        for (int ch = 0; ch < 26; ch++) {

            int left = 0;
            int count = 0;

            for (int right = 0; right < text.length(); right++) {

                if (text.charAt(right) - 'a' == ch) {
                    count++;
                }

                // At most one different character
                while (right - left + 1 - count > 1) {
                    if (text.charAt(left) - 'a' == ch) {
                        count--;
                    }
                    left++;
                }

                // We cannot exceed total frequency of this character
                int len = Math.min(right - left + 1, freq[ch]);

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}