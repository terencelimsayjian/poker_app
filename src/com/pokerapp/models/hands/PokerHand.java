package com.pokerapp.models.hands;

import com.pokerapp.models.Card;

import java.util.ArrayList;

public abstract class PokerHand implements Comparable<PokerHand> {
    public static final int STRAIGHT_FLUSH = 9;
    public static final int FOUR_OF_A_KIND = 8;
    public static final int FULL_HOUSE = 7;
    public static final int FLUSH = 6;
    public static final int STRAIGHT = 5;
    public static final int THREE_OF_A_KIND = 4;
    public static final int TWO_PAIR = 3;
    public static final int PAIR = 2;
    public static final int HIGH_CARD = 1;

    protected ArrayList<Card> cards = new ArrayList<Card>();
    protected ArrayList<Card> bestHand = new ArrayList<Card>();
    protected int handStrength;

    public PokerHand(ArrayList<Card> cards, int handStrength) {
        this.cards = cards;
        this.handStrength = handStrength;
    }

    public ArrayList<Card> getBestHand() {
        return bestHand;
    }

    public int getHandStrength() {
        return handStrength;
    }

    protected abstract void calculateBestHand();

    public final int compareTo(PokerHand pokerHand) {
        int handStrengthComparison = getHandStrength() - pokerHand.getHandStrength();

        if (handStrengthComparison == 0) {
            return subCompare(pokerHand);
        }

        return handStrengthComparison;
    }

    protected int subCompare(PokerHand pokerHand) {
        return 0;
    }

    public String toString() {
        String handStrengthString = getHandStrengthString();

        return handStrengthString + ": " + getBestHand().toString();
    }

    private String getHandStrengthString() {
        String handStrengthString;
        switch (handStrength) {
            case 1:
                handStrengthString = "High Card";
                break;
            case 2:
                handStrengthString = "Pair";
                break;
            case 3:
                handStrengthString = "Two Pair";
                break;
            case 4:
                handStrengthString = "Three Of A Kind";
                break;
            case 5:
                handStrengthString = "Straight";
                break;
            case 6:
                handStrengthString = "Flush";
                break;
            case 7:
                handStrengthString = "Full House";
                break;
            case 8:
                handStrengthString = "Four Of A Kind";
                break;
            case 9:
                handStrengthString = "Straight Flush";
                break;
            default:
                handStrengthString = "Invalid Hand";
                break;
        }
        return handStrengthString;
    }

    protected final void addCardsWithValueToBestHand(int cardValue, int numberOfCardsToAdd) {
        int cardsAdded = 0;

        for (Card card : cards) {
            if (card.getValue() == cardValue && cardsAdded < numberOfCardsToAdd) {
                bestHand.add(card);
                cardsAdded++;
            }
        }
    }

}
