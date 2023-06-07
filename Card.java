import java.util.*;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
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
        return rank + " of " + suit;
    }
}
