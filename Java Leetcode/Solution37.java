// 37. Sudoku Solver 

class Solution37 {

    // Битовые маски для отслеживания использованных чисел
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] boxes = new int[9];

    public void solveSudoku(char[][] board) {
        // Инициализация битовых масок
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    int mask = 1 << num;
                    rows[i] |= mask;
                    cols[j] |= mask;
                    boxes[boxIndex] |= mask;
                }
            }
        }
        solve(board, 0);
    }

    private boolean solve(char[][] board, int pos) {
        if (pos == 81) {
            return true;
        }

        int row = pos / 9;
        int col = pos % 9;

        if (board[row][col] != '.') {
            return solve(board, pos + 1);
        }

        int boxIndex = (row / 3) * 3 + col / 3;
        int constraints = rows[row] | cols[col] | boxes[boxIndex];

        // Оптимизация: проверяем только доступные числа
        for (int num = 0; num < 9; num++) {
            int mask = 1 << num;
            if ((constraints & mask) == 0) {
                board[row][col] = (char) ('1' + num);
                rows[row] |= mask;
                cols[col] |= mask;
                boxes[boxIndex] |= mask;

                if (solve(board, pos + 1)) {
                    return true;
                }

                rows[row] &= ~mask;
                cols[col] &= ~mask;
                boxes[boxIndex] &= ~mask;
                board[row][col] = '.';
            }
        }

        return false;
    }
}
