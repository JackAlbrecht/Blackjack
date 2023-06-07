import java.util.*;

class Hand {
    private Queue<Card> cards; // Stores the cards in the hand

    public Hand() {
        cards = new LinkedList<>(); // Initialize the queue to store the cards
    }

    public void addCard(Card card) {
        cards.offer(card); // Add a card to the hand using the offer() method of the queue interface
    }

    public int getValue() {
        int value = 0; // Initialize the value of the hand to 0
        int numAces = 0; // Initialize the count of Aces in the hand to 0

        for (Card card : cards) {
            value += card.getValue(); // Add the value of each card to the total value of the hand
            if (card.getRank().equals("A")) {
                numAces++; // Count the number of Aces in the hand
            }
        }

        // Adjust the value if there are Aces and the total value exceeds 21
        while (numAces > 0 && value > 21) {
            value -= 10; // Treat an Ace as 1 instead of 11 to prevent busting
            numAces--;
        }

        return value; // Return the value of the hand
    }

    public void display() {
        for (Card card : cards) {
            System.out.println(card); // Display each card in the hand using the toString() method of the Card class
        }
    }

    public boolean isBlackjack() {
        return (cards.size() == 2 && getValue() == 21); // Check if the hand is a blackjack (contains two cards with a value of 21)
    }

    public boolean containsAce() {
        for (Card card : cards) {
            if (card.getRank().equals("A")) {
                return true; // Check if the hand contains an Ace
            }
        }
        return false; // Return false if the hand does not contain an Ace
    }
}
