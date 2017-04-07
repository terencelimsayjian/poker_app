import java.util.ArrayList;
import java.util.Collections;

public class Straight extends PokerHand {
    public Straight(ArrayList<Card> cards) {
        super(cards);
        calculateBestHand();
    }

    @Override
    protected void calculateBestHand() {
        Collections.sort(cards);

        if (StraightHandChecker.hasFiveOrMoreConsecutiveValuesIgnoringAceToFive(cards)) {
            ArrayList<Card> topFiveCardsOfStraight = getTopFiveCardsOfStraight();
            bestHand.addAll(topFiveCardsOfStraight);
        } else if (isAceToFiveStraight()) {
            addFirstFourCardsToBestHand();
            addLastCardToBestHand();
        }

    }

    private void addLastCardToBestHand() {
        bestHand.add(cards.get(cards.size() - 1));
    }

    private void addFirstFourCardsToBestHand() {
        for (int i = 0; i < 4; i++) {
            bestHand.add(cards.get(i));
        }
    }

    private boolean isAceToFiveStraight() {
        boolean lastCardIsAce = cards.get(cards.size() - 1).isAce();
        boolean firstFourCardsAreTwoToFive = isFirstFourCardsAreTwoToFive();

        return lastCardIsAce && firstFourCardsAreTwoToFive;
    }

    private boolean isFirstFourCardsAreTwoToFive() {
        boolean firstFourCardsAreTwoToFive = true;

        int cardValue = 2;
        for (int i = 0; i < 4; i++) {
            if (cards.get(i).getValue() != cardValue) {
                firstFourCardsAreTwoToFive = false;
            }
            cardValue += 1;
        }
        return firstFourCardsAreTwoToFive;
    }

    private ArrayList<Card> getTopFiveCardsOfStraight() {
        ArrayList<Card> topFiveStraightCards = new ArrayList<Card>(5);

        for (int i = cards.size() - 1; i >= 0; i--) {
            Card currentCard = cards.get(i);
            Card previousCard = cards.get(i - 1);
            Card secondPreviousCard = cards.get(i - 2);

            if (areCardsConsecutive(secondPreviousCard, previousCard, currentCard)) {
                Card thirdPreviousCard = cards.get(i - 3);
                Card fourthPreviousCard = cards.get(i - 4);

                topFiveStraightCards.add(fourthPreviousCard);
                topFiveStraightCards.add(thirdPreviousCard);
                topFiveStraightCards.add(secondPreviousCard);
                topFiveStraightCards.add(previousCard);
                topFiveStraightCards.add(currentCard);
                break;
            }
        }

        return topFiveStraightCards;
    }

    private boolean areCardsConsecutive(Card secondPreviousCard, Card previousCard, Card currentCard) {
        return secondPreviousCard.getValue() == previousCard.getValue() - 1
                && previousCard.getValue() == currentCard.getValue() - 1;
    }
}
