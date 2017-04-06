import java.util.ArrayList;
import java.util.Collections;

public abstract class StraightHandChecker {
    public static boolean isTrue(ArrayList<Card> cards) {
        if (cards.size() < 5) { return false; }

        return hasFiveOrMoreConsecutiveValues(cards);
    }

    private static boolean hasFiveOrMoreConsecutiveValues(ArrayList<Card> cards) {
        Collections.sort(cards);
        cards = removeValueDuplicates(cards);

        return hasFiveOrMoreConsecutiveValuesExcludingAceToFive(cards) || hasAceToFiveStraight(cards);
    }

    private static ArrayList<Card> removeValueDuplicates(ArrayList<Card> sortedCards) {
        ArrayList<Card> cardsWithoutDuplicates = new ArrayList<Card>();

        cardsWithoutDuplicates.add(sortedCards.get(0));

        for (int i = 1; i < sortedCards.size(); i++) {
            Card previousCard = sortedCards.get(i - 1);
            Card currentCard = sortedCards.get(i);

            if (currentCard.getValue() != previousCard.getValue()) {
                cardsWithoutDuplicates.add(currentCard);
            }
        }

        return cardsWithoutDuplicates;
    }

    private static boolean hasFiveOrMoreConsecutiveValuesExcludingAceToFive(ArrayList<Card> sortedCards) {
        int consecutiveCardCount = 0;
        boolean isStraight = false;

        int indexOfThirdLastCard = sortedCards.size() - 3;

        for (int i = 0; i <= indexOfThirdLastCard; i++) {
            Card currentCard = sortedCards.get(i);
            Card nextCard = sortedCards.get(i + 1);
            Card followingCard = sortedCards.get(i + 2);

            if ((currentCard.getValue() == nextCard.getValue() - 1) &&
                    (nextCard.getValue() == followingCard.getValue() - 1)) {
                consecutiveCardCount++;
            }
        }

        if (consecutiveCardCount >= 3) {
            isStraight = true;
        }

        return isStraight;
    }

    private static boolean hasAceToFiveStraight(ArrayList<Card> sortedCards) {
        boolean lastCardIsAnAce = (sortedCards.get(sortedCards.size() - 1).isAce());

        if (!lastCardIsAnAce) { return false; }

        boolean isStraightStartingWithAce = true;

        int currentValueInStraight = 2;
        for (int i = 0; i < 4; i++) {
            if (sortedCards.get(i).getValue() != currentValueInStraight) {
                isStraightStartingWithAce = false;
                // Break also avoids exceeding sortedCards size in the case of many duplicates
                break;
            }
            currentValueInStraight++;
        }

        return isStraightStartingWithAce;
    }

}
