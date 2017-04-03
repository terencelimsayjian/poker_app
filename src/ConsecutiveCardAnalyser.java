import java.util.ArrayList;
import java.util.Collections;

public class ConsecutiveCardAnalyser {

    private boolean hasFiveOrMoreConsecutiveValues;
    private ArrayList<Card> cards;
    private ArrayList<Card> straightCards = new ArrayList<Card>();


    public ConsecutiveCardAnalyser(ArrayList<Card> cards) {
        Collections.sort(cards);
        this.cards = removeValueDuplicates(cards);
        hasFiveOrMoreConsecutiveValues = hasFiveOrMoreConsecutiveValues();

        if (hasFiveOrMoreConsecutiveValues) {
            addStraightCards();
        }
    }

    public ArrayList<Card> getStraightCards() {
        return straightCards;
    }

    public boolean getHasFiveOrMoreConsecutiveValues() {
        return hasFiveOrMoreConsecutiveValues;
    }


    private final boolean hasFiveOrMoreConsecutiveValues() {
        return hasFiveOrMoreConsecutiveValuesExcludingAceToFive() || hasAceToFiveStraight();
    }

    private final boolean hasFiveOrMoreConsecutiveValuesExcludingAceToFive() {
        int consecutiveCardCount = 0;
        boolean isStraight = false;

        int indexOfThirdLastCard = cards.size() - 3;

        for (int i = 0; i <= indexOfThirdLastCard; i++) {
            Card currentCard = cards.get(i);
            Card nextCard = cards.get(i + 1);
            Card followingCard = cards.get(i + 2);

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

    private final boolean hasAceToFiveStraight() {
        boolean lastCardIsAnAce = (cards.get(cards.size() - 1).isAce());

        if (!lastCardIsAnAce) { return false; }

        boolean isStraightStartingWithAce = true;

        int currentValueInStraight = 2;
        for (int i = 0; i < 4; i++) {
            if (cards.get(i).getValue() != currentValueInStraight) {
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


    private final void addStraightCards() {
        if (hasFiveOrMoreConsecutiveValuesExcludingAceToFive()) {
            addTopFiveConsecutiveCardsToStraightCards();
        } else if (hasAceToFiveStraight()) {
            addAceToFiveToStraightCards();
        }
    }

    private void addTopFiveConsecutiveCardsToStraightCards() {
        int lastCardIndex = cards.size() - 1;
        int thirdLastCardIndex = cards.size() - 3;

        for (int i = lastCardIndex; i >= thirdLastCardIndex; i--) {
            Card lastCard = cards.get(i);
            Card secondLastCard = cards.get(i - 1);
            Card thirdLastCard = cards.get(i - 2);
            Card fourthLastCard = cards.get(i - 3);
            Card fifthLastCard = cards.get(i - 4);

            if (lastCard.getValue() == secondLastCard.getValue() + 1
                    && secondLastCard.getValue() == thirdLastCard.getValue() + 1
                    && thirdLastCard.getValue() == fourthLastCard.getValue() + 1
                    && fourthLastCard.getValue() == fifthLastCard.getValue() + 1) {
                straightCards.add(fifthLastCard);
                straightCards.add(fourthLastCard);
                straightCards.add(thirdLastCard);
                straightCards.add(secondLastCard);
                straightCards.add(lastCard);
                break;
            }
        }
    }

    private void addAceToFiveToStraightCards() {
        for (int i = 0; i <= 3; i++) {
            straightCards.add(cards.get(i));
        }

        straightCards.add(cards.get(cards.size() - 1));
    }
}
