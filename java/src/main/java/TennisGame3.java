
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

		String winningPlayerName = referee.getWinningPlayerName();

		if (referee.isMatchOnGoing()) return getRegularScoreString();

		if (referee.isMatchAtDeuce()) return "Deuce";

		if (referee.isAdvantage()) return formatAdvantageString(winningPlayerName);

		return formatWinString(winningPlayerName);
	}

	private static String formatWinString(String winningPlayerName) {
		return "Win for " + winningPlayerName;
	}

	private static String formatAdvantageString(String winningPlayerName) {
		return "Advantage " + winningPlayerName;
	}

	private String getRegularScoreString() {
		String[] scoreString = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
		return (referee.isMatchAtDeuce())
				? formatMatchAtDrawScore(scoreString)
				: formatRegularMatchScore(scoreString);
	}

	private String formatMatchAtDrawScore(String[] scoreString) {
		return scoreString[player1.getPoints()] + "-All";
	}

	private String formatRegularMatchScore(String[] scoreString) {
		return scoreString[player1.getPoints()] + "-" + scoreString[player2.getPoints()];
	}

	public void wonPoint(String playerName) {
		if (playerName.equals(player1.getName())) {
			player1.setPoints();
		} else {
			player2.setPoints();
		}
	}

}
