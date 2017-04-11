package com.pokerapp.PokerCheckers;

import com.pokerapp.helpers.CardSuitCounter;
import com.pokerapp.models.Card;

import java.util.ArrayList;

public abstract class FlushHandChecker {
    public static boolean isTrue(ArrayList<Card> cards) {
        if (cards.size() < 5) { return false; }

        return CardSuitCounter.getHighestOccurrenceOfAnySuit(cards) >= 5;
    }
}
