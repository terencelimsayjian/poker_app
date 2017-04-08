import java.util.ArrayList;

public class Pair extends PokerHand {
    public Pair (ArrayList<Card> cards) {
        super(cards);

        calculateBestHand();
    }

    @Override
    protected void calculateBestHand() {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);

        int highestPairValue = cardValueCounter.getHighestCardOfCombination(cardValueCounter.PAIR);
        int highestSingleCardValue = cardValueCounter.getHighestCardOfCombination(cardValueCounter.SINGLE_CARD);
        int secondHighestSingleCardValue = cardValueCounter.getNextHighestCardOfCombination(cardValueCounter.SINGLE_CARD, highestSingleCardValue);
        int thirdHighestSingleCardValue = cardValueCounter.getNextHighestCardOfCombination(cardValueCounter.SINGLE_CARD, secondHighestSingleCardValue);

        addCardsWithValueToBestHand(highestPairValue, 2);
        addCardsWithValueToBestHand(highestSingleCardValue, 1);
        addCardsWithValueToBestHand(secondHighestSingleCardValue, 1);
        addCardsWithValueToBestHand(thirdHighestSingleCardValue, 1);
    }

    @Override
    public int compareTo(PokerHand o) {
        return 0;
    }
}
