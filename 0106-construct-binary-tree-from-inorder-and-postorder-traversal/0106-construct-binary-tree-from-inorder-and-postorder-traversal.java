class Solution {
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {

        if (start > end) {
            return null;
        }

        // Postorder ka last element = root
        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Inorder me root find karo
        int index = start;

        while (inorder[index] != rootValue) {
            index++;
        }

        // IMPORTANT:
        // Postorder se hum right subtree pehle banayenge
        root.right = build(inorder, postorder, index + 1, end);

        root.left = build(inorder, postorder, start, index - 1);

        return root;
    }
}