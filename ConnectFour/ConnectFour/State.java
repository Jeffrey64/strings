package ConnectFour;

/**
 * ConnectFour state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;

    public int getGameState() {
        return this.gameState;
    }
    
    public void setGameState (int gameState) {
        this.gameState = gameState;
    }

    private int whoseMove = Constants.X;

    public int getWhoseMove() {
        return this.whoseMove;
    }
    
    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    private String xName = "";

    public String getXName() {
        return this.xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    private String oName = "";

    public String getOName() {
        return this.oName;
    }
    
    public void setOName(String oName) {
        this.oName = oName;
    }

    private int[][] board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
    
    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }
    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }
    
    public boolean isWinner() {
        int total; 
        for (int row=0; row<Constants.BOARD_SIZE; row++) {
            total = getBoardCell(row, 0) + getBoardCell(row,1) + getBoardCell(row,2);
            if (total == -4 || total == 4) return true;
        }
        for (int col=0; col<Constants.BOARD_SIZE; col++) {
            total = getBoardCell(0, col) + getBoardCell(1,col) + getBoardCell(2, col);
            if (total == -4 || total == 4) return true;
        }
        total = getBoardCell(0, 0) + getBoardCell(1,1) + getBoardCell(2, 2);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(2, 0) + getBoardCell(1,1) + getBoardCell(0, 2);
        if (total == -4 || total == 4) return true;
        return false;
    }

    public boolean isTie() {
        for (int row = 0; row<Constants.BOARD_SIZE; row++) {
            for (int col=0; col<Constants.BOARD_SIZE; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }
}

