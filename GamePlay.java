/* Name: Adam and Jace
 * Date: 10/12/2022
 * Description: This is the class that will contain all of the game play methods
 */

public class GamePlay extends GameBoard{
	
	
	public boolean CheckWin(int column, String[][] aBoard) {
		boolean win = false;
		
		//This section will check to see if someone wins via a horizontal connect four
		for(int i=6;i>=0;i--) {
			for(int j=0;j<3;j++) {
				if(!aBoard[i][j].equals("*") && aBoard[i][j].equals(aBoard[i][j+1]) && aBoard[i][j].equals(aBoard[i][j+2]) && aBoard[i][j].equals(aBoard[i][j+3])) {
					win = true;
				}
			}
		}
		//This section will check to see if someone wins via a vertical connect four
		for(int i=3;i>=0;i--) {
				if(!aBoard[i][column].equals("*") && aBoard[i][column].equals(aBoard[i+1][column]) && aBoard[i][column].equals(aBoard[i+2][column]) && aBoard[i][column].equals(aBoard[i+3][column])) {
					win = true;
			}
		}
		//This section will check to see if someone wins via a diagonal connect four that looks like a backslash
		for(int i=3;i>=0;i--) {
			for(int j=0;j<=2;j++) {
				if(!aBoard[i][j].equals("*") && aBoard[i][j].equals(aBoard[i+1][j+1]) && aBoard[i][j].equals(aBoard[i+2][j+2]) && aBoard[i][j].equals(aBoard[i+3][j+3])) {
					win = true;
				}
			}
		}
		//This section will check to see if someone wins via a diagonal connect four that looks like a foreslash
		for(int i=6;i>=3;i--) {
			for(int j=0;j<=2;j++) {
				if(!aBoard[i][j].equals("*") && aBoard[i][j].equals(aBoard[i-1][j+1]) && aBoard[i][j].equals(aBoard[i-2][j+2]) && aBoard[i][j].equals(aBoard[i-3][j+3])) {
					win = true;
				}
			}
		}
		
		return win;
	}
	
	public boolean CheckDraw(String[][] aBoard) {
		boolean draw = false;
		if(!aBoard[0][0].equals("*") && !aBoard[0][1].equals("*") && !aBoard[0][2].equals("*") && !aBoard[0][3].equals("*") && !aBoard[0][4].equals("*") &&
				!aBoard[0][5].equals("*")) {
			draw = true;
		}
		return draw;
	}
	
	public boolean PlaceChip(int column, int player) {
		String[][] aBoard = super.getBoard();
		for(int i=6;i>=0;i--) {
			if(aBoard[i][column].equals("*")) {
				if(player == 0) {
					aBoard[i][column] = "X";
				}
				else {
					aBoard[i][column] = "O";
				}
				break;
			}
		}
		return(CheckWin(column, aBoard));
	}
}
