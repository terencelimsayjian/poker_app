import java.util.ArrayList;

public abstract class FourOfAKindHandChecker {
    public static boolean isTrue(ArrayList<Card> cards) {
        if (cards.size() < 5) { return false; }

        CardValueCounter cardValueCounter = new CardValueCounter(cards);
        return cardValueCounter.countCombinations(cardValueCounter.FOUR_OF_A_KIND) >= 1;
    }
}