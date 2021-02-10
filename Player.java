public class Player {
	String name = "";
	int diceNum = 0;

	public Player(String name, int diceNum) {
		this.name = name;
		this.diceNum = diceNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiceNum() {
		return diceNum;
	}

	public void setDiceNum(int diceNum) {
		this.diceNum = diceNum;
	}

}