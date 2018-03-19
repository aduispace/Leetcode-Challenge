/*
Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
*/

class TicTacToe {
    public int[] rows;
    public int[] cols;
    public int diagonal;
    public int antiDiagonal;
    public int size;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // x(1) is +1, o(2) is -1
        int add = player == 1? 1 : -1; // add 1 or add -1
        rows[row] += add;
        cols[col] += add;
        
        if (row == col) {
            diagonal += add;
        } 
        // 注意不能用else if因为对于[1,1]位置，主对角和反对角都要 +add
        if (row == size - 1 - col) {
            antiDiagonal += add;
        }
        
        for (int i = 0; i < size; i++) {
            if (rows[i] == size || rows[i] == -size || cols[i] == size || cols[i] == -size || diagonal == size || diagonal == -size || antiDiagonal == size || antiDiagonal == -size) {
                return player;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
