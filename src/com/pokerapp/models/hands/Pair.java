package com.pokerapp.models.hands;

import com.pokerapp.helpers.CardValueCounter;
import com.pokerapp.models.Card;

import java.util.ArrayList;

public class Pair extends PokerHand {
    public Pair (ArrayList<Card> cards) {
        super(cards, PokerHand.PAIR);

        calculateBestHand();
    }

    @Override
    protected void calculateBestHand() {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);

        int highestPairValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.PAIR);
        int highestSingleCardValue = cardValueCounter.getHighestCardOfCombination(CardValueCounter.SINGLE_CARD);
        int secondHighestSingleCardValue = cardValueCounter.getNextHighestCardOfCombination(CardValueCounter.SINGLE_CARD, highestSingleCardValue);
        int thirdHighestSingleCardValue = cardValueCounter.getNextHighestCardOfCombination(CardValueCounter.SINGLE_CARD, secondHighestSingleCardValue);

        addCardsWithValueToBestHand(highestPairValue, 2);
        addCardsWithValueToBestHand(highestSingleCardValue, 1);
        addCardsWithValueToBestHand(secondHighestSingleCardValue, 1);
        addCardsWithValueToBestHand(thirdHighestSingleCardValue, 1);
    }

}
