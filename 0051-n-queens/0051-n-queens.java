class Solution {

    public boolean isSafe(char[][] board, int x, int y) {

        int row, col;

        
        row = x - 1;
        col = y;

        while (row >= 0) {
            if (board[row][col] == 'Q')
                return false;

            row--;
        }

        
        row = x - 1;
        col = y - 1;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;

            row--;
            col--;
        }

        
        row = x - 1;
        col = y + 1;

        while (row >= 0 && col < board.length) {
            if (board[row][col] == 'Q')
                return false;

            row--;
            col++;
        }

        return true;
    }

    public void solve(char[][] board, int row, List<List<String>> ans) {

        
        if (row == board.length) {

            List<String> list = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }

            ans.add(list);
            return;
        }

        
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

            
                board[row][col] = 'Q';

                
                solve(board, row + 1, ans);

                
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

    
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, ans);

        return ans;
    }
}