import java.util.*;

public class PokerCombinationChecker {
    private ArrayList<Card> cards = new ArrayList<Card>(7);

    private ArrayList<Card> bestHand = new ArrayList<Card>(5);

    CardValueAnalyser cardValueAnalyser;
    CardSuitAnalyser cardSuitAnalyser;
    ConsecutiveCardAnalyser consecutiveCardAnalyser;

    private boolean hasFiveOrMoreConsecutiveValues;
    private boolean hasFiveOrMoreOfSameSuit;
    private boolean hasFourOfAKind;
    private int tripsCount;
    private int pairCount;

    public PokerCombinationChecker(ArrayList<Card> board, ArrayList<Card> hand) {
        this.cards.addAll(0, board);
        this.cards.addAll(5, hand);

        Collections.sort(this.cards);

        cardValueAnalyser = new CardValueAnalyser(this.cards);
        cardSuitAnalyser = new CardSuitAnalyser(this.cards);
        consecutiveCardAnalyser = new ConsecutiveCardAnalyser(this.cards);

        hasFiveOrMoreOfSameSuit = cardSuitAnalyser.hasFiveOrMoreOfTheSameSuit();
        hasFiveOrMoreConsecutiveValues = consecutiveCardAnalyser.getHasFiveOrMoreConsecutiveValues();

        hasFourOfAKind = cardValueAnalyser.countCombinations(CardValueAnalyser.FOUR_OF_A_KIND) == 1;
        tripsCount = cardValueAnalyser.countCombinations(CardValueAnalyser.THREE_OF_A_KIND);
        pairCount = cardValueAnalyser.countCombinations(CardValueAnalyser.PAIR);

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
            adBestHighCardToBestHand();
        }
    }

    public boolean isStraightFlush() {
        boolean isStraightFlush = false;

        if (hasFiveOrMoreOfSameSuit) {
            int flushedSuit = cardSuitAnalyser.getFlushSuit();
            ArrayList<Card> flushCards = getCardsOfASuit(this.cards, flushedSuit);

            ConsecutiveCardAnalyser csa = new ConsecutiveCardAnalyser(flushCards);
            isStraightFlush = csa.getHasFiveOrMoreConsecutiveValues();
        }

        return isStraightFlush;
    }

    public void addBestStraightFlushToBestHand() {
        // TODO: Same as isStraightFlush() - Keep it DRY
        int flushedSuit = cardSuitAnalyser.getFlushSuit();
        ArrayList<Card> flushCards = getCardsOfASuit(this.cards, flushedSuit);

        ConsecutiveCardAnalyser csa = new ConsecutiveCardAnalyser(flushCards);
        ArrayList<Card> straightFlushCards = csa.getStraightCards();

        bestHand.addAll(straightFlushCards);
    }
    // TODO: Take ACE straight into account
    // TODO: Rename - Doesn't 'get' anything

    public boolean isFourOfAKind() {
        return hasFourOfAKind;
    }

    public void addBestFourOfAKindToBestHand() {
        int biggestFourOfAKindCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.FOUR_OF_A_KIND);
        int biggestSingleCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD);

        addCardsWithValueToBestHand(biggestFourOfAKindCardValue);
        addCardsWithValueToBestHand(biggestSingleCardValue);
    }


    public boolean isFullHouse() {
        return ((!hasFourOfAKind) &&
                ((tripsCount == 1) && (pairCount >= 1) || (tripsCount == 2)));
    }

    public void addBestFullHouseToBestHand() {
        int biggestThreeOfAKindCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.THREE_OF_A_KIND);
        int biggestPairCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.PAIR);

        addCardsWithValueToBestHand(biggestThreeOfAKindCardValue);
        addCardsWithValueToBestHand(biggestPairCardValue);
    }


    public boolean isFlush() {
        return hasFiveOrMoreOfSameSuit && !hasFourOfAKind && !isFullHouse();
    }

    public void addBestFlushToBestHand() {
        int flushedSuit = cardSuitAnalyser.getFlushSuit();
        ArrayList<Card> flushedCards = getCardsOfASuit(this.cards, flushedSuit);

        removeLowestCardsUntilFiveCardsRemain(flushedCards);
        bestHand.addAll(flushedCards);
    }


    public boolean isStraight() {
        return !hasFiveOrMoreOfSameSuit && hasFiveOrMoreConsecutiveValues;
    }

    public void addBestStraightToBestHand() {
        bestHand.addAll(consecutiveCardAnalyser.getStraightCards());
    }


    public boolean isThreeOfAKind() {
        return !hasFiveOrMoreOfSameSuit && !hasFiveOrMoreConsecutiveValues
                && !hasFourOfAKind && (tripsCount == 1) && pairCount == 0;
    }

    public void addBestThreeOfAKindToBestHand() {
        int highestThreeOfAKind = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.THREE_OF_A_KIND);
        int highestCard = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD);
        int secondHighestCard = cardValueAnalyser.getNextHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD, highestCard);

        addCardsWithValueToBestHand(7);
        addCardsWithValueToBestHand(highestCard);
        addCardsWithValueToBestHand(secondHighestCard);
    }


    public boolean isTwoPair() {
        return (!hasFiveOrMoreConsecutiveValues && !hasFiveOrMoreOfSameSuit && !hasFourOfAKind &&
                tripsCount == 0 & pairCount == 2);
    }

    public void addBestTwoPairToBestHand() {
        int highestPairCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.PAIR);
        int secondHighestPairCardValue = cardValueAnalyser.getNextHighestCardOfCombination(CardValueAnalyser.PAIR, highestPairCardValue);
        int highestSingleCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD);

        addCardsWithValueToBestHand(highestPairCardValue);
        addCardsWithValueToBestHand(secondHighestPairCardValue);
        addCardsWithValueToBestHand(highestSingleCardValue);
    }


    public boolean isPair() {
        return (!hasFiveOrMoreConsecutiveValues && !hasFiveOrMoreOfSameSuit && !hasFourOfAKind &&
                tripsCount == 0 & pairCount == 1);
    }

    public void addBestPairToBestHand() {
        int highestPairCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.PAIR);

        int highestSingleCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD);
        int secondHighestSingleCardValue = cardValueAnalyser.getNextHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD, highestSingleCardValue);
        int thirdHighestSingleCardValue = cardValueAnalyser.getNextHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD, secondHighestSingleCardValue);

        addCardsWithValueToBestHand(highestPairCardValue);
        addCardsWithValueToBestHand(highestSingleCardValue);
        addCardsWithValueToBestHand(secondHighestSingleCardValue);
        addCardsWithValueToBestHand(thirdHighestSingleCardValue);
    }


    public boolean isHighCard() {
        return (!hasFiveOrMoreConsecutiveValues && !hasFiveOrMoreOfSameSuit && !hasFourOfAKind &&
                tripsCount == 0 & pairCount == 0);
    }

    public void adBestHighCardToBestHand() {
        int highestSingleCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD);
        int secondHighestSingleCardValue = cardValueAnalyser.getNextHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD, highestSingleCardValue);
        int thirdHighestSingleCardValue = cardValueAnalyser.getNextHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD, secondHighestSingleCardValue);
        int fourthHighestSingleCardValue = cardValueAnalyser.getNextHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD, thirdHighestSingleCardValue);
        int fifthHighestSingleCardValue = cardValueAnalyser.getNextHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD, fourthHighestSingleCardValue);

        addCardsWithValueToBestHand(highestSingleCardValue);
        addCardsWithValueToBestHand(secondHighestSingleCardValue);
        addCardsWithValueToBestHand(thirdHighestSingleCardValue);
        addCardsWithValueToBestHand(fourthHighestSingleCardValue);
        addCardsWithValueToBestHand(fifthHighestSingleCardValue);
    }


    private final ArrayList<Card> getCardsOfASuit(ArrayList<Card> cards, int suit) {
        ArrayList<Card> flushedCards = new ArrayList<Card>();

        for (Card card : cards) {
            if (card.getSuit() == suit) {
                flushedCards.add(card);
            }
        }

        return flushedCards;
    }

    private final void addCardsWithValueToBestHand(int cardValue) {
        for (Card card : cards) {
            if (card.getValue() == cardValue) {
                bestHand.add(card);
            }
        }
    }

    private final ArrayList<Card> removeLowestCardsUntilFiveCardsRemain(ArrayList<Card> sortedCards) {
        while (sortedCards.size() > 5) {
            sortedCards.remove(0);
        }
        return sortedCards;
    }
}
