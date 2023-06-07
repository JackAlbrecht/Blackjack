import java.util.*;

class Card {
    private String suit; // Stores the suit of the card
    private String rank; // StoreS the rank of the card

    public Card(String suit, String rank) {
        this.suit = suit; // Initialize the suit of the card
        this.rank = rank; // Initialize the rank of the card
    }

    public String getSuit() {
        return suit; // Return the suit of the card
    }

    public String getRank() {
        return rank; // Return the rank of the card
    }

    public int getValue() {
        if (rank.equals("A")) {
            return 11; // Ace can have a value of 11
        } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
            return 10; // King, Queen, and Jack have a value of 10
        } else {
            return Integer.parseInt(rank); // Other ranks have their face value
        }
    }

    public String toString() {
        return rank + " of " + suit; // Return a string representation of the card in the format "<rank> of <suit>"
    }
}
