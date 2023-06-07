import java.util.*

public class BlackjackGame {
    public static void main(String[] args) {
        int wins = 0;
        int losses = 0;
        boolean playAgain = true;

        while (playAgain) {
            Deck deck = new Deck();
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();

            // Deal initial cards
            playerHand.addCard(deck.drawCard());
            dealerHand.addCard(deck.drawCard());
            playerHand.addCard(deck.drawCard());
            dealerHand.addCard(deck.drawCard());

            System.out.println("Player's Hand:");
            playerHand.display();
            System.out.println("Player's Hand Value: " + playerHand.getValue());

            System.out.println("\nDealer's Hand:");
            dealerHand.display();

            // Player's turn
            boolean playerTurn = true;
            while (playerTurn) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nDo you want to hit or pass? (h/p): ");
                String choice = scanner.nextLine().trim().toLowerCase();

                if (choice.equals("h")) {
                    // Player hits
                    playerHand.addCard(deck.drawCard());
                    System.out.println("\nPlayer's Hand:");
                    playerHand.display();
                    System.out.println("Player's Hand Value: " + playerHand.getValue());

                    if (playerHand.getValue() > 21) {
                        System.out.println("\nPlayer busts! You lose.");
                        losses++;
                        playerTurn = false;
                    } else if (playerHand.isBlackjack()) {
                        System.out.println("\nPlayer has Blackjack! You win.");
                        wins++;
                        playerTurn = false;
                    }
                } else if (choice.equals("p")) {
                    // Player passes
                    System.out.println("\nPlayer passes.");
                    playerTurn = false;
                } else {
                    System.out.println("Invalid choice. Please try again.");
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
                System.out.println("\nPlayer busts! You lose.");
                
            } else if (dealerValue > 21) {
                System.out.println("\nDealer busts! You win.");
                wins++;
            } else if (playerValue == dealerValue) {
                System.out.println("\nIt's a tie.");
            } else if (playerValue > dealerValue) {
                System.out.println("\nYou win!");
                wins++;
            } else {
                System.out.println("\nYou lose.");
                losses++;
            }

            // Display scoreboard
            System.out.println("\nScoreboard:");
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);

            // Ask if the player wants to play again
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nDo you want to play again? (y/n): ");
            String playAgainChoice = scanner.nextLine().trim().toLowerCase();
            playAgain = playAgainChoice.equals("y");
            System.out.println();
        }
    }
}
