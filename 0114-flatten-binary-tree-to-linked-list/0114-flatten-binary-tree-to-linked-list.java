class Solution {
    public void flatten(TreeNode root) {
        
        TreeNode curr = root;

        while (curr != null) {
            
            if (curr.left != null) {
                
                // Find the rightmost node of left subtree
                TreeNode prev = curr.left;

                while (prev.right != null) {
                    prev = prev.right;
                }

                // Connect right subtree after the rightmost node
                prev.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;
                curr.left = null;
            }

            // Move to next node
            curr = curr.right;
        }
    }
}