import java.util.ArrayList;

public class HighCard extends PokerHand {
    public HighCard (ArrayList<Card> cards) {
        super(cards, PokerHand.HIGH_CARD);
        calculateBestHand();
    }

    @Override
    protected void calculateBestHand() {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);

        int highestSingleCardValue = cardValueCounter.getHighestCardOfCombination(cardValueCounter.SINGLE_CARD);
        int secondHighestSingleCardValue = cardValueCounter.getNextHighestCardOfCombination(cardValueCounter.SINGLE_CARD, highestSingleCardValue);
        int thirdHighestSingleCardValue = cardValueCounter.getNextHighestCardOfCombination(cardValueCounter.SINGLE_CARD, secondHighestSingleCardValue);
        int fourthHighestSingleCardValue = cardValueCounter.getNextHighestCardOfCombination(cardValueCounter.SINGLE_CARD, thirdHighestSingleCardValue);
        int fifthHighestSingleCardValue = cardValueCounter.getNextHighestCardOfCombination(cardValueCounter.SINGLE_CARD, fourthHighestSingleCardValue);

        addCardsWithValueToBestHand(highestSingleCardValue, 1);
        addCardsWithValueToBestHand(secondHighestSingleCardValue, 1);
        addCardsWithValueToBestHand(thirdHighestSingleCardValue, 1);
        addCardsWithValueToBestHand(fourthHighestSingleCardValue, 1);
        addCardsWithValueToBestHand(fifthHighestSingleCardValue, 1);
    }

}
