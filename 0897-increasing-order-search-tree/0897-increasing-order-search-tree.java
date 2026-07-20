class Solution {

    TreeNode dummy = new TreeNode(-1);
    TreeNode current = dummy;

    public TreeNode increasingBST(TreeNode root) {

        inorder(root);

        return dummy.right;
    }

    private void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);

        root.left = null;

        current.right = root;

        current = root;

        inorder(root.right);
    }
}