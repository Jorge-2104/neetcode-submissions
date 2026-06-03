class Solution {
    public static boolean checkRows(char[][] board) {
        
        for (int r = 0; r < 9; r++) {
            HashSet<Character> set = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];

                if (set.contains(current)) {
                    return false;
                }

                if (current != '.') {
                    set.add(current);
                }
            }
        }

        return true;
    }


    public static boolean checkCols(char[][] board) {
        
        for (int c = 0; c < 9; c++) {
            HashSet<Character> set = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                char current = board[r][c];

                if (set.contains(current)) {
                    return false;
                }

                if (current != '.') {
                    set.add(current);
                }
            }
        }

        return true;
    }

    public static boolean checkGrids(char[][] board) {
        for (int r = 0; r < 9; r+=3) {
            for (int c = 0; c < 9; c+=3) {

                HashSet<Character> set = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        
                        char current = board[r+i][c+j];

                        if (set.contains(current)) {
                            return false;
                        }

                        if (current != '.') {
                            set.add(current);
                        }

                    }
                }


            }
        }

        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        System.out.println(checkRows(board));
        System.out.println(checkCols(board));
        System.out.println(checkGrids(board));
        return checkRows(board) && checkCols(board) && checkGrids(board);
    }
}
