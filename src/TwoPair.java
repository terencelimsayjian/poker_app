import java.util.ArrayList;

public class TwoPair extends PokerHand {
    public TwoPair (ArrayList<Card> cards) {
        super(cards, PokerHand.TWO_PAIR);

        calculateBestHand();
    }

    @Override
    protected void calculateBestHand() {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);

        int highestPairValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.PAIR);
        int secondHighestPairValue = cardValueCounter.getNextHighestCardOfCombination(CardValueCounter.PAIR, highestPairValue);
        int highestCardValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.SINGLE_CARD);

        addCardsWithValueToBestHand(highestPairValue, 2);
        addCardsWithValueToBestHand(secondHighestPairValue, 2);
        addCardsWithValueToBestHand(highestCardValue, 1);
    }

}
