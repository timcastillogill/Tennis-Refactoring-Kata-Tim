

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
		if (isOnGoing()) {
			return onGoingScore();
		}

		if (player1.getPoints() == player2.getPoints()) {
			return "Deuce";
		}

		setWinningPlayerName();

		if (isAdvantage(setWinningPlayerName())) {
            return getAdvantageString(setWinningPlayerName());
        }

        return formatWinString(setWinningPlayerName());
}


	private String setWinningPlayerName() {
		String winningPlayerName;
		if (player1.getPoints() > player2.getPoints()) {
			winningPlayerName = player1.getName();
		} else {
            winningPlayerName = player2.getName();
        }
		return winningPlayerName;
	}

	private static String formatWinString(String winningPlayerName) {
		return "Win for " + winningPlayerName;
	}

	private boolean isAdvantage(String winningPlayerName) {
        int scoreDifference = player1.getPoints() - player2.getPoints();
        return (scoreDifference == 1 || scoreDifference == -1);
    }

    private static String getAdvantageString(String winningPlayerName) {
        return "Advantage " + winningPlayerName;
    }

    private String onGoingScore() {
		String[] scoreString = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
		String player1ScoreAsString = scoreString[player1.getPoints()];
		String player2ScoreAsString = scoreString[player2.getPoints()];
		if (player1.getPoints() == player2.getPoints()) {
			return player1ScoreAsString + "-All";
		}
		return player1ScoreAsString + "-" + player2ScoreAsString;
	}

	private boolean isOnGoing() {
		return player1.getPoints() < 4 && player2.getPoints() < 4 && !(player1.getPoints() + player2.getPoints() == 6);
	}

	public void wonPoint(String playerName) {
		if (playerName.equals("player1")) {
			player1.setPoints();
		} else {
			player2.setPoints();
		}
	}


}
