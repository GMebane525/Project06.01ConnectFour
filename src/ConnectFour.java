/**
 * ConnectFour creates the board, places pieces, checks for 'wins', and returns the winning players and the positions of the winning chips
 * @author 24mebane and 24jayashankar
 * @version 5/16/23
 */
public class ConnectFour implements BoardGame{
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPosition;
    /**
     * constructor for class ConnectFour
     */
    public ConnectFour() {
        newGame();
    }
    /**
     * Creates the board for the connect four game, sets the current player, and creates an array (size 4) of winning positions.
     */
    @Override
    public void newGame() {
        board = new int[6][7];
        currentPlayer = 1 + (int)(Math.random()*2);
        winningPosition = new Position[4];
    }
    /**
     * returns an int value which signifies the current player
     * @return int current player which has a value of 1 or 2
     */
    public int getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * Checks for if there are currently any winning sequences (i.e, four chips of the same color in a sequence)
     * @return true if there are four winning positions in any kind of sequence (row, column, diagonal) and false if none are found
     */
    @Override
    public boolean gameOver() {
      return rows() ? true : column() ? true : leftAcross()? true: rightAcross();
    }
    private boolean rows(){
        int win = 0;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                win = 0;
                int x = board[r][c];
                if(x == 1 || x == 2){
                    for(int col = c; col < board[0].length; col++){
                            if (board[r][col] == x) {
                                win++;
                                if (win == 4) {
                                    winningPosition[3] = new Position(r, col);
                                    winningPosition[2] = new Position(r, col-1);
                                    winningPosition[1] = new Position(r, col-2);
                                    winningPosition[0] = new Position(r, col-3);
                                    return true;
                                }
                            }
                            else {
                                win = 0;
                            }
                        }
                        }
                    }
                }
        return false;
            }
    private boolean column(){
        int win = 0;
        for(int c = 0; c < board[0].length; c++){
            for(int r = 0; r < board.length; r++){
                win = 0;
                int x = board[r][c];
                if(x == 1 || x == 2){
                    for(int row = r; row < board.length; row++){
                            if (board[row][c] == x){
                                win++;
                                if (win == 4) {
                                    winningPosition[3] = new Position(row, c);
                                    winningPosition[2] = new Position(row-1, c);
                                    winningPosition[1] = new Position(row-2, c);
                                    winningPosition[0] = new Position(row-3, c);
                                    return true;
                                 }
                            }
                            else {
                                win = 0;
                            }
                        }
                    }
            }
        }
        return false;
    }

    private boolean leftAcross(){
        int win = 0;
        int other = 0;
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 4; c++){
                int x = board[r][c];
                other = r+1;
                int col = c+1;
                win = 0;
                if(x == 1 || x == 2) {
                    for(int z =0; z<3; z++){
                        if (board[other][col] == x){
                            win++;
                            if(win==3){
                                winningPosition[3] = new Position(other, col);
                                winningPosition[2] = new Position(other-1, col-1);
                                winningPosition[1] = new Position(other-2, col-2);
                                winningPosition[0] = new Position(other-3, col-3);
                                return true;
                            }
                        }
                        else{
                            win = 0;
                        }
                        other++;
                        col++;
                    }
                }
            }
        }
        return false;
    }
    private boolean rightAcross(){
        int win = 0;
        int other = 0;
        for(int r = 0; r < 3; r++){
            for(int c = 6; c > 2; c--){
                int x = board[r][c];
                other = r+1;
                int col = c-1;
                win = 0;
                if(x == 1 || x == 2) {
                    for(int z = 0; z <3; z++){
                        if (board[other][col] == x){
                            win++;
                            if(win==3){
                                winningPosition[3] = new Position(other, col);
                                winningPosition[2] = new Position(other-1, col+1);
                                winningPosition[1] = new Position(other-2, col+2);
                                winningPosition[0] = new Position(other-3, col+3);
                                return true;
                            }
                        }
                        else{
                            win = 0;
                        }
                        other++;
                        col--;
                    }
                }
            }
        }
        return false;
    }




    /**
     * returns what player won the game based on the first index of the winning Position Array
     * @return the int value (1 or 2) that signifies the winning player
     */
    @Override
    public int getWinner() {
        return board[winningPosition[0].getRow()] [winningPosition[0].getCol()];
    }
    /**
     * returns the positions of the winning players chips from the array winningPosition
     * @return array of winning positions
     */
    @Override
    public Position[] getWinningPositions() {
        return winningPosition;
    }
    /**
     * checks if a column is full by seeing if the 'top' position on the board is filled
     * @return true if is the column is full (!=0) and false if the column is not full (==0)
     */
    @Override
    public boolean columnFull(int column) {

        return board[0][column] != 0;
    }
    /**
     * places the game pieces in their specified positions on the board
     * @param column is an int value that signifies a specific column on the board
     */
    @Override
    public void play(int column) {
        if(!columnFull(column)) {
            // go to bottom row, work up to find open spot
            for(int r = 5; r >= 0; r--) {
                System.out.println("HELLO " + r);
                if(board[r][column]==0) {
                    board[r][column] = currentPlayer; // place a piece
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    return;
                }
            }
        }
    }
    /**
     * Returns the game board
     * @return a 2-D array which signifies the game board
     */
    @Override
    public int[][] getBoard() {
        return board;
    }
}
