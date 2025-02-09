package matrix;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    private static final Set<Character> CHARACTERS = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();

            for (int j = 0; j < board[i].length; j++) {
                char ch1 = board[i][j];
                char ch2 = board[j][i];

                if (ch1 != '.') {
                    if (!CHARACTERS.contains(ch1)) return false;
                    if (set1.contains(ch1)) return false;
                    set1.add(ch1);
                }
                if (ch2 != '.') {
                    if (!CHARACTERS.contains(ch2)) return false;
                    if (set2.contains(ch2)) return false;
                    set2.add(ch2);
                }
            }
        }

        for (int i = 0; i < 8; i += 3) {
            for (int j = 0; j < 8; j += 3) {
                if (!checkSubBox(i, i + 2, j, j + 2, board)) return false;
            }
        }
        return true;
    }

    private static boolean checkSubBox(int row1, int row2, int column1, int column2, char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                char ch = board[i][j];

                if (ch == '.') continue;
                if (!CHARACTERS.contains(ch)) return false;
                if (set.contains(ch)) return false;
                set.add(ch);
            }
        }
        return true;
    }
}



























