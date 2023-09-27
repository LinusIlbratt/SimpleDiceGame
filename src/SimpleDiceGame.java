import java.util.ArrayList;
import java.util.Scanner;

public class SimpleDiceGame {
    public static void main(String[] args) {

        ArrayList<Player> listOfPlayers = initialize();

        for (int i = 0; i < 5; i++){
            takeTurn(listOfPlayers);
        }

        ArrayList<Player> winners = getWinners(listOfPlayers);

        for (Player winner : winners) {
            System.out.println("The winner is " + winner.getPlayerName());
        }


    }

    private static ArrayList<Player> initialize() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();


        System.out.println("How many players?");
        int numberOfPlayers = sc.nextInt();

        System.out.println("How man dices should each player have?");
        int numberOfDices = sc.nextInt();

        System.out.println("How many sides shall the dices have?");
        int numberOfSides = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Name for player " + (i + 1) + ": ");

            String playerName = sc.nextLine();
            Player player = new Player(playerName);
            for (int j = 0; j < numberOfDices; j++) {
                player.addDie(numberOfSides);
            }
            players.add(player);
        }
        return players;
    }

    private static void takeTurn(ArrayList<Player> players) {
        Scanner sc = new Scanner(System.in);

        for (Player player : players) {
            System.out.println(player.getPlayerName() + " guess the total value: ");
            int playerGuess = sc.nextInt();
            player.rollDice();
            int diceValue = player.getDieValue();
            System.out.println(player.getPlayerName() + " rolled " + diceValue);
            if (playerGuess == diceValue) {
                player.increaseScore();
                System.out.println(player.getPlayerName() + " guessed right and now has " + player.getScore() + " points!");
            }
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();

        int highestScore = 0;
        // Loop to find the highest point
        for (Player player : players){
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
            }
        }
        for (Player player : players) {
            if (player.getScore() == highestScore){
                winners.add(player);
            }
        }
        return winners;
    }
}

