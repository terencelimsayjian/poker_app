import java.util.ArrayList;
import java.util.Collections;

public class PokerStraightsAnalyser {
    private boolean hasFiveOrMoreConsecutiveValues;
    private ArrayList<Card> cards;
    private ArrayList<Card> bestMadeStraight = new ArrayList<Card>();

    public PokerStraightsAnalyser(ArrayList<Card> cards) {
        Collections.sort(cards);
        this.cards = removeValueDuplicates(cards);
        hasFiveOrMoreConsecutiveValues = hasFiveOrMoreConsecutiveValues();

        if (hasFiveOrMoreConsecutiveValues) {
            addStraightCards();
        }
    }

    // TODO: Check if functions should be called in a constructor
    private ArrayList<Card> removeValueDuplicates(ArrayList<Card> sortedCards) {
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

    public ArrayList<Card> getBestMadeStraight() {
        return bestMadeStraight;
    }

    public boolean getHasFiveOrMoreConsecutiveValues() {
        return hasFiveOrMoreConsecutiveValues;
    }

    private boolean hasFiveOrMoreConsecutiveValues() {
        return hasFiveOrMoreConsecutiveValuesExcludingAceToFive() || hasAceToFiveStraight();
    }

    private boolean hasFiveOrMoreConsecutiveValuesExcludingAceToFive() {
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

    private boolean hasAceToFiveStraight() {
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

    private void addStraightCards() {
        if (hasFiveOrMoreConsecutiveValuesExcludingAceToFive()) {
            addTopFiveConsecutiveCardsToBestMadeStraight();
        } else if (hasAceToFiveStraight()) {
            addAceToFiveToStraightCards();
        }
    }

    private void addTopFiveConsecutiveCardsToBestMadeStraight() {
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
                bestMadeStraight.add(fifthLastCard);
                bestMadeStraight.add(fourthLastCard);
                bestMadeStraight.add(thirdLastCard);
                bestMadeStraight.add(secondLastCard);
                bestMadeStraight.add(lastCard);
                break;
            }
        }
    }

    private void addAceToFiveToStraightCards() {
        for (int i = 0; i <= 3; i++) {
            bestMadeStraight.add(cards.get(i));
        }

        bestMadeStraight.add(cards.get(cards.size() - 1));
    }
}
