import java.util.ArrayList;

public class FourOfAKind extends PokerHand {
    public FourOfAKind(ArrayList<Card> cards) {
        super(cards);

        calculateBestHand();
    }

    @Override
    protected void calculateBestHand () {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);

        int highestFourOfAKindCardValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.FOUR_OF_A_KIND);
        int highestSingleCardValue = 1;

        for (Card card : cards) {
            if (card.getValue() > highestSingleCardValue && card.getValue() != highestFourOfAKindCardValue) {
                highestSingleCardValue = card.getValue();
            }
        }

        addCardsWithValueToBestHand(highestFourOfAKindCardValue, 4);
        addCardsWithValueToBestHand(highestSingleCardValue, 1);
    }

    @Override
    public int compareTo(PokerHand o) {
        return 0;
    }
}
