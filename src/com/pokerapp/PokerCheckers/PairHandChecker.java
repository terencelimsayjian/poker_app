package com.pokerapp.PokerCheckers;

import com.pokerapp.helpers.CardValueCounter;
import com.pokerapp.models.Card;

import java.util.ArrayList;

public abstract class PairHandChecker {
    public static boolean isTrue(ArrayList<Card> cards) {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);
        int fourOfAKindCount = cardValueCounter.countCombinations(CardValueCounter.FOUR_OF_A_KIND);
        int threeOfAKindCount = cardValueCounter.countCombinations(CardValueCounter.THREE_OF_A_KIND);
        int pairCount = cardValueCounter.countCombinations(CardValueCounter.PAIR);

        return pairCount == 1 && threeOfAKindCount == 0 && fourOfAKindCount == 0;
    }
}
