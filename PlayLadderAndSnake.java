import java.util.Scanner;

public class PlayLadderAndSnake {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in); // declaring Scanner called key
		System.out.println("Welcome to Snakes and Ladders.");
		System.out.println("Enter the number of players for your game - Number must be between 2 and 4 inclusively: ");
		int numPlayers = key.nextInt(); // storing the number of players
		int counter = 1; // creating a counter and initializing to 1

		while (numPlayers < 2 || numPlayers > 4) { // if its not between 2 and 4 inclusively
			if (4 - counter > 1) { // if not on last attempt
				System.out.println("Bad Attempt " + counter
						+ " - Invalid # of players. Please enter a # between 2 and 4 inclusively. You have "
						+ (4 - counter) + " attempts left: ");
				numPlayers = key.nextInt(); // storing the number of players
			}
			if (4 - counter == 1) { // if they are on their last attempt
				System.out.println("Bad Attempt " + counter
						+ " - Invalid # of players. Please enter a # between 2 and 4 inclusively. This is your last attempt: ");
				numPlayers = key.nextInt(); // storing the number of players
			}
			if (4 - counter == 0) { // if used up all attempts
				System.out.println(
						"Bad Attempt " + counter + "! You have exhausted all your chances. Program will terminate.");
				System.exit(0); // terminating the program
			}
			counter++; // increasing the counter
		}
		LadderAndSnake newGame = new LadderAndSnake(numPlayers); // creating a new snakes and ladder game
		int countDuplicates = 2; // creating an int called countDuplicates and setting to 2

		do {
			if (countDuplicates > 1) { // if more than 1 duplicates
				newGame.flipDiceAllPlayers(); // calling the flip dice all players method
				System.out.println();
				countDuplicates = newGame.checkDuplicates(); // checking duplicates
			}
			if (countDuplicates == 1) { // if only 1 duplicate
				System.out.print("\nA tie between 2 players was achieved. Attempting to break tie.\n");
				newGame.flipDiceTwoPeople(newGame.getIndex1(), newGame.getIndex2()); // calling the flip dice 2 people
																						// method
				System.out.println();
				countDuplicates = newGame.checkDuplicates(); // checking if any duplicates remain
			}
		} while (newGame.getCounter() != 0); // keep looping until the counter isnt 0

		newGame.orderOfPlay(newGame.getArray());

		LadderAndSnake.key.close(); // closing Scanner */
	}
}