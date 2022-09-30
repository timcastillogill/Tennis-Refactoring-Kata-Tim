public class TennisGame3 implements TennisGame {
    
    private int player1Points;
    private int player2Points;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String winningPlayerName;
        if (isOnGoing()) {
            return onGoingScore();
        }

            if (player1Points == player2Points)
                return "Deuce";
            if (player1Points > player2Points) {
                winningPlayerName = player1Name;
            }
            else winningPlayerName = player2Name;
            int scoreDifference = player1Points - player2Points;

            if (scoreDifference == 1 || scoreDifference == -1) {
                return "Advantage " + winningPlayerName;
            }
            return "Win for " + winningPlayerName;

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
