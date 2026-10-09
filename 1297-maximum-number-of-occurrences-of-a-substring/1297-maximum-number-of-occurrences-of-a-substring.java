
import java.util.*;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;

        for (int i = 0; i <= n - minSize; i++) {
            String sub = s.substring(i, i + minSize);

            HashSet<Character> set = new HashSet<>();
            for (char ch : sub.toCharArray()) {
                set.add(ch);
            }

            if (set.size() <= maxLetters) {
                int freq = map.getOrDefault(sub, 0) + 1;
                map.put(sub, freq);
                ans = Math.max(ans, freq);
            }
        }

        return ans;
    }
}
