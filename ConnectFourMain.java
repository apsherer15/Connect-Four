/* Name: Adam and Jace
 * Date: 10/12/2022
 * Description: This is the main class for the Connect Four game. This will contain the other two classes and connect them together to display the game.
 */
import java.util.Scanner;

public class ConnectFourMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner oScan = new Scanner(System.in);
		GamePlay oBoard = new GamePlay();
		
		boolean bPlay;
		int iTeam;
		int iPlayer;
		int iP1Wins = 0;
		int iP2Wins = 0;
		
		System.out.println("Welcome to Connect Four!");
		System.out.println("The rules of the game are simple:");
		System.out.println("Two players take turns placing pieces in a game board. A player wins when they get four pieces in a row (horizontally, vertically, diagonally)");
		System.out.println("If the game board is filled before the game is over, then the game is ruled a draw and must be replayed to determine a winner");
		System.out.println("In order to place your piece, you must enter the number that corresponds with the column you want to choose");
		System.out.println();
		System.out.println("How many games do you want to play: (Best of) 1, 3, 5, 7?");
		int numGames = oScan.nextInt();
		System.out.println("Good luck! And may the best player win!");
		
		for(int i=0; i<numGames; i++) {
			iTeam = 0;
			iPlayer = 0;
			bPlay = true;
			System.out.println("Game " + (i+1) + ":");
			System.out.println(oBoard.toString());
			while(bPlay) {

				iPlayer = iTeam%2;
				switch(iPlayer) {
				case 0:
					System.out.println("Player 1 it is your turn. Which column would you like to place a piece in (1-6)? ");
					break;
				case 1:
					System.out.println("Player 2 it is your turn. Which column would you like to place a piece in (1-6)? ");
					break;
				}
				int iColChoice = oScan.nextInt() - 1;
				bPlay = !oBoard.PlaceChip(iColChoice, iPlayer);
				System.out.println(oBoard.toString());
				iTeam+=1;
				
				if(bPlay == true && oBoard.CheckDraw(oBoard.getBoard())) {
					System.out.println("This game is a tie! Play again to determine who the winner is!");
					iTeam = 0;
					iPlayer = 0;
					oBoard.resetBoard();
					System.out.println("Game " + (i+1) + ":");
					System.out.println(oBoard.toString());
				}
			}

			if(iPlayer == 0) {
				iP1Wins += 1;
			}
			else {
				iP2Wins += 1;
			}
			if(iP1Wins == (numGames/2 + 1) || iP2Wins == (numGames/2 + 1)) {
				break;
			}
			else {
				oBoard.resetBoard();
			}
			if(numGames == 1) {
				break;
			}
			else{
				System.out.println("Congratulations Player " + (iPlayer+1) + "! You won that game!");
			}
		}
		if(iP1Wins == (numGames/2 + 1)) {
			System.out.println("Congratulations Player 1! You have won the best of " + numGames + "!");
			System.out.println("Thanks for playing!");
		}
		else {
			System.out.println("Congratulations Player 2! You have won the best of " + numGames + "!");
			System.out.println("Thanks for playing!");
		}
	}

}
