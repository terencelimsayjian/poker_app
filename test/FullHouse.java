import java.util.ArrayList;

public class FullHouse extends PokerHand {
    int threeOfAKindCount;
    int pairCount;
    CardValueCounter cardValueCounter;

    public FullHouse(ArrayList<Card> cards) {
        super(cards);
        cardValueCounter = new CardValueCounter(cards);

        threeOfAKindCount = cardValueCounter.countCombinations(cardValueCounter.THREE_OF_A_KIND);
        pairCount = cardValueCounter.countCombinations(cardValueCounter.PAIR);

        if (isTrue()) {
            calculateBestHand();
        }
    }

    public boolean isTrue() {
        return threeOfAKindCount == 1 && pairCount >= 1
                || threeOfAKindCount > 1;
    }

    @Override
    public ArrayList<Card> getBestHand() {
        return bestHand;
    }

    @Override
    protected void calculateBestHand() {
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

}
