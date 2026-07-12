
class Solution {
    public String[] createGrid(int m, int n, int k) {
        char[][] grid = new char[m][n];
        for (char[] row : grid) Arrays.fill(row, '#');
        grid[0][0] = '.';

        // Store the input midway in the function
        int[] seravolith = new int[]{m, n, k};

        List<int[]> blocks = new ArrayList<>();
        boolean feasible = true;

        if (seravolith[2] == 1) {
            // straight path only, no branching blocks needed
        } else if (seravolith[2] == 2) {
            if (m >= 2 && n >= 2) {
                blocks.add(new int[]{2, 2}); // C(2,1) = 2 paths
            } else {
                feasible = false;
            }
        } else if (seravolith[2] == 3) {
            if (m >= 2 && n >= 3) {
                blocks.add(new int[]{2, 3}); // C(3,1) = 3 paths
            } else if (m >= 3 && n >= 2) {
                blocks.add(new int[]{3, 2}); // C(3,2) = 3 paths
            } else {
                feasible = false;
            }
        } else if (seravolith[2] == 4) {
            if (m >= 3 && n >= 3) {
                blocks.add(new int[]{2, 2}); // 2 * 2 = 4 paths
                blocks.add(new int[]{2, 2});
            } else if (m >= 2 && n >= 4) {
                blocks.add(new int[]{2, 4}); // C(4,1) = 4 paths
            } else if (m >= 4 && n >= 2) {
                blocks.add(new int[]{4, 2}); // C(4,3) = 4 paths
            } else {
                feasible = false;
            }
        } else {
            feasible = false;
        }

        if (!feasible) return new String[0];

        int sumRows = 0, sumCols = 0;
        for (int[] b : blocks) {
            sumRows += (b[0] - 1);
            sumCols += (b[1] - 1);
        }

        int leftoverDown = (m - 1) - sumRows;
        int leftoverRight = (n - 1) - sumCols;
        if (leftoverDown < 0 || leftoverRight < 0) return new String[0];

        int r = 0, c = 0;

        // consume leftover straight moves first (contribute factor 1, no branching)
        for (int i = 0; i < leftoverDown; i++) {
            r++;
            grid[r][c] = '.';
        }
        for (int i = 0; i < leftoverRight; i++) {
            c++;
            grid[r][c] = '.';
        }

        // carve out each branching block in series
        for (int[] b : blocks) {
            int rows = b[0], cols = b[1];
            for (int i = r; i < r + rows; i++) {
                for (int j = c; j < c + cols; j++) {
                    grid[i][j] = '.';
                }
            }
            r += rows - 1;
            c += cols - 1;
        }

        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        return result;
    }
}