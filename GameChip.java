/* Name: Adam and Jace
 * Date: 10/12/2022
 * Description: This is the class that will contain the game chips and everything relevant to them. 
 * This will include the design of the chips and the identifiers pertaining to the two different players.
 */

public class GameChip {
	private String team;
	
	public GameChip() {
		this.setTeam("*");
	}
	
	public GameChip(String team) {
		setTeam(team);
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	public String toString() {
		switch(this.team){
		case "*":
			return("This space is empty.");
		case "X":
			return("This space has been claimed by player 1.");
		case "O":
			return("This space has been claimed by player 2.");
		}
		return("There was an error with getting the value for this space.");
	}
}
