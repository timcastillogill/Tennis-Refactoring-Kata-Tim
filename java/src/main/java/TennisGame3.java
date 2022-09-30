import tennisGame1.Player;

public class TennisGame3 implements TennisGame {

	private int player1Points;
	private int player2Points;
	private String player1Name;
	private String player2Name;
	private Player player;

	public TennisGame3(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player1Name);
	}

	public String getScore() {
		if (isOnGoing()) {
			return onGoingScore();
		}

		if (player1Points == player2Points) {
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
		if (player1Points > player2Points) {
			winningPlayerName = player1Name;
		} else {
            winningPlayerName = player2Name;
        }
		return winningPlayerName;
	}

	private static String formatWinString(String winningPlayerName) {
		return "Win for " + winningPlayerName;
	}

	private boolean isAdvantage(String winningPlayerName) {
        int scoreDifference = player1Points - player2Points;
        return (scoreDifference == 1 || scoreDifference == -1);
    }

    private static String getAdvantageString(String winningPlayerName) {
        return "Advantage " + winningPlayerName;
    }

    private String onGoingScore() {
		String[] scoreString = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
		String player1ScoreAsString = scoreString[player1Points];
		String player2ScoreAsString = scoreString[player2Points];
		if (player1Points == player2Points) {
			return player1ScoreAsString + "-All";
		}
		return player1ScoreAsString + "-" + player2ScoreAsString;
	}

	private boolean isOnGoing() {
		return player1Points < 4 && player2Points < 4 && !(player1Points + player2Points == 6);
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1")
			player1Points++;
		else
			player2Points++;
	}


}
