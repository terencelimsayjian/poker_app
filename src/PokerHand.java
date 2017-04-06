import java.util.ArrayList;

public abstract class PokerHand {
    public final int STRAIGHT_FLUSH =  1;
    public final int FOUR_OF_A_KIND =  2;
    public final int FULL_HOUSE = 3;
    public final int FLUSH =  4;
    public final int STRAIGHT  =  5;
    public final int THREE_OF_A_KIND =  6;
    public final int TWO_PAIR  =  7;
    public final int PAIR  =  8;
    public final int HIGH_CARD =  9;

    protected ArrayList<Card> cards = new ArrayList<Card>();
    protected ArrayList<Card> bestHand = new ArrayList<Card>();

    public PokerHand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getBestHand() {
        return bestHand;
    }

    protected abstract void calculateBestHand();

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
