
public class TennisGame3 implements TennisGame {
	private final Player player1;
	private final Player player2;
	private final Referee referee;

	public TennisGame3(String player1Name, String player2Name) {
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player2Name);
		this.referee = new Referee(player1, player2);
	}

	public String getScore() {
		if (referee.isOnGoing()) return getOnGoingScoreToString();

		if (player1.getPoints() == player2.getPoints()) return "Deuce";

		referee.setWinningPlayerName();

		if (referee.isAdvantage()) {
			return getAdvantageString(referee.setWinningPlayerName());
		}

		return formatWinString(referee.setWinningPlayerName());
	}


	private static String formatWinString(String winningPlayerName) {
		return "Win for " + winningPlayerName;
	}

	private static String getAdvantageString(String winningPlayerName) {
		return "Advantage " + winningPlayerName;
	}

	String getOnGoingScoreToString() {
		String[] scoreString = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
		if (player1.getPoints() == player2.getPoints()) {
			return playersAtADrawString(scoreString);
		}
		return playerOngoingScoreString(scoreString);
	}

	private String playersAtADrawString(String[] scoreString) {
		return scoreString[player1.getPoints()] + "-All";
	}

	private String playerOngoingScoreString(String[] scoreString) {
		return scoreString[player1.getPoints()] + "-" + scoreString[player2.getPoints()];
	}

	public void wonPoint(String playerName) {
		if (playerName.equals("player1")) {
			player1.setPoints();
		} else {
			player2.setPoints();
		}
	}


}
