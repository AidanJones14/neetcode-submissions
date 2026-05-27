class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            var rowMap = new HashSet<Character>();
            for(int j = 0; j < 9; j++) {
                char value = board[i][j];
                if(value == '.') continue;
                if(rowMap.contains(value)) {
                    return false;
                } else {
                    rowMap.add(value);
                }
            }
            var colMap = new HashSet<Character>();
            for(int k = 0; k < 9; k++) {
                char value = board[k][i];
                if(value == '.') continue;
                if(colMap.contains(value)) {
                    return false;
                } else {
                    colMap.add(value);
                }
            }
            var boxMap = new HashSet<Character>();
            for(int l = 0; l < 9; l++) {
                char value = board[3 * (i / 3) + l / 3][3 * (i % 3) + l % 3];
                if(value == '.') continue;
                if(boxMap.contains(value)) {
                    return false;
                } else {
                    boxMap.add(value);
                }
            }
        }
        return true;
    }
}
