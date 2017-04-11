package com.pokerapp.helpers;

import com.pokerapp.PokerCheckers.*;
import com.pokerapp.models.Card;
import com.pokerapp.models.hands.*;

import java.util.ArrayList;

public abstract class BestPokerHand {

    public static PokerHand get(ArrayList<Card> cards) {
        PokerHand bestPokerHand = null;

        if (StraightFlushHandChecker.isTrue(cards)) {
            bestPokerHand = new StraightFlush(cards);
        } else if (FourOfAKindHandChecker.isTrue(cards)) {
            bestPokerHand = new FourOfAKind(cards);
        } else if (FullHouseHandChecker.isTrue(cards)) {
            bestPokerHand = new FullHouse(cards);
        } else if (FlushHandChecker.isTrue(cards)) {
            bestPokerHand = new Flush(cards);
        } else if (StraightHandChecker.isTrue(cards)) {
            bestPokerHand = new Straight(cards);
        } else if (ThreeOfAKindHandChecker.isTrue(cards)) {
            bestPokerHand = new ThreeOfAKind(cards);
        } else if (TwoPairHandChecker.isTrue(cards)) {
            bestPokerHand = new TwoPair(cards);
        } else if (PairHandChecker.isTrue(cards)) {
            bestPokerHand = new Pair(cards);
        } else if (HighCardHandChecker.isTrue(cards)) {
            bestPokerHand = new HighCard(cards);
        }

        return bestPokerHand;
    }

    public static PokerHand get(ArrayList<Card> board, ArrayList<Card> hand) {
        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.addAll(board);
        cards.addAll(hand);
        return BestPokerHand.get(cards);
    }

}
