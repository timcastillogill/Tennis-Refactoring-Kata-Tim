

public class TennisGame3 implements TennisGame {

	private int player1Points;
	private int player2Points;
	private String player1Name;
	private String player2Name;
	private Player player1;
	private Player player2;
	private Referee referee;

	public TennisGame3(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player2Name);
		this.referee = new Referee();
	}

	public String getScore() {
		if (referee.isOnGoing(player1, player2)) {
			return getOnGoingScoreToString(player1, player2);
		}

		if (player1.getPoints() == player2.getPoints()) {
			return "Deuce";
		}

		referee.setWinningPlayerName(player1, player2);

		if (referee.isAdvantage(player1, player2)) {
            return getAdvantageString(referee.setWinningPlayerName(player1, player2));
        }

        return formatWinString(referee.setWinningPlayerName(player1, player2));
}


	private static String formatWinString(String winningPlayerName) {
		return "Win for " + winningPlayerName;
	}

	private static String getAdvantageString(String winningPlayerName) {
        return "Advantage " + winningPlayerName;
    }

	String getOnGoingScoreToString(Player player1, Player player2) {
		String[] scoreString = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
		String player1ScoreAsString = scoreString[player1.getPoints()];
		String player2ScoreAsString = scoreString[player2.getPoints()];
		if (player1.getPoints() == player2.getPoints()) {
			return player1ScoreAsString + "-All";
		}
		return player1ScoreAsString + "-" + player2ScoreAsString;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals("player1")) {
			player1.setPoints();
		} else {
			player2.setPoints();
		}
	}


}
