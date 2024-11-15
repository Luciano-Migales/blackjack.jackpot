package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Blackjack!");
        System.out.println("1. Start a new game");
        System.out.println("2. Exit");
        System.out.print("Select an option: ");
        
        if (scanner.nextInt() == 1) {
            System.out.print("Enter the number of players: ");
            int numPlayers = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            ArrayList<String> playerNames = new ArrayList<>();
            for (int i = 1; i <= numPlayers; i++) {
                System.out.print("Enter the name of player " + i + ": ");
                playerNames.add(scanner.nextLine());
            }
            
            Game game = new Game(playerNames);
            game.startGame();
        }
        
        scanner.close();
    }
}