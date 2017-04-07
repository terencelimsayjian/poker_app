import java.util.ArrayList;

public abstract class FullHouseHandChecker {
    public static boolean isTrue(ArrayList<Card> cards) {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);
        int threeOfAKindCount = cardValueCounter.countCombinations(cardValueCounter.THREE_OF_A_KIND);
        int pairCount = cardValueCounter.countCombinations(cardValueCounter.PAIR);

        boolean isFullHouse = threeOfAKindCount == 1 && pairCount >= 1
                || threeOfAKindCount > 1;

        return isFullHouse;
    }
}
