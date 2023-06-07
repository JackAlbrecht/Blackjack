java.util.*;

class Hand {
    private Queue<Card> cards;

    public Hand() {
        cards = new LinkedList<>();
    }

    public void addCard(Card card) {
        cards.offer(card);
    }

    public int getValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank().equals("A")) {
                numAces++;
            }
        }

        // Adjust the value if there are Aces and the total value exceeds 21
        while (numAces > 0 && value > 21) {
            value -= 10; // Treat an Ace as 1 instead of 11
            numAces--;
        }

        return value;
    }

    public void display() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public boolean isBlackjack() {
        return (cards.size() == 2 && getValue() == 21);
    }

    public boolean containsAce() {
        for (Card card : cards) {
            if (card.getRank().equals("A")) {
                return true;
            }
        }
        return false;
    }
}
