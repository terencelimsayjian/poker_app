import java.util.ArrayList;

public abstract class PokerHandChecker {
    protected ArrayList<Card> cards = new ArrayList<Card>();
    protected ArrayList<Card> bestHand = new ArrayList<Card>();

    public PokerHandChecker(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getBestHand() {
        return bestHand;
    }

    protected abstract void calculateBestHand();

    // getScore? getHandType?

    protected final void addCardsWithValueToBestHand(int cardValue, int numberOfCardsToAdd) {
        int cardsAdded = 0;

        for (Card card : cards) {
            if (card.getValue() == cardValue && cardsAdded < numberOfCardsToAdd) {
                bestHand.add(card);
                cardsAdded++;
            }
        }
    }


}