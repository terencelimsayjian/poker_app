package com.pokerapp.helpers;

import com.pokerapp.models.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class CardSuitCounter {
    public static int getHighestOccurrenceOfAnySuit(ArrayList<Card> cards) {
        Map<Integer, Integer> suitOccurrenceCount = getSuitOccurrenceCount(cards);
        int highestOccurrence = 0;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() > highestOccurrence) {
                highestOccurrence = entry.getValue();
            }
        }

        return highestOccurrence;
    }

    public static int getFlushSuit(ArrayList<Card> cards) {
        Map<Integer, Integer> suitOccurrenceCount = getSuitOccurrenceCount(cards);

        int suit = 0;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                suit = entry.getKey();
                break;
            }
        }

        return suit;
    }

    private static Map<Integer, Integer> getSuitOccurrenceCount(ArrayList<Card> cards) {
        Map<Integer, Integer> suitOccurrenceMap = new HashMap<Integer, Integer>();

        for (Card card : cards) {
            Integer numOccurrence = suitOccurrenceMap.get(card.getSuit());

            if (numOccurrence == null) {
                suitOccurrenceMap.put(card.getSuit(), 1);
            } else {
                suitOccurrenceMap.put(card.getSuit(), ++numOccurrence);
            }
        }

        return suitOccurrenceMap;
    }

}

