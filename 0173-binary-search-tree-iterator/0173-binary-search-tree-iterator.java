class BSTIterator {

    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode curr = st.pop();

        // curr ke right subtree ko process karo
        pushLeft(curr.right);

        return curr.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}