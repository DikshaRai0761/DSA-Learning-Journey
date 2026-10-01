class NumArray {
    
    int[] nums;
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        
        tree = new int[4 * n];
        build(0, 0, n - 1);
    }

    // Segment Tree banana
    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node + 1, start, mid);
        build(2 * node + 2, mid + 1, end);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    public void update(int index, int val) {
        updateTree(0, 0, n - 1, index, val);
    }

    void updateTree(int node, int start, int end, int index, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            updateTree(2 * node + 1, start, mid, index, val);
        } else {
            updateTree(2 * node + 2, mid + 1, end, index, val);
        }

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    int query(int node, int start, int end, int left, int right) {
        
        // Completely outside
        if (right < start || end < left) {
            return 0;
        }

        // Completely inside
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        int leftSum = query(2 * node + 1, start, mid, left, right);
        int rightSum = query(2 * node + 2, mid + 1, end, left, right);

        return leftSum + rightSum;
    }
}