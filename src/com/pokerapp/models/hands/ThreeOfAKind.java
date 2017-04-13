package com.pokerapp.models.hands;

import com.pokerapp.helpers.CardValueCounter;
import com.pokerapp.models.Card;
import com.pokerapp.models.hands.PokerHand;

import java.util.ArrayList;

public class ThreeOfAKind extends PokerHand {
    private int threeOfAKindCardValue;
    private int highestSingleCardValue;
    private int secondHighestSingleCardValue;

    public ThreeOfAKind(ArrayList<Card> cards) {
        super(cards, PokerHand.THREE_OF_A_KIND);

        calculateBestHand();
        threeOfAKindCardValue = setThreeOfAKindCardValue();
        highestSingleCardValue = setHighestCardValue();
        secondHighestSingleCardValue = setSecondHighestCardValue();
    }

    public int getThreeOfAKindCardValue() {
        return threeOfAKindCardValue;
    }

    public int getHighestSingleCardValue() {
        return highestSingleCardValue;
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

    public int getSecondHighestSingleCardValue() {
        return secondHighestSingleCardValue;
    }

    @Override
    protected int subCompare(PokerHand pokerHand) {
        ThreeOfAKind thatThreeOfAKind = (ThreeOfAKind) pokerHand;
        int threeOfAKindCardValueComparison = threeOfAKindCardValue - thatThreeOfAKind.getThreeOfAKindCardValue();

        if (threeOfAKindCardValueComparison == 0) {
            return compareHighCardValue(thatThreeOfAKind);
        }

        return threeOfAKindCardValue - thatThreeOfAKind.getThreeOfAKindCardValue();
    }

    private int compareHighCardValue(ThreeOfAKind thatThreeOfAKind) {
        int highCardValueComparison = highestSingleCardValue - thatThreeOfAKind.getHighestSingleCardValue();

        if (highCardValueComparison == 0) {
            return compareSecondHighCardValue(thatThreeOfAKind);
        }
        return highCardValueComparison;
    }

    private int compareSecondHighCardValue(ThreeOfAKind thatThreeOfAKind) {
        int secondHighestCardValueComparison = secondHighestSingleCardValue - thatThreeOfAKind.getSecondHighestSingleCardValue();
        return secondHighestCardValueComparison;
    }

    private int setThreeOfAKindCardValue() {
        CardValueCounter cardValueCounter = new CardValueCounter(bestHand);
        return cardValueCounter.getHighestCardOfCombination(CardValueCounter.THREE_OF_A_KIND);
    }

    private int setHighestCardValue() {
        CardValueCounter cardValueCounter = new CardValueCounter(bestHand);
        return cardValueCounter.getHighestCardOfCombination(CardValueCounter.SINGLE_CARD);
    }

    private int setSecondHighestCardValue() {
        CardValueCounter cardValueCounter = new CardValueCounter(bestHand);
        return cardValueCounter.getNextHighestCardOfCombination(CardValueCounter.SINGLE_CARD, highestSingleCardValue);
    }
}
