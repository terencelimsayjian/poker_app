package com.pokerapp.PokerCheckers;

import com.pokerapp.helpers.CardValueCounter;
import com.pokerapp.models.Card;

import java.util.ArrayList;

public abstract class ThreeOfAKindHandChecker {
    public static boolean isTrue(ArrayList<Card> cards) {
        CardValueCounter cardValueCounter = new CardValueCounter(cards);
        int fourOfAKindCount = cardValueCounter.countCombinations(cardValueCounter.FOUR_OF_A_KIND);
        int threeOfAKindCount = cardValueCounter.countCombinations(cardValueCounter.THREE_OF_A_KIND);
        int pairCount = cardValueCounter.countCombinations(cardValueCounter.PAIR);

        return threeOfAKindCount == 1 && pairCount == 0 && fourOfAKindCount == 0;
    }
}
