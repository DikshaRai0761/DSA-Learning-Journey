class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        dfs(root);

        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        List<Integer> ans = new ArrayList<>();

        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                ans.add(key);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        dfs(root.left);
        dfs(root.right);
    }
}