class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // Store each word with its index
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 1: Left part is palindrome
                if (isPalindrome(left)) {
                    String revRight = new StringBuilder(right).reverse().toString();
                    Integer idx = map.get(revRight);

                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(idx, i));
                    }
                }

                // Case 2: Right part is palindrome
                // j != word.length() avoids duplicates
                if (j != word.length() && isPalindrome(right)) {
                    String revLeft = new StringBuilder(left).reverse().toString();
                    Integer idx = map.get(revLeft);

                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(i, idx));
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}