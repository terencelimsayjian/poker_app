import java.util.ArrayList;
import java.util.Collections;

public class ConsecutiveCardAnalyser {

    /*
    * PROPERTIES
    * hasConsecutive: boolean
    * hasAceStartingStraight: boolean
    *
    * getConsecutiveCards
    *   startingWithAce
    *   noAce
    * */

    private boolean hasFiveOrMoreConsecutiveValues;
    private ArrayList<Card> cards;

    // boolean for existence of Ace
    // boolean for straight starting with Ace?
    // cards: ArrayList<Card>

    public ConsecutiveCardAnalyser(ArrayList<Card> cards) {
        Collections.sort(cards);
        this.cards = removeValueDuplicates(cards);

        hasFiveOrMoreConsecutiveValues = hasFiveOrMoreConsecutiveValues();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean getHasFiveOrMoreConsecutiveValues() {
        return hasFiveOrMoreConsecutiveValues;
    }

    private final boolean hasFiveOrMoreConsecutiveValues() {
        return hasFiveOrMoreConsecutiveValuesExcludingStartingWithAce() || hasFiveOrMoreConsecutiveValuesStartingWithAce();
    }

    private final boolean hasFiveOrMoreConsecutiveValuesExcludingStartingWithAce() {
        int consecutiveCardCount = 0;
        boolean isStraight = false;

        int indexOfThirdLastCard = this.cards.size() - 3;

        for (int i = 0; i <= indexOfThirdLastCard; i++) {
            Card currentCard = this.cards.get(i);
            Card nextCard = this.cards.get(i + 1);
            Card followingCard = this.cards.get(i + 2);

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

    private final boolean hasFiveOrMoreConsecutiveValuesStartingWithAce() {
        boolean lastCardIsAnAce = (this.cards.get(this.cards.size() - 1).isAce());

        if (!lastCardIsAnAce) { return false; }

        boolean isStraightStartingWithAce = true;

        int currentValueInStraight = 2;
        for (int i = 0; i < 4; i++) {
            if (this.cards.get(i).getValue() != currentValueInStraight) {
                isStraightStartingWithAce = false;
                // Break also avoids exceeding sortedCards size in the case of many duplicates
                break;
            }
            currentValueInStraight++;
        }

        return isStraightStartingWithAce;
    }

    private final ArrayList<Card> removeValueDuplicates(ArrayList<Card> sortedCards) {
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
}
