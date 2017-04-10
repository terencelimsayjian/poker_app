import java.util.ArrayList;

public class FullHouse extends PokerHand {
    private int threeOfAKindCardValue;
    private int pairCardValue;

    public FullHouse(ArrayList<Card> cards) {
        super(cards, PokerHand.FULL_HOUSE);

        calculateBestHand();
        threeOfAKindCardValue = setThreeOfAKindCardValue();
        pairCardValue = setPairCardValue();
    }

    public int getThreeOfAKindCardValue() {
        return threeOfAKindCardValue;
    }

    public int getPairCardValue() {
        return pairCardValue;
    }

    @Override
    protected void calculateBestHand() {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);

        int threeOfAKindCount = cardValueCounter.countCombinations(cardValueCounter.THREE_OF_A_KIND);
        int highestThreeOfAKindValue = cardValueCounter.getHighestCardOfCombination(cardValueCounter.THREE_OF_A_KIND);

        int highestPairValue;

        if (threeOfAKindCount > 1) {
            highestPairValue = cardValueCounter.getNextHighestCardOfCombination(cardValueCounter.THREE_OF_A_KIND, highestThreeOfAKindValue);
        } else {
            highestPairValue = cardValueCounter.getHighestCardOfCombination(cardValueCounter.PAIR);
        }

        addCardsWithValueToBestHand(highestThreeOfAKindValue, 3);
        addCardsWithValueToBestHand(highestPairValue, 2);
    }

    @Override
    protected int subCompare(PokerHand pokerHand) {
        int threeOfAKindCardValueComparison = compareThreeOfAKindCardValue(pokerHand);

        if (threeOfAKindCardValueComparison == 0) {
            return compareThreeOfAKindCardValue(pokerHand);
        }

        return threeOfAKindCardValueComparison;
}

    private int compareThreeOfAKindCardValue(PokerHand pokerHand) {
        FullHouse fullHouse = (FullHouse) pokerHand;

        int threeOfAKindCardValueComparison = getThreeOfAKindCardValue() - fullHouse.getThreeOfAKindCardValue();

        if (threeOfAKindCardValueComparison == 0) {
            return comparePairCardValue(pokerHand);
        }

        return threeOfAKindCardValueComparison;
    }

    private int comparePairCardValue(PokerHand pokerHand) {
        FullHouse fullHouse = (FullHouse) pokerHand;
        return getPairCardValue() - fullHouse.getPairCardValue();
    }

    private int setThreeOfAKindCardValue() {
        CardValueCounter cardValueCounter = new CardValueCounter(bestHand);
        threeOfAKindCardValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.THREE_OF_A_KIND);
        return threeOfAKindCardValue;
    }

    private int setPairCardValue() {
        CardValueCounter cardValueCounter = new CardValueCounter(bestHand);
        pairCardValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.PAIR);
        return pairCardValue;
    }

}
