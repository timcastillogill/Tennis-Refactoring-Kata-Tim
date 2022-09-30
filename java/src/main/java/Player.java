public class Player {

    String name;
    int points;
    String score;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.score = "";
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints() {
        this.points ++;
    }

}
