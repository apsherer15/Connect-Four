/*Name: Adam and Jace
 * Date: 10/12/2022
 * Description: This is the class that will contain the game board and all operations that are relevant to it.
 * This includes creating each spot for the chips, performing the row selection and stacking of chips, determining when the game is won. 
 */

public class GameBoard {
	GameChip oChip = new GameChip();
	private String[][] board = new String[7][6];
	
	public GameBoard() {
		resetBoard();
	}
	
	public void resetBoard() {
		for(int i=0; i<=6; i++){
			for(int j=0; j<=5; j++) {
				board[i][j] = oChip.getTeam();
			}
		}
	}
	
	public String[][] getBoard() {
		return board;
	}
	
	public String toString() {
		String printBoard = "1 ";
		for(int i=0; i<=6; i++) {
			for(int j=0; j<=5; j++) {
				printBoard += (" " + board[i][j] + " ");
			}
			if(i!=6) {
				printBoard += ("\n" + (i+2) + " ");
			}
		}
		printBoard += ("\n   1  2  3  4  5  6");
		return(printBoard);
	}
}
