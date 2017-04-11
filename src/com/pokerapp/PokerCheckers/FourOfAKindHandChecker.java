package com.pokerapp.PokerCheckers;

import com.pokerapp.helpers.CardValueCounter;
import com.pokerapp.models.Card;

import java.util.ArrayList;

public abstract class FourOfAKindHandChecker {
    public static boolean isTrue(ArrayList<Card> cards) {
        if (cards.size() < 5) { return false; }

        boolean isFourOfAKind = new CardValueCounter(cards).countCombinations(CardValueCounter.FOUR_OF_A_KIND) >= 1;

        return isFourOfAKind;
    }
}
