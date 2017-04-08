import java.util.ArrayList;

public abstract class GetFlushCards {
    public static ArrayList<Card> call(ArrayList<Card> cards) {
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
