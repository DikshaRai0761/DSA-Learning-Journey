class Solution {
    public int maximumSum(int[] arr) {

        int n = arr.length;

        int nodelete = arr[0];
        int onedelete = 0;

        int ans = arr[0];

        for (int i = 1; i < n; i++) {

            int prevnodelete = nodelete;
            int prevonedelete = onedelete;

            nodelete = Math.max(arr[i], prevnodelete + arr[i]);

            onedelete = Math.max(prevnodelete,
                                 prevonedelete + arr[i]);

            ans = Math.max(ans, Math.max(nodelete, onedelete));
        }

        return ans;
    }
}