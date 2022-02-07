
// **************************************************************************************
// Assignment #1
// Written by: Zayneb Mehdi 
// **************************************************************************************
import java.util.Random;
import java.util.Scanner;

public class LadderAndSnake {
	private int numOfPlayers; // declaring an int called numOfPlayers
	private int counter = 0; // declaring an int called counter and initializing to 0
	private int[][] board; // declaring a 2d board of int
	private int index1; // declaring an int variable called index1
	private int index2; // declaring an int variable called index2
	private Player[] array; // declaring an array of type Player class
	static Scanner key = new Scanner(System.in); // declaring static scanner

	// Default Constructor
	public LadderAndSnake() {
		board = new int[10][10]; // creating a 10 by 10 board
		numOfPlayers = 0; // number of players will be 0
		array = new Player[0]; // array size will be 0
	}

	// Parameterized constructor which intakes an int
	public LadderAndSnake(int numOfPlayers) {
		board = new int[10][10]; // creating a 10 by 10 board
		this.numOfPlayers = numOfPlayers; // setting to be the passed number of players
		array = new Player[numOfPlayers]; // setting the size to be the number of players

		for (int i = 0; i < numOfPlayers; i++) { // loop through asking the name of each player
			askName(); // calling the askName() method
		}
		System.out.println();
	}

	// method called askName which asks each player for their name
	public void askName() {
		System.out.print("Player " + (counter + 1) + " enter your name: ");
		String name = key.next(); // storing the name in String: name
		array[counter] = new Player(name, 0); // at every index adding a new Player object
		counter++; // increasing the counter
	}

	// Method to flip dice returns the dice number
	public int flipDice() {
		Random rand = new Random(); // creating a random object called rand
		int diceNum = rand.nextInt((6 - 1) + 1) + 1; // generating between 1 and 6 inclusively
		return diceNum; // returning the number
	}

	// Method to flip dice for all players
	public void flipDiceAllPlayers() {
		for (int i = 0; i < array.length; i++) { // loop through the array of players
			System.out.print(array[i].getName() + " is flipping the dice... Dice number: ");
			int diceNum = flipDice(); // storing the dice number returned from flipDice method
			array[i].setDiceNum(diceNum); // setting to be the dice number returned
			System.out.print(diceNum + "\n");
		}
	}

	// Method to flip dice for only two people
	public void flipDiceTwoPeople(int index1, int index2) {
		for (int i = 0; i < array.length; i++) {
			if (i == index1 || i == index2) { // if reached the index of the player with duplicate dice number
				System.out.print(array[i].getName() + " is flipping the dice... Dice number: ");
				int diceNum = flipDice(); // storing the dice number returned from flipDice method
				array[i].setDiceNum(diceNum); // setting to be the dice number returned
				System.out.print(diceNum + "\n");
			}
		}
	}

	// Method to check for same dice number
	public int checkDuplicates() {
		counter = 0;
		for (int i = 0; i < array.length; i++) { // loop through the array
			for (int j = i + 1; j < array.length; j++) { // loop through the next element
				if (array[i].getDiceNum() == array[j].getDiceNum()) { // if same diceNum
					index1 = i; // storing the index of the player with same diceNum
					index2 = j; // storing the index of the 2nd player with same diceNum
					counter++; // increase counter
				}
			}
		}
		return counter; // returning the number of duplicates
	}

	// method to fix the order of play
	public void orderOfPlay(Player[] array) {
		Player temp; // declaring a player object called temp
		for (int i = 0; i < array.length; i++) { // loop through array
			for (int j = i + 1; j < array.length; j++) { // loop through 2nd element
				if (array[i].getDiceNum() < array[j].getDiceNum()) { // if greater
					temp = array[i]; // storing a[i] in a temp variable
					array[i] = array[j]; // swapping a[i] with a[j]
					array[j] = temp; // replacing a[i] with a[j]
				}
			}
		}
		System.out.print("Reached final decision on order of playing : ");
		for (int i =0; i<array.length; i++)
			System.out.print(array[i].getName() + ", ");
	}
	
	public void play() {
		
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public Player[] getArray() {
		return array;
	}

	public void setArray(Player[] array) {
		this.array = array;
	}

	public int getIndex1() {
		return index1;
	}

	public void setIndex1(int index1) {
		this.index1 = index1;
	}

	public int getIndex2() {
		return index2;
	}

	public void setIndex2(int index2) {
		this.index2 = index2;
	}
}
