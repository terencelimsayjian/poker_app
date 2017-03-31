import java.util.*;

public class PokerCombinationChecker {
    private ArrayList<Card> cards = new ArrayList<Card>(7);

    private ArrayList<Card> bestHand = new ArrayList<Card>(5);
    /*
    * Result:
    * bestHand
    * string
    * hand rank (1-9)
    * card rank (Sum of cards (and defining characteristic, trips bigger etc)
    * */

    private static final int SINGLE_CARD = 1;
    private static final int PAIR = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int FOUR_OF_A_KIND = 4;


    private Map<Integer, Integer> valueOccurrenceCount;
    private Map<Integer, Integer> suitOccurrenceCount;

    private boolean hasFiveOrMoreConsecutiveValues;
    private boolean hasFiveOrMoreOfSameSuit;
    private boolean hasFourOfAKind;
    private int tripsCount;
    private int pairCount;

    public PokerCombinationChecker(ArrayList<Card> board, ArrayList<Card> hand) {
        this.cards.addAll(0, board);
        this.cards.addAll(5, hand);

        Collections.sort(this.cards);

        valueOccurrenceCount = getValueOccurrenceCount(this.cards);
        suitOccurrenceCount = getSuitOccurrenceCount(this.cards);

        hasFiveOrMoreOfSameSuit = hasFiveOrMoreOfSameSuit(suitOccurrenceCount);
        hasFiveOrMoreConsecutiveValues = hasFiveOrMoreConsecutiveValues(this.cards);
        hasFourOfAKind = countNumberOfCombinations(valueOccurrenceCount, FOUR_OF_A_KIND) == 1;
        tripsCount = countNumberOfCombinations(valueOccurrenceCount, THREE_OF_A_KIND);
        pairCount = countNumberOfCombinations(valueOccurrenceCount, PAIR);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Card> getBestHand() {
        return bestHand;
    }


    public boolean isStraightFlush() {
        boolean isStraightFlush = false;

        if (hasFiveOrMoreOfSameSuit) {
            int flushedSuit = getFlushSuit(suitOccurrenceCount);
            ArrayList<Card> flushCards = getCardsOfASuit(this.cards, flushedSuit);
            isStraightFlush = hasFiveOrMoreConsecutiveValues(flushCards);
        }

        return isStraightFlush;
    }

    public void getBestStraightFlush() {
        int flushedSuit = getFlushSuit(suitOccurrenceCount);
        ArrayList<Card> straightFlushCards = getStraightCards(getCardsOfASuit(this.cards, flushedSuit));

        removeLowestCardsUntilFiveCardsRemain(straightFlushCards);
        bestHand.addAll(straightFlushCards);
    }


    public boolean isFourOfAKind() {
        return hasFourOfAKind;
    }

    public void getBestFourOfAKind() {
        int biggestFourOfAKindCardValue = getHighestCardOfCombination(valueOccurrenceCount, FOUR_OF_A_KIND);
        int biggestSingleCardValue = getHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD);

        addCardsWithValueToBestHand(biggestFourOfAKindCardValue);
        addCardsWithValueToBestHand(biggestSingleCardValue);
    }


    public boolean isFullHouse() {
        return ((!hasFourOfAKind) &&
                ((tripsCount == 1) && (pairCount >= 1) || (tripsCount == 2)));
    }

    public void getBestFullHouse() {
        int biggestThreeOfAKindCardValue = getHighestCardOfCombination(valueOccurrenceCount, THREE_OF_A_KIND);
        int biggestPairCardValue = getHighestCardOfCombination(valueOccurrenceCount, PAIR);

        addCardsWithValueToBestHand(biggestThreeOfAKindCardValue);
        addCardsWithValueToBestHand(biggestPairCardValue);
    }


    public boolean isFlush() {
        return hasFiveOrMoreOfSameSuit && !hasFourOfAKind && !isFullHouse();
    }

    public void getBestFlush() {
        int flushedSuit = getFlushSuit(suitOccurrenceCount);
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
        int highestThreeOfAKind = getHighestCardOfCombination(valueOccurrenceCount,THREE_OF_A_KIND);
        int highestCard = getHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD);
        int secondHighestCard = getNextHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD, highestCard);

        addCardsWithValueToBestHand(7);
        addCardsWithValueToBestHand(highestCard);
        addCardsWithValueToBestHand(secondHighestCard);
    }


    public boolean isTwoPair() {
        return (!hasFiveOrMoreConsecutiveValues && !hasFiveOrMoreOfSameSuit && !hasFourOfAKind &&
                tripsCount == 0 & pairCount == 2);
    }

    public void getBestTwoPair() {
        int highestPairCardValue = getHighestCardOfCombination(valueOccurrenceCount, PAIR);
        int secondHighestPairCardValue = getNextHighestCardOfCombination(valueOccurrenceCount, PAIR, highestPairCardValue);
        int highestSingleCardValue = getHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD);

        addCardsWithValueToBestHand(highestPairCardValue);
        addCardsWithValueToBestHand(secondHighestPairCardValue);
        addCardsWithValueToBestHand(highestSingleCardValue);
    }


    public boolean isPair() {
        return (!hasFiveOrMoreConsecutiveValues && !hasFiveOrMoreOfSameSuit && !hasFourOfAKind &&
                tripsCount == 0 & pairCount == 1);
    }

    public void getBestPair() {
        int highestPairCardValue = getHighestCardOfCombination(valueOccurrenceCount, PAIR);

        int highestSingleCardValue = getHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD);
        int secondHighestSingleCardValue = getNextHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD, highestSingleCardValue);
        int thirdHighestSingleCardValue = getNextHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD, secondHighestSingleCardValue);

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
        int highestSingleCardValue = getHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD);
        int secondHighestSingleCardValue = getNextHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD, highestSingleCardValue);
        int thirdHighestSingleCardValue = getNextHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD, secondHighestSingleCardValue);
        int fourthHighestSingleCardValue = getNextHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD, thirdHighestSingleCardValue);
        int fifthHighestSingleCardValue = getNextHighestCardOfCombination(valueOccurrenceCount, SINGLE_CARD, fourthHighestSingleCardValue);

        addCardsWithValueToBestHand(highestSingleCardValue);
        addCardsWithValueToBestHand(secondHighestSingleCardValue);
        addCardsWithValueToBestHand(thirdHighestSingleCardValue);
        addCardsWithValueToBestHand(fourthHighestSingleCardValue);
        addCardsWithValueToBestHand(fifthHighestSingleCardValue);
    }

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
        ArrayList<Card> consecutiveCards = new ArrayList<Card>();

        int firstCardInStraightIndex = getStartingIndexForStraight(sortedStraightCards);
        int lastCardInStraightIndex = getEndingIndexForStraight(sortedStraightCards);

        for (int i = firstCardInStraightIndex; i < lastCardInStraightIndex + 1; i++) {
            consecutiveCards.add(sortedStraightCards.get(i));
        }

        return consecutiveCards;
    }

    // have another function which gets ace straight cards
    // create a third function that calls the original two functions.
    // getBestStraight removes cards from beginning. This will be a problem for 23456A

    private final ArrayList<Card> getCardsOfASuit(ArrayList<Card> cards, int suit) {
        ArrayList<Card> flushedCards = new ArrayList<Card>();

        for (Card card : cards) {
            if (card.getSuit() == suit) {
                flushedCards.add(card);
            }
        }

        return flushedCards;
    }


    private final int getFlushSuit(Map<Integer, Integer> suitOccurrenceCount) {
        int suit = 0;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                suit = entry.getKey();
                break;
            }
        }

        return suit;
    }

    private final int getHighestCardOfCombination(Map<Integer, Integer> valueOccurrenceCount, int combination) {
        int highestCard = 0;

        for (Map.Entry<Integer, Integer> entry : valueOccurrenceCount.entrySet()) {
            if (entry.getValue() == combination) {
                if (entry.getKey() > highestCard) {
                    highestCard = entry.getKey();
                }
            }
        }

        return highestCard;
    }

    private final int getNextHighestCardOfCombination(Map<Integer, Integer> valueOccurrenceCount, int combination, int highCard) {
        int highestCard = highCard;
        int secondHighestCard = 0;

        for (Map.Entry<Integer, Integer> entry : valueOccurrenceCount.entrySet()) {
            if (entry.getValue() == combination) {
                if (entry.getKey() < highestCard && entry.getKey() > secondHighestCard) {
                    secondHighestCard = entry.getKey();
                }
            }
        }

        return secondHighestCard;
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


    private final Map<Integer, Integer> getValueOccurrenceCount(ArrayList<Card> cards) {
        Map<Integer, Integer> occurrenceMap = new HashMap<Integer, Integer>();

        for (Card card : cards) {
            Integer numOccurrence = occurrenceMap.get(card.getValue());

            if(numOccurrence == null){
                occurrenceMap.put(card.getValue(), 1);
            } else {
                occurrenceMap.put(card.getValue(), ++numOccurrence);
            }
        }
        return occurrenceMap;
    }

    private final Map<Integer, Integer> getSuitOccurrenceCount(ArrayList<Card> cards) {
        Map<Integer, Integer> occurrenceMap = new HashMap<Integer, Integer>();

        for (Card card : cards) {
            Integer numOccurrence = occurrenceMap.get(card.getSuit());

            if(numOccurrence == null){
                occurrenceMap.put(card.getSuit(), 1);
            } else {
                occurrenceMap.put(card.getSuit(), ++numOccurrence);
            }
        }

        return occurrenceMap;
    }

    private final int countNumberOfCombinations(Map<Integer, Integer> valueOccurrenceCount, int combination) {
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : valueOccurrenceCount.entrySet()) {
            if (entry.getValue() == combination) {
                count++;
            }
        }

        return count;
    }

    private final boolean hasFiveOrMoreOfSameSuit(Map<Integer, Integer> suitOccurrenceCount) {
        boolean isFlush = false;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                isFlush = true;
            }
        }

        return isFlush;
    }

    private final boolean hasFiveOrMoreConsecutiveValues(ArrayList<Card> sortedCards) {
        return hasStraightNotStartingWithAce(sortedCards) || hasStraightStartingWithAce(sortedCards);
    }

    private final boolean hasStraightNotStartingWithAce(ArrayList<Card> sortedCards) {
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

    private final boolean hasStraightStartingWithAce(ArrayList<Card> sortedCards) {
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

    private ArrayList<Card> removeValueDuplicates(ArrayList<Card> sortedCards) {
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

}
