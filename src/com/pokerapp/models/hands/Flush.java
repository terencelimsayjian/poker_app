package com.pokerapp.models.hands;

import com.pokerapp.helpers.GetFlushCards;
import com.pokerapp.models.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Flush extends PokerHand {
    public Flush(ArrayList<Card> cards) {
        super(cards, PokerHand.FLUSH);

        calculateBestHand();
    }

    @Override
    protected void calculateBestHand () {
        ArrayList<Card> flushCards = GetFlushCards.call(cards);
        bestHand.addAll(flushCards);
        Collections.sort(bestHand);
        shiftCardsFromBestHandUntilFiveRemain();
    }

    private void shiftCardsFromBestHandUntilFiveRemain() {
        while (bestHand.size() > 5) {
            bestHand.remove(0);
        }
    }

}
