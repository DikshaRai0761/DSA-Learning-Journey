class Solution {
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }

    public List<TreeNode> solve(int start, int end) {

        List<TreeNode> ans = new ArrayList<>();

        // No value available
        if (start > end) {
            ans.add(null);
            return ans;
        }

        // Try every value as root
        for (int i = start; i <= end; i++) {

            // Generate all possible left subtrees
            List<TreeNode> leftTrees = solve(start, i - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightTrees = solve(i + 1, end);

            // Combine left and right
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;

                    ans.add(root);
                }
            }
        }

        return ans;
    }
}