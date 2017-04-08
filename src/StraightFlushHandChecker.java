import java.util.ArrayList;

public abstract class StraightFlushHandChecker {
    public static boolean isTrue(ArrayList<Card> cards) {
        boolean hasFlush = FlushHandChecker.isTrue(cards);
        boolean hasStraight = StraightHandChecker.isTrue(cards);
        boolean isStraightFlush = false;

        if (hasFlush && hasStraight) {
            ArrayList<Card> flushCards = getFlushCards(cards);
            isStraightFlush = StraightHandChecker.isTrue(flushCards);
        }

        return isStraightFlush;
    }

    private static ArrayList<Card> getFlushCards(ArrayList<Card> cards) {
        int flushSuit = CardSuitCounter.getFlushSuit(cards);

        ArrayList<Card> flushCards = new ArrayList<>();

        for (Card card : cards) {
            if (card.getSuit() == flushSuit) {
                flushCards.add(card);
            }
        }

        return flushCards;
    }

}
