import java.util.ArrayList;

public abstract class FlushHandChecker {
    public static boolean isTrue(ArrayList<Card> cards) {
        if (cards.size() < 5) { return false; }

        CardSuitCounter cardSuitCounter = new CardSuitCounter(cards);
        return cardSuitCounter.getHighestOccurrenceOfAnySuit() >= 5;
    }
}
