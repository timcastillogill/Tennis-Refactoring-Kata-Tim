public class Referee {

	Player player1;
	Player player2;

	public Referee(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public boolean isAdvantage() {
		 int scoreDifference = player1.getPoints() - player2.getPoints();
		 return (scoreDifference == 1 || scoreDifference == -1);
	}

    public String getWinningPlayerName() {
		return (player1.getPoints() > player2.getPoints())
                ? player1.getName()
                : player2.getName();
	}

    public boolean isMatchOnGoing() {
		return player1.getPoints() < 4 && player2.getPoints() < 4 && !(player1.getPoints() + player2.getPoints() == 6);
	}

    public boolean isMatchAtDeuce() {
        return player1.getPoints() == player2.getPoints();
    }
}
