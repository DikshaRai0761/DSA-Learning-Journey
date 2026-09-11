class Solution {

    public void solve(String ip, String op, int indx, List<String> ans) {
        if (indx == ip.length()) {
            ans.add(op);
            return;
     }

        char ch = ip.charAt(indx);

        if (Character.isLetter(ch)) {
            solve(ip, op + Character.toLowerCase(ch), indx + 1, ans);
            solve(ip, op + Character.toUpperCase(ch), indx + 1, ans);
 } 
        else {
            solve(ip, op + ch, indx + 1, ans);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        solve(s,"", 0, ans);

        return ans;
    }
}