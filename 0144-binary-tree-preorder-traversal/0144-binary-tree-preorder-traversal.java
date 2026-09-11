class Solution {
    public void solve(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        // Root
        ans.add(root.val);

        // Left
        solve(root.left, ans);

        // Right
        solve(root.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        solve(root, ans);

        return ans;
    }
}