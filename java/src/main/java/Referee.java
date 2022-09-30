public class Referee {

	Player player1;
	Player player2;

	private String calculateScore(Player player1, Player player2) {
		return "";
	}

	boolean isAdvantage(Player player1, Player player2) {
		int scoreDifference = player1.getPoints() - player2.getPoints();
		return (scoreDifference == 1 || scoreDifference == -1);
	}

	String setWinningPlayerName(Player player1, Player player2) {
		String winningPlayerName;
		if (player1.getPoints() > player2.getPoints()) {
			winningPlayerName = player1.getName();
		} else {
			winningPlayerName = player2.getName();
		}
		return winningPlayerName;
	}



	boolean isOnGoing(Player player1, Player player2) {
		return player1.getPoints() < 4 && player2.getPoints() < 4 && !(player1.getPoints() + player2.getPoints() == 6);
	}
}
