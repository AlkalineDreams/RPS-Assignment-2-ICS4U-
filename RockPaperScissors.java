/****************************************************************************
 *
 * Created by: Craig Dwyer, ICS4U
 * Created on: OCT 2016
 *
 ****************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RockPaperScissors {
	
public enum RPS {
		
		ROCK("rock"),
		PAPER("paper"),
		SCISSORS("scissors");
		
		private final String rps;

	    RPS(String rps) {
	        this.rps = rps;
	    }
	    
	    public String getRPS() {
	        return this.rps;
	    }
	    
		
	}

	public static void main(String[] args) throws IOException {
		
		//declaring variables
		String userInput;
		RPS userRPS = null;
		RPS computerRPS = null;
		
		//asks user for input
		System.out.println("Let's play rock, paper, scissors.");
		System.out.println("Please input either rock, paper, or scissors as plain text.");
		
		//initializes input stream
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		//sets user input as variable
		userInput = br.readLine();
		
		//checks to see if it's an enum and if it is, spits back the choice.
		//if it isn't, makes the user choose again.
		for (;userRPS == null;){
			try {
				
				userRPS = RPS.valueOf(userInput.toUpperCase());
				
			} catch(IllegalArgumentException e) {
				
				System.out.println("Invalid input. Please enter either rock, paper, or scissors as plain text.");
				userInput = br.readLine();
				
			}
			
		}

		//shows the user their decision
		System.out.println("You chose " + userRPS.rps + ".");
		
		//generates a random number from 1-3 and sticks it into "randomRoll"
		int randomRoll = (int)(Math.random()*3 + 1);
		
		//makes the computer choice of type enum RPS
		if(randomRoll == 1) {
			computerRPS = RPS.ROCK;
		}
		else if(randomRoll == 2) {
			computerRPS = RPS.PAPER;
		}
		else if(randomRoll == 3) {
			computerRPS = RPS.SCISSORS;
		}
		else {
			//error handler (just in case?)
			System.out.println("ERROR: Computer somehow didn't roll Rock, Paper, or Scissors.");
		}
		
		//prints out what the computer chose
		System.out.println("The computer chose " + computerRPS.rps + ".");
		
		//biig long elseif comparing the user's choice to the computer's and seeing who won.
		//i would have made this its own function had it been necessary, but this code is only used once.
		if(userRPS.equals(RPS.ROCK)) {
			
			if(computerRPS.equals(RPS.PAPER)) {
				System.out.println("The computer wins!");
			}
			else if(computerRPS.equals(RPS.SCISSORS)) {
				System.out.println("You win!");
			}
			else if(computerRPS.equals(RPS.ROCK)) {
				System.out.println("It's a tie!");
			}
			else {
				System.out.println("ERROR: Win comparison failed."); //again, just in case.
			}
			
		}
		else if (userRPS.equals(RPS.PAPER)) {
			
			if(computerRPS.equals(RPS.SCISSORS)) {
				System.out.println("The computer wins!");
			}
			else if(computerRPS.equals(RPS.ROCK)) {
				System.out.println("You win!");
			}
			else if(computerRPS.equals(RPS.PAPER)) {
				System.out.println("It's a tie!");
			}
			else {
				System.out.println("ERROR: Win comparison failed.");
			}
			
		}
		else if (userRPS.equals(RPS.SCISSORS)) {
			
			if(computerRPS.equals(RPS.ROCK)) {
				System.out.println("The computer wins!");
			}
			else if(computerRPS.equals(RPS.PAPER)) {
				System.out.println("You win!");
			}
			else if(computerRPS.equals(RPS.SCISSORS)) {
				System.out.println("It's a tie!");
			}
			else {
				System.out.println("ERROR: Win comparison failed.");
			}
			
		}

	}

}
