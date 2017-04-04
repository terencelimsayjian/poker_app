import java.util.*;

public class PokerHandChecker {
    private ArrayList<Card> cards = new ArrayList<Card>(7);
    private ArrayList<Card> bestHand = new ArrayList<Card>(5);

    PokerCardValueAnalyser pokerCardValueAnalyser;
    PokerFlushAnalyser pokerFlushAnalyser;
    PokerStraightsAnalyser pokerStraightsAnalyser;

    private boolean hasFiveOrMoreConsecutiveValues;
    private boolean hasFiveOrMoreOfSameSuit;
    private boolean hasFourOfAKind;
    private int tripsCount;
    private int pairCount;

    public PokerHandChecker(ArrayList<Card> board, ArrayList<Card> hand) {
        this.cards.addAll(0, board);
        this.cards.addAll(5, hand);

        // TODO: Check is sort should be called in the constructor
        Collections.sort(this.cards);

        pokerCardValueAnalyser = new PokerCardValueAnalyser(this.cards);
        pokerFlushAnalyser = new PokerFlushAnalyser(this.cards);
        pokerStraightsAnalyser = new PokerStraightsAnalyser(this.cards);

        hasFiveOrMoreOfSameSuit = pokerFlushAnalyser.hasFiveOrMoreOfTheSameSuit();
        hasFiveOrMoreConsecutiveValues = pokerStraightsAnalyser.getHasFiveOrMoreConsecutiveValues();
        hasFourOfAKind = pokerCardValueAnalyser.countCombinations(PokerCardValueAnalyser.FOUR_OF_A_KIND) == 1;
        tripsCount = pokerCardValueAnalyser.countCombinations(PokerCardValueAnalyser.THREE_OF_A_KIND);
        pairCount = pokerCardValueAnalyser.countCombinations(PokerCardValueAnalyser.PAIR);

        // TODO: Check if heavy lifting should be done here
        calculateBestHand();
    }

    public ArrayList<Card> getBestHand() {
        return bestHand;
    }

    public void calculateBestHand() {
         if (isStraightFlush()) {
            addBestStraightFlushToBestHand();
        } else if (isFourOfAKind()) {
            addBestFourOfAKindToBestHand();
        } else if (isFullHouse()) {
            addBestFullHouseToBestHand();
        } else if (isFlush()) {
            addBestFlushToBestHand();
        } else if (isStraight()) {
            addBestStraightToBestHand();
        } else if (isThreeOfAKind()) {
            addBestThreeOfAKindToBestHand();
        } else if (isTwoPair()) {
            addBestTwoPairToBestHand();
        } else if (isPair()) {
            addBestPairToBestHand();
        } else if (isHighCard()) {
            addBestHighCardToBestHand();
        }
    }


    public boolean isStraightFlush() {
        boolean isStraightFlush = false;

        if (hasFiveOrMoreOfSameSuit) {
            int flushedSuit = pokerFlushAnalyser.getFlushSuit();
            ArrayList<Card> flushCards = getCardsOfASpecificSuit(flushedSuit);

            PokerStraightsAnalyser csa = new PokerStraightsAnalyser(flushCards);
            isStraightFlush = csa.getHasFiveOrMoreConsecutiveValues();
        }

        return isStraightFlush;
    }

    private final ArrayList<Card> getCardsOfASpecificSuit(int suit) {
        ArrayList<Card> flushedCards = new ArrayList<Card>();

        for (Card card : cards) {
            if (card.getSuit() == suit) {
                flushedCards.add(card);
            }
        }

        return flushedCards;
    }

    public boolean isFourOfAKind() {
        return hasFourOfAKind;
    }

    public boolean isFullHouse() {
        return ((!hasFourOfAKind) &&
                ((tripsCount == 1) && (pairCount >= 1) || (tripsCount == 2)));
    }

    public boolean isFlush() {
        return hasFiveOrMoreOfSameSuit && !hasFourOfAKind && !isFullHouse();
    }

    public boolean isStraight() {
        return !hasFiveOrMoreOfSameSuit && hasFiveOrMoreConsecutiveValues;
    }

    public boolean isThreeOfAKind() {
        return !hasFiveOrMoreOfSameSuit && !hasFiveOrMoreConsecutiveValues
                && !hasFourOfAKind && (tripsCount == 1) && pairCount == 0;
    }

    public boolean isTwoPair() {
        return (!hasFiveOrMoreConsecutiveValues && !hasFiveOrMoreOfSameSuit && !hasFourOfAKind &&
                tripsCount == 0 & pairCount == 2);
    }

    public boolean isPair() {
        return (!hasFiveOrMoreConsecutiveValues && !hasFiveOrMoreOfSameSuit && !hasFourOfAKind &&
                tripsCount == 0 & pairCount == 1);
    }

    public boolean isHighCard() {
        return (!hasFiveOrMoreConsecutiveValues && !hasFiveOrMoreOfSameSuit && !hasFourOfAKind &&
                tripsCount == 0 & pairCount == 0);
    }


    private void addBestStraightFlushToBestHand() {
        int flushedSuit = pokerFlushAnalyser.getFlushSuit();
        ArrayList<Card> flushCards = getCardsOfASpecificSuit(flushedSuit);

        PokerStraightsAnalyser csa = new PokerStraightsAnalyser(flushCards);
        ArrayList<Card> straightFlushCards = csa.getBestMadeStraight();

        bestHand.addAll(straightFlushCards);
    }

    private void addBestFourOfAKindToBestHand() {
        int biggestFourOfAKindCardValue = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.FOUR_OF_A_KIND);
        int biggestSingleCardValue = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD);

        addCardsWithValueToBestHand(biggestFourOfAKindCardValue);
        addCardsWithValueToBestHand(biggestSingleCardValue);
    }

        private final void addCardsWithValueToBestHand(int cardValue) {
        for (Card card : cards) {
            if (card.getValue() == cardValue) {
                bestHand.add(card);
            }
        }
    }

    private void addBestFullHouseToBestHand() {
        int biggestThreeOfAKindCardValue = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.THREE_OF_A_KIND);
        int biggestPairCardValue = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.PAIR);

        addCardsWithValueToBestHand(biggestThreeOfAKindCardValue);
        addCardsWithValueToBestHand(biggestPairCardValue);
    }

    private void addBestFlushToBestHand() {
        ArrayList<Card> flushedCards = pokerFlushAnalyser.getBestMadeFlush();

        bestHand.addAll(flushedCards);
    }


    private void addBestStraightToBestHand() {
        ArrayList<Card> straightCards = pokerStraightsAnalyser.getBestMadeStraight();
        bestHand.addAll(straightCards);
    }

    private void addBestThreeOfAKindToBestHand() {
        int highestThreeOfAKind = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.THREE_OF_A_KIND);
        int highestCard = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD);
        int secondHighestCard = pokerCardValueAnalyser.getNextHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD, highestCard);

        addCardsWithValueToBestHand(7);
        addCardsWithValueToBestHand(highestCard);
        addCardsWithValueToBestHand(secondHighestCard);
    }

    private void addBestTwoPairToBestHand() {
        int highestPairCardValue = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.PAIR);
        int secondHighestPairCardValue = pokerCardValueAnalyser.getNextHighestCardOfCombination(PokerCardValueAnalyser.PAIR, highestPairCardValue);
        int highestSingleCardValue = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD);

        addCardsWithValueToBestHand(highestPairCardValue);
        addCardsWithValueToBestHand(secondHighestPairCardValue);
        addCardsWithValueToBestHand(highestSingleCardValue);
    }

    private void addBestPairToBestHand() {
        int highestPairCardValue = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.PAIR);

        int highestSingleCardValue = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD);
        int secondHighestSingleCardValue = pokerCardValueAnalyser.getNextHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD, highestSingleCardValue);
        int thirdHighestSingleCardValue = pokerCardValueAnalyser.getNextHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD, secondHighestSingleCardValue);

        addCardsWithValueToBestHand(highestPairCardValue);
        addCardsWithValueToBestHand(highestSingleCardValue);
        addCardsWithValueToBestHand(secondHighestSingleCardValue);
        addCardsWithValueToBestHand(thirdHighestSingleCardValue);
    }

    private void addBestHighCardToBestHand() {
        int highestSingleCardValue = pokerCardValueAnalyser.getHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD);
        int secondHighestSingleCardValue = pokerCardValueAnalyser.getNextHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD, highestSingleCardValue);
        int thirdHighestSingleCardValue = pokerCardValueAnalyser.getNextHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD, secondHighestSingleCardValue);
        int fourthHighestSingleCardValue = pokerCardValueAnalyser.getNextHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD, thirdHighestSingleCardValue);
        int fifthHighestSingleCardValue = pokerCardValueAnalyser.getNextHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD, fourthHighestSingleCardValue);

        addCardsWithValueToBestHand(highestSingleCardValue);
        addCardsWithValueToBestHand(secondHighestSingleCardValue);
        addCardsWithValueToBestHand(thirdHighestSingleCardValue);
        addCardsWithValueToBestHand(fourthHighestSingleCardValue);
        addCardsWithValueToBestHand(fifthHighestSingleCardValue);
    }
}
