package com.pokerapp.models.hands;

import com.pokerapp.PokerCheckers.StraightHandChecker;
import com.pokerapp.helpers.RemoveCardValueDuplicates;
import com.pokerapp.models.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Straight extends PokerHand {
    public Straight(ArrayList<Card> cards) {
        super(cards, PokerHand.STRAIGHT);
        calculateBestHand();
    }

    @Override
    protected void calculateBestHand() {
        Collections.sort(cards);
        cards = RemoveCardValueDuplicates.call(cards);

        if (StraightHandChecker.hasFiveOrMoreConsecutiveValuesIgnoringAceToFive(cards)) {
            ArrayList<Card> topFiveCardsOfStraight = getTopFiveCardsOfStraight();
            bestHand.addAll(topFiveCardsOfStraight);
        } else if (hasAceToFiveStraight(cards)) {
            addFirstFourCardsToBestHand();
            addLastCardToBestHand();
        }

    }

    private void addLastCardToBestHand() {
        bestHand.add(cards.get(cards.size() - 1));
    }

    private void addFirstFourCardsToBestHand() {
        for (int i = 0; i < 4; i++) {
            bestHand.add(cards.get(i));
        }
    }

    private boolean hasAceToFiveStraight(ArrayList<Card> cards) {
        boolean lastCardIsAce = cards.get(cards.size() - 1).isAce();
        boolean firstFourCardsAreTwoToFive = areFirstFourCardsTwoToFive(cards);

        return lastCardIsAce && firstFourCardsAreTwoToFive;
    }

    private boolean areFirstFourCardsTwoToFive(ArrayList<Card> cards) {
        boolean firstFourCardsAreTwoToFive = true ;

        int cardValue = 2;
        for (int i = 0; i < 4; i++) {
            if (cards.get(i).getValue() != cardValue) {
                firstFourCardsAreTwoToFive = false;
            }
            cardValue += 1;
        }
        return firstFourCardsAreTwoToFive;
    }

    private ArrayList<Card> getTopFiveCardsOfStraight() {
        ArrayList<Card> topFiveStraightCards = new ArrayList<Card>(5);

        for (int i = cards.size() - 1; i >= 0; i--) {
            Card currentCard = cards.get(i);
            Card previousCard = cards.get(i - 1);
            Card secondPreviousCard = cards.get(i - 2);

            if (areCardsConsecutiveInAscendingOrder(secondPreviousCard, previousCard, currentCard)) {
                Card thirdPreviousCard = cards.get(i - 3);
                Card fourthPreviousCard = cards.get(i - 4);

                topFiveStraightCards.add(fourthPreviousCard);
                topFiveStraightCards.add(thirdPreviousCard);
                topFiveStraightCards.add(secondPreviousCard);
                topFiveStraightCards.add(previousCard);
                topFiveStraightCards.add(currentCard);
                break;
            }
        }

        return topFiveStraightCards;
    }

    private boolean areCardsConsecutiveInAscendingOrder(Card card1, Card card2, Card card3) {
        return card1.getValue() == card2.getValue() - 1
                && card2.getValue() == card3.getValue() - 1;
    }

    @Override
    protected int subCompare(PokerHand pokerHand) {
        Straight thatStraight = (Straight) pokerHand;

        if (hasAceToFiveStraight(bestHand) && !thatStraight.hasAceToFiveStraight(thatStraight.getBestHand())) {
            return -1;
        }

        if (!hasAceToFiveStraight(bestHand) && thatStraight.hasAceToFiveStraight(thatStraight.getBestHand())) {
            return 1;
        }

        Card thisHighestCard = bestHand.get(4);
        Card thatHighestCard = pokerHand.getBestHand().get(4);
        return thisHighestCard.getValue() - thatHighestCard.getValue();
    }
}
