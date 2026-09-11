class Solution {
    public void solve(int n, String op, List<String> ans) {

        if (op.length() == n) {
            ans.add(op);
            return;
        }

        solve(n, op + "1", ans);

        if (op.length() == 0 || op.charAt(op.length() - 1) == '1') {
            solve(n, op + "0", ans);
        }
    }

    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, "", ans);
        return ans;
    }
}