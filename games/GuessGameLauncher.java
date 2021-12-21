
public class GuessGameLauncher {
	public class GuessGame {
		// Create 3 instance variables for Player objects
		Player p1;
		Player p2;
		Player p3;
		
		public void startGame() {
			p1 = new Player(); // Create Player objects
			p2 = new Player();
			p3 = new Player();
			
			int guessp1 = 0; // Declare variable to hold player input
			int guessp2 = 0;
			int guessp3 = 0;
			
			boolean p1isRight = false; //Declare variables to hold T/F based on player input
			boolean p2isRight = false;
			boolean p3isRight = false;
			
			int targetNumber = (int) (Math.random() * 10);
			System.out.println("I'm thinking of a number between 0 and 9...");
			
			while(true) {
				System.out.println("Number to guess is" + targetNumber);
				
				p1.guess();
				p2.guess();
				p3.guess();
				
				// Get each player's guess
				guessp1 = p1.number;
				System.out.println("Player 1 guessed " + guessp1);
				
				guessp2 = p2.number;
				System.out.println("Player 2 guessed "+ guessp2);
				
				guessp3 = p3.number;
				System.out.println("Player 3 guessed "+ guessp3);
				
				if (guessp1 == targetNumber) { // Check each player's guess
					p1isRight = true;
				}
				if (guessp2 == targetNumber) {
					p2isRight = true;
				}
				if (guessp3 == targetNumber) {
					p3isRight = true;
				}
				
				if (p1isRight || p2isRight || p3isRight) {
					System.out.println("We have a winner!!");
					System.out.println("Player one got it right? "+p1isRight);
					System.out.println("Player two got it right? "+p2isRight);
					System.out.println("Player three got it right? "+p3isRight);
					System.out.println("Game is over!");
					break;
				} else {
					System.out.println("Players will have to try again.");
				}
			}// End of while loop
		} // End of startGame method

	} // end GuessGame class
	public class Player {
		int number = 0; // where the guess goes
		
		public void guess() {
			number = (int) (Math.random() * 10);
			System.out.println("I'm guessing "+ number);
		}
	}

	public class GameLauncher {
		public static void main(String[] args) {
			GuessGame game = new GuessGame();
			game.startGame();
		}

	

}

