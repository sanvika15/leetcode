
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        placeQueens(n, 0, board, result);
        return result;
    }

    private void placeQueens(int n, int row, char[][] board, List<List<String>> result) {
        if (row == n) {
            result.add(convertBoardToString(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                placeQueens(n, row + 1, board, result);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int k;
        for (k = 1; k <= row; k++) {
            if (board[row - k][col] == 'Q' || (col - k >= 0 && board[row - k][col - k] == 'Q') || (col + k < board.length && board[row - k][col + k] == 'Q')) {
                return false;
            }
        }
        return true;
    }

    private List<String> convertBoardToString(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}