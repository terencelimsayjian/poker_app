import java.util.ArrayList;
import java.util.Collections;

public class Flush extends PokerHand {
    public Flush(ArrayList<Card> cards) {
        super(cards);

        calculateBestHand();
    }

    @Override
    protected void calculateBestHand () {
        int flushSuit = getFlushSuit();

        addCardsWithSuitToBestHand(flushSuit);
        Collections.sort(bestHand);
        shiftCardsFromBestHandUntilFiveRemain();
    }

    private int getFlushSuit() {
        CardSuitCounter cardSuitCounter = new CardSuitCounter(cards);
        return cardSuitCounter.getFlushSuit();
    }

    private void shiftCardsFromBestHandUntilFiveRemain() {
        while (bestHand.size() > 5) {
            bestHand.remove(0);
        }
    }

    private void addCardsWithSuitToBestHand(int suit) {
        for (Card card : cards) {
            if (card.getSuit() == suit) {
                bestHand.add(card);
            }
        }
    }

}
