class Solution {
    public int lengthLongestPath(String input) {

        String[] parts = input.split("\n");

        // stack[level] = us level tak ka total path length
        int[] stack = new int[parts.length + 1];

        int ans = 0;

        for (String s : parts) {

            // level find karo
            int level = 0;

            while (level < s.length() && s.charAt(level) == '\t') {
                level++;
            }

            // \t remove karke actual name
            String name = s.substring(level);

            // current path length
            stack[level + 1] = stack[level] + name.length();

            // Agar file hai
            if (name.contains(".")) {
                ans = Math.max(ans, stack[level + 1] + level);
            }
        }

        return ans;
    }
}