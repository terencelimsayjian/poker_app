import java.util.ArrayList;

public class ThreeOfAKind extends PokerHand {
    public ThreeOfAKind(ArrayList<Card> cards) {
        super(cards, PokerHand.THREE_OF_A_KIND);

        calculateBestHand();
    }

    @Override
    protected void calculateBestHand() {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);

        int highestThreeOfAKindValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.THREE_OF_A_KIND);
        int highestCardValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.SINGLE_CARD);
        int secondHighestCardValue = cardValueCounter.getNextHighestCardOfCombination(CardValueCounter.SINGLE_CARD, highestCardValue);

        addCardsWithValueToBestHand(highestThreeOfAKindValue, 3);
        addCardsWithValueToBestHand(highestCardValue, 1);
        addCardsWithValueToBestHand(secondHighestCardValue, 1);
    }

}
