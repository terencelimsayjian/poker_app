import java.util.ArrayList;

public abstract class PokerHand {
    public static final int STRAIGHT_FLUSH = 1;
    public static final int FOUR_OF_A_KIND = 2;
    public static final int FULL_HOUSE = 3;
    public static final int FLUSH = 4;
    public static final int STRAIGHT = 5;
    public static final int THREE_OF_A_KIND = 6;
    public static final int TWO_PAIR = 7;
    public static final int PAIR = 8;
    public static final int HIGH_CARD = 9;

    protected ArrayList<Card> cards = new ArrayList<Card>();
    protected ArrayList<Card> bestHand = new ArrayList<Card>();

    public PokerHand(ArrayList<Card> cards) {
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
