import java.util.ArrayList;

//if (FourOfAKind.isTrue(cards)) {
//    FourOfAKind asdf = new FourOfAKind
//    bestHand = fourOfAKind.getBestHand();
//}
//asdf.isTrue()
//asdf.getBestHand() => Empty arrayList

public class FourOfAKind extends PokerHandChecker {
    private CardValueCounter cardValueCounter;
    private boolean hasFourOfAKind;

    public FourOfAKind(ArrayList<Card> cards) {
        super(cards);
        cardValueCounter = new CardValueCounter(cards);

        hasFourOfAKind = cardValueCounter.countCombinations(cardValueCounter.FOUR_OF_A_KIND) >= 1;

        calculateBestHand();
    }

    public static boolean isTrue(ArrayList<Card> cards) {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);
        return cardValueCounter.countCombinations(cardValueCounter.FOUR_OF_A_KIND) >= 1;
    }

    @Override
    protected void calculateBestHand () {
        int highestFourOfAKindCardValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.FOUR_OF_A_KIND);
        int highestSingleCardValue = 1;

        for (Card card : cards) {
            if (card.getValue() != highestFourOfAKindCardValue && card.getValue() > highestSingleCardValue) {
                highestSingleCardValue = card.getValue();
            }
        }

        addCardsWithValueToBestHand(highestFourOfAKindCardValue, 4);
        addCardsWithValueToBestHand(highestSingleCardValue, 1);
    }

    // What happens if you ask for bestHand and it's not a made Hand?
    // Should class be static or not?
}
