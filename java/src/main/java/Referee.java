public class Referee {

	Player player1;
	Player player2;

	public Referee(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	boolean isAdvantage() {
		 int scoreDifference = player1.getPoints() - player2.getPoints();
		 return (scoreDifference == 1 || scoreDifference == -1);
	}

	String setWinningPlayerName() {
		String winningPlayerName;
		if (player1.getPoints() > player2.getPoints()) {
			winningPlayerName = player1.getName();
		} else {
			winningPlayerName = player2.getName();
		}
		return winningPlayerName;
	}



	boolean isOnGoing() {
		return player1.getPoints() < 4 && player2.getPoints() < 4 && !(player1.getPoints() + player2.getPoints() == 6);
	}
}
