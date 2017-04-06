import java.util.ArrayList;

public class FullHouse extends PokerHand {
    public FullHouse(ArrayList<Card> cards) {
        super(cards);

        calculateBestHand();
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

}
