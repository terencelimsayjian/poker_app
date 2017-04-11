package com.pokerapp.models.hands;

import com.pokerapp.helpers.CardValueCounter;
import com.pokerapp.models.Card;

import java.util.ArrayList;

public class FourOfAKind extends PokerHand {
    private int fourOfAKindCardValue;
    private int singleCardValue;

    public FourOfAKind(ArrayList<Card> cards) {
        super(cards, PokerHand.FOUR_OF_A_KIND);
        calculateBestHand();
        setFourOfAKindCardValue(); // TODO: Check how much heavy lifting in controller
        setSingleCardValue();
    }

    public int getFourOfAKindCardValue() {
        return fourOfAKindCardValue;
    }

    @Override
    protected void calculateBestHand() {
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

    public int getSingleCardValue() {
        return singleCardValue;
    }

    @Override
    protected int subCompare(PokerHand pokerHand) {
        int quadCardValueComparison = compareFourOfAKindCardValue(pokerHand);

        if (quadCardValueComparison == 0) {
            return compareSingleCardValue(pokerHand);
        }

        return quadCardValueComparison;
    }

    private int compareFourOfAKindCardValue(PokerHand o) {
        FourOfAKind fourOfAKind = (FourOfAKind) o;
        return getFourOfAKindCardValue() - fourOfAKind.getFourOfAKindCardValue();
    }

    private int compareSingleCardValue(PokerHand o) {
        FourOfAKind fourOfAKind = (FourOfAKind) o;
        return getSingleCardValue() - fourOfAKind.getSingleCardValue();
    }

    private void setFourOfAKindCardValue() {
        CardValueCounter cardValueCounter = new CardValueCounter(bestHand);
        fourOfAKindCardValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.FOUR_OF_A_KIND);
    }

    private void setSingleCardValue() {
        CardValueCounter cardValueCounter = new CardValueCounter(bestHand);
        singleCardValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.SINGLE_CARD);
    }

}
