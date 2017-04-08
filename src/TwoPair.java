import java.util.ArrayList;

public class TwoPair extends PokerHand {
    public TwoPair (ArrayList<Card> cards) {
        super(cards);

        calculateBestHand();
    }

    @Override
    protected void calculateBestHand() {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);

        int highestPairValue = cardValueCounter.getHighestCardOfCombination(cardValueCounter.PAIR);
        int secondHighestPairValue = cardValueCounter.getNextHighestCardOfCombination(cardValueCounter.PAIR, highestPairValue);
        int highestCardValue = cardValueCounter.getHighestCardOfCombination(cardValueCounter.SINGLE_CARD);

        addCardsWithValueToBestHand(highestPairValue, 2);
        addCardsWithValueToBestHand(secondHighestPairValue, 2);
        addCardsWithValueToBestHand(highestCardValue, 1);
    }

    @Override
    public int compareTo(PokerHand o) {
        return 0;
    }

}
