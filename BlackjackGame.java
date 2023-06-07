import java.util.*;

public class BlackjackGame {
    public static void main(String[] args) {
        int wins = 0; // Tracks the number of wins
        int losses = 0; // Tracks the number of losses
        boolean playAgain = true; // Controls if the player wants to play again 

        while (playAgain) {
            Deck deck = new Deck(); // Create a new deck of cards
            Hand playerHand = new Hand(); // Create an empty hand for the player
            Hand dealerHand = new Hand(); // Create an empty hand for the dealer

            // Deal initial cards
            playerHand.addCard(deck.drawCard()); // Draw a card for the player
            dealerHand.addCard(deck.drawCard()); // Draw a card for the dealer
            playerHand.addCard(deck.drawCard()); // Draw a second card for the player
            dealerHand.addCard(deck.drawCard()); // Draw a second card for the dealer

            System.out.println("Player's Hand:"); // Display the player's hand
            playerHand.display();
            System.out.println("Player's Hand Value: " + playerHand.getValue()); // Display the value of the player's hand

            System.out.println("\nDealer's Hand:"); // Display the dealer's hand
            dealerHand.display();

            // Player's turn
            boolean playerTurn = true; // Controls if its the player's turn or not
            while (playerTurn) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nDo you want to hit or pass? (h/p): "); // Prompt the player for their choice
                String choice = scanner.nextLine().trim().toLowerCase(); // Read the player's choice and convert it to lowercase and removes blank space

                if (choice.equals("h")) {
                    // Player hits
                    playerHand.addCard(deck.drawCard()); // Draw a card for the player
                    System.out.println("\nPlayer's Hand:"); // Display the player's hand
                    playerHand.display();
                    System.out.println("Player's Hand Value: " + playerHand.getValue()); // Display the value of the player's hand

                    if (playerHand.getValue() > 21) {
                        System.out.println("\nPlayer busts! You lose."); // Player's hand value exceeds 21
                        losses++; // Add the number of losses
                        playerTurn = false; // End the player's turn
                    } else if (playerHand.isBlackjack()) {
                        System.out.println("\nPlayer has Blackjack! You win."); // Player has a blackjack (hand value of 21)
                        wins++; // Add the number of wins
                        playerTurn = false; // End the player's turn
                    }
                } else if (choice.equals("p")) {
                    // Player passes
                    System.out.println("\nPlayer passes."); // Player chooses to stop receiving cards
                    playerTurn = false; // End the player's turn
                } else {
                    System.out.println("Invalid choice. Please try again."); // Player entered an invalid choice
                }
            }

            // Dealer's turn
            System.out.println("\nDealer's Turn:");
            System.out.println("Dealer's Hand:");
            dealerHand.display();

            while (dealerHand.getValue() < 17 || (dealerHand.getValue() == 17 && dealerHand.containsAce())) {
                dealerHand.addCard(deck.drawCard());
                System.out.println("\nDealer hits.");
                System.out.println("Dealer's Hand:");
                dealerHand.display();
            }

            System.out.println("Dealer's Hand Value: " + dealerHand.getValue());

            // Determine the winner
            int playerValue = playerHand.getValue();
            int dealerValue = dealerHand.getValue();

            if (playerValue > 21) {
                System.out.println("\nPlayer busts! You lose."); // Player's hand value exceeds 21
                // notice that there is no add of losses here because if you hit (which you must do to get 
                // above your current number), you will already incur a loss. Therefore if a loss is here as well,
                // you would incur two losses.
            } else if (dealerValue > 21) {
                System.out.println("\nDealer busts! You win."); // Dealer's hand value exceeds 21
                wins++; // Add the number of wins
            } else if (playerValue == dealerValue) {
                System.out.println("\nIt's a tie."); // Player's hand value is equal to the dealer's hand value
                       // notice no add of wins or losses here because of tie!
            } else if (playerValue > dealerValue) {
                System.out.println("\nYou win!"); // Player's hand value is greater than the dealer's hand value
                wins++; // Add the number of wins
            } else {
                System.out.println("\nYou lose."); // Player's hand value is less than the dealer's hand value
                losses++; // Add the number of losses
            }

            // Display scoreboard
            System.out.println("\nScoreboard:");
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses); 

            // Ask if the player wants to play again
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nDo you want to play again? (y/n): ");
            String playAgainChoice = scanner.nextLine().trim().toLowerCase();
            playAgain = playAgainChoice.equals("y"); // Set based on the player's choice
            System.out.println();
        }
    }
}
