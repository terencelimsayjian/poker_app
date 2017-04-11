package com.pokerapp.helpers;

import com.pokerapp.models.Card;

import java.util.ArrayList;
import java.util.Collections;

public abstract class RemoveCardValueDuplicates {
    public static ArrayList<Card> call(ArrayList<Card> cards) {
        Collections.sort(cards);

        ArrayList<Card> cardsWithoutDuplicates = new ArrayList<Card>();

        cardsWithoutDuplicates.add(cards.get(0));

        for (int i = 1; i < cards.size(); i++) {
            Card previousCard = cards.get(i - 1);
            Card currentCard = cards.get(i);

            if (currentCard.getValue() != previousCard.getValue()) {
                cardsWithoutDuplicates.add(currentCard);
            }
        }

        return cardsWithoutDuplicates;
    }
}
