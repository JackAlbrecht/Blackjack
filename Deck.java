java.util.*;

class Deck {
    private Stack<Card> cards; // Stores the cards in the deck

    public Deck() {
        cards = new Stack<>(); // Initialize the stack to store the cards
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"}; // Array of suits in a deck
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; // Array of ranks in a deck

        // Create a card for each combination of suit and rank and add it to the stack
        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank); // Create a new card with the given suit and rank
                cards.push(card); // Add the card to the stack
            }
        }

        shuffle(); // Shuffle the cards in the deck
    }

    private void shuffle() {
        Collections.shuffle(cards); // Shuffle the cards in the deck using the Collections class
    }

    public Card drawCard() {
        return cards.pop(); // Remove and return the top card from the stack
    }
}
