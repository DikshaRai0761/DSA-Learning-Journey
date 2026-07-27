/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Serialize
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");

            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    // Deserialize
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            // Left Child
            if (!arr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;

            // Right Child
            if (i < arr.length && !arr[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}