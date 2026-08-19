class Solution {
    public String longestNiceSubstring(String s) {

        if (s.length() < 2) {
            return "";
        }

        boolean[] present = new boolean[128];

        for (char c : s.toCharArray()) {
            present[c] = true;
        }

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Uppercase/lowercase pair missing hai
            if (!present[Character.toLowerCase(c)] ||
                !present[Character.toUpperCase(c)]) {

                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));

                return left.length() >= right.length() ? left : right;
            }
        }

        // Puri string nice hai
        return s;
    }
}