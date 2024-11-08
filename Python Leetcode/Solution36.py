# 36. Valid Sudoku

from collections import defaultdict


class Solution36:
    def isValidSudoku(self, board):
        rows = defaultdict(set)
        cols = defaultdict(set)
        boxes = defaultdict(set)

        for r in range(9):
            for c in range(9):
                if board[r][c] == ".":
                    continue

                if board[r][c] in rows[r] or board[r][c] in cols[c] or board[r][c] in boxes[r // 3, c // 3]:
                    return False
                
                rows[r].add(board[r][c])
                cols[c].add(board[r][c])
                boxes[r // 3, c // 3].add(board[r][c])

        return True
    
"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_sector = defaultdict(set)
        col_sector = defaultdict(set)
        sub_sector = defaultdict(set)
        for row in range(9):
            for col in range(9):
                if board[row][col] == ".":
                    continue
                if any((
                    board[row][col] in row_sector[row],
                    board[row][col] in col_sector[col],
                    board[row][col] in sub_sector[(row // 3, col // 3)]
                )):
                    return False
                row_sector[row].add(board[row][col])
                col_sector[col].add(board[row][col])
                sub_sector[(row // 3, col // 3)].add(board[row][col])
        return True
"""
            