import java.util.ArrayList;

public class Player {
    private String playerName;
    private int score;

    private ArrayList<Die> diceList;

    public Player(String playerName){
        this.playerName = playerName;
        this.score = 0;
        this.diceList = new ArrayList<Die>();

    }

    public void rollDice() {
        for(Die die : diceList) {
            die.roll();
        }
    }

    public int getDieValue() {
        int total = 0;
        for(Die die : diceList) {
            total += die.getCurrentValue();
        }
        return total;
    }
    public void increaseScore(){
        this.score += 1;
    }

    public void addDie(int sides){
        diceList.add(new Die(sides));
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

}
