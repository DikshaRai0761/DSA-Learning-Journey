class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        // Dono null hain
        if (left == null && right == null) {
            return true;
        }

        // Ek null hai
        if (left == null || right == null) {
            return false;
        }

        // Value different hai
        if (left.val != right.val) {
            return false;
        }

        // Mirror compare
        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}