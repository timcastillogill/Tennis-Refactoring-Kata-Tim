package tennisGame3;


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
        String playersScoreAsString;
        if (player1Points < 4 && player2Points < 4 && !(player1Points + player2Points == 6)) {
            String[] scoreString = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            playersScoreAsString = scoreString[player1Points];
            if (player1Points == player2Points) {
                return playersScoreAsString + "-All";
            }
            return playersScoreAsString + "-" + scoreString[player2Points];
        } else {
            if (player1Points == player2Points)
                return "Deuce";
            if (player1Points > player2Points) {
                playersScoreAsString = player1Name;
            }
            else playersScoreAsString = player2Name;
            int scoreDifference = player1Points - player2Points;

            if (scoreDifference == 1 || scoreDifference == -1) {
                return "Advantage " + playersScoreAsString;
            }
            return "Win for " + playersScoreAsString;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Points++;
        else
            player2Points++;
        
    }

}
