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
            getBestStraightFlush();
        } else if (isFourOfAKind()) {
            getBestFourOfAKind();
        } else if (isFullHouse()) {
            getBestFullHouse();
        } else if (isFlush()) {
            getBestFlush();
        } else if (isStraight()) {
            getBestStraight();
        } else if (isThreeOfAKind()) {
            getBestThreeOfAKind();
        } else if (isTwoPair()) {
            getBestTwoPair();
        } else if (isPair()) {
            getBestPair();
        } else if (isHighCard()) {
            getBestHighCard();
        }
    }

    public boolean isStraightFlush() {
        boolean isStraightFlush = false;

        if (hasFiveOrMoreOfSameSuit) {
            int flushedSuit = cardSuitAnalyser.getFlushSuit();
            ArrayList<Card> flushCards = getCardsOfASuit(this.cards, flushedSuit);
            isStraightFlush = hasFiveOrMoreConsecutiveValues(flushCards);
        }

        return isStraightFlush;
    }

    public void getBestStraightFlush() {
        int flushedSuit = cardSuitAnalyser.getFlushSuit();
        ArrayList<Card> straightFlushCards = getStraightCards(getCardsOfASuit(this.cards, flushedSuit));

        removeLowestCardsUntilFiveCardsRemain(straightFlushCards);
        bestHand.addAll(straightFlushCards);
    }
    // TODO: Take ACE straight into account
    // TODO: Rename - Doesn't 'get' anything

    public boolean isFourOfAKind() {
        return hasFourOfAKind;
    }

    public void getBestFourOfAKind() {
        int biggestFourOfAKindCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.FOUR_OF_A_KIND);
        int biggestSingleCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.SINGLE_CARD);

        addCardsWithValueToBestHand(biggestFourOfAKindCardValue);
        addCardsWithValueToBestHand(biggestSingleCardValue);
    }


    public boolean isFullHouse() {
        return ((!hasFourOfAKind) &&
                ((tripsCount == 1) && (pairCount >= 1) || (tripsCount == 2)));
    }

    public void getBestFullHouse() {
        int biggestThreeOfAKindCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.THREE_OF_A_KIND);
        int biggestPairCardValue = cardValueAnalyser.getHighestCardOfCombination(CardValueAnalyser.PAIR);

        addCardsWithValueToBestHand(biggestThreeOfAKindCardValue);
        addCardsWithValueToBestHand(biggestPairCardValue);
    }


    public boolean isFlush() {
        return hasFiveOrMoreOfSameSuit && !hasFourOfAKind && !isFullHouse();
    }

    public void getBestFlush() {
        int flushedSuit = cardSuitAnalyser.getFlushSuit();
        ArrayList<Card> flushedCards = getCardsOfASuit(this.cards, flushedSuit);

        removeLowestCardsUntilFiveCardsRemain(flushedCards);
        bestHand.addAll(flushedCards);
    }


    public boolean isStraight() {
        return !hasFiveOrMoreOfSameSuit && hasFiveOrMoreConsecutiveValues;
    }

    public void getBestStraight() {
        ArrayList<Card> consecutiveCards = getStraightCards(this.cards);

        removeLowestCardsUntilFiveCardsRemain(consecutiveCards);
        bestHand.addAll(consecutiveCards);
    }


    public boolean isThreeOfAKind() {
        return !hasFiveOrMoreOfSameSuit && !hasFiveOrMoreConsecutiveValues
                && !hasFourOfAKind && (tripsCount == 1) && pairCount == 0;
    }

    public void getBestThreeOfAKind() {
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

    public void getBestTwoPair() {
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

    public void getBestPair() {
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

    public void getBestHighCard() {
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

    // Straight methods
    private final int getStartingIndexForStraight(ArrayList<Card> sortedStraightCards) {
        int startingIndex = 0;

        for (int i = 0; i <= 2; i++) {
            Card currentCard = sortedStraightCards.get(i);
            Card secondCard = sortedStraightCards.get(i + 1);
            Card thirdCard = sortedStraightCards.get(i + 2);

            if ((currentCard.getValue() == secondCard.getValue() - 1) && (secondCard.getValue() == thirdCard.getValue() - 1)) {
                startingIndex = i;
                break;
            }
        }
        return startingIndex;
    }

    private final int getEndingIndexForStraight(ArrayList<Card> sortedStraightCards) {
        int endingIndex = 0;
        int lastCardIndex = sortedStraightCards.size() - 1;

        Card thirdLastCard = sortedStraightCards.get(lastCardIndex - 2);
        Card secondLastCard = sortedStraightCards.get(lastCardIndex - 1);
        Card lastCard = sortedStraightCards.get(lastCardIndex);

        if (lastCard.getValue() == secondLastCard.getValue() + 1) {
            endingIndex = lastCardIndex;
        } else if (secondLastCard.getValue() == thirdLastCard.getValue() + 1) {
            endingIndex = lastCardIndex - 1;
        } else {
            endingIndex = lastCardIndex - 2;
        }

        return endingIndex;
    }

    private final ArrayList<Card> getStraightCards(ArrayList<Card> sortedStraightCards) {
        ArrayList<Card> straightCards = new ArrayList<Card>();

        if (hasFiveOrMoreConsecutiveValuesExcludingStartingWithAce(sortedStraightCards)) {
            straightCards.addAll(getStraightCardsNotStartingWithAce(sortedStraightCards));
        } else if (hasFiveOrMoreConsecutiveValuesStartingWithAce(sortedStraightCards)) {
            straightCards.addAll(getStraightCardsStartingWithAce(sortedStraightCards));
        }

        return straightCards;
    }

    private ArrayList<Card> getStraightCardsNotStartingWithAce(ArrayList<Card> sortedStraightCards) {
        ArrayList<Card> consecutiveCards = new ArrayList<Card>();

        int firstCardInStraightIndex = getStartingIndexForStraight(sortedStraightCards);
        int lastCardInStraightIndex = getEndingIndexForStraight(sortedStraightCards);

        for (int i = firstCardInStraightIndex; i < lastCardInStraightIndex + 1; i++) {
            consecutiveCards.add(sortedStraightCards.get(i));
        }

        return consecutiveCards;
    }

    private ArrayList<Card> getStraightCardsStartingWithAce(ArrayList<Card> sortedStraightCards) {
        // Assumes A+ straight exists => Hence Only need to deal with cards[5] and cards[6]
        ArrayList<Card> cardsWithoutDuplicates = removeValueDuplicates(sortedStraightCards);

        ArrayList<Card> consecutiveCards = new ArrayList<Card>();

        for (int i = 0; i <= 3; i++) {
            consecutiveCards.add(cardsWithoutDuplicates.get(i));
        }

        for (int i = 4; i < cardsWithoutDuplicates.size() - 1; i++) {
            Card previousCard = cardsWithoutDuplicates.get(i - 1);
            Card currentCard = cardsWithoutDuplicates.get(i);

            if (currentCard.getValue() == previousCard.getValue() + 1) {
                consecutiveCards.add(currentCard);
            } else {
                // break to avoid consecutive cards such as 9, 10
                break;
            }
        }

        consecutiveCards.add(cardsWithoutDuplicates.get(cardsWithoutDuplicates.size() - 1));

        return consecutiveCards;
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


    // Helper methods
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

    private final ArrayList<Card> removeValueDuplicates(ArrayList<Card> sortedCards) {
        ArrayList<Card> cardsWithoutDuplicates = new ArrayList<Card>();

        cardsWithoutDuplicates.add(sortedCards.get(0));

        for (int i = 1; i < sortedCards.size(); i++) {
            Card previousCard = sortedCards.get(i - 1);
            Card currentCard = sortedCards.get(i);

            if (currentCard.getValue() != previousCard.getValue()) {
                cardsWithoutDuplicates.add(currentCard);
            }
        }

        return cardsWithoutDuplicates;
    }


    // Setup methods
    private final boolean hasFiveOrMoreConsecutiveValues(ArrayList<Card> sortedCards) {
        return hasFiveOrMoreConsecutiveValuesExcludingStartingWithAce(sortedCards) || hasFiveOrMoreConsecutiveValuesStartingWithAce(sortedCards);
    }

    private final boolean hasFiveOrMoreConsecutiveValuesExcludingStartingWithAce(ArrayList<Card> sortedCards) {
        ArrayList<Card> cardsWithoutDuplicates = removeValueDuplicates(sortedCards);

        int consecutiveCardCount = 0;
        boolean isStraight = false;

        int indexOfThirdLastCard = cardsWithoutDuplicates.size() - 3;

        for (int i = 0; i <= indexOfThirdLastCard; i++) {
            Card currentCard = cardsWithoutDuplicates.get(i);
            Card nextCard = cardsWithoutDuplicates.get(i + 1);
            Card followingCard = cardsWithoutDuplicates.get(i + 2);

            if ((currentCard.getValue() == nextCard.getValue() - 1) &&
                    (nextCard.getValue() == followingCard.getValue() - 1)) {
                consecutiveCardCount++;
            }
        }

        if (consecutiveCardCount >= 3) {
            isStraight = true;
        }

        return isStraight;
    }

    private final boolean hasFiveOrMoreConsecutiveValuesStartingWithAce(ArrayList<Card> sortedCards) {
        ArrayList<Card> cardsWithoutDuplicates = removeValueDuplicates(sortedCards);

        boolean lastCardIsAnAce = (cardsWithoutDuplicates.get(cardsWithoutDuplicates.size() - 1).isAce());

        if (!lastCardIsAnAce) { return false; }

        boolean isStraightStartingWithAce = true;

        int currentValueInStraight = 2;
        for (int i = 0; i < 4; i++) {
            if (cardsWithoutDuplicates.get(i).getValue() != currentValueInStraight) {
                isStraightStartingWithAce = false;
                // Break also avoids exceeding sortedCards size in the case of many duplicates
                break;
            }
            currentValueInStraight++;
        }

        return isStraightStartingWithAce;
    }

}
