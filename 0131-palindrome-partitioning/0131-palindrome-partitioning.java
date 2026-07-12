class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        helper(0, s, path, ans);

        return ans;
    }

    public void helper(int index, String s, List<String> path, List<List<String>> ans) {

    
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        
        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {

                path.add(s.substring(index, i + 1));

                helper(i + 1, s, path, ans);

                
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}