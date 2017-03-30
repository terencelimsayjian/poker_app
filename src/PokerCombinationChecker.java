import java.lang.reflect.Array;
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

        valueOccurrenceCount = BoardParser.getValueOccurrenceCount(this.cards);
        suitOccurrenceCount = BoardParser.getSuitOccurrenceCount(this.cards);

        hasFiveOrMoreOfSameSuit = BoardParser.hasFiveOrMoreOfSameSuit(suitOccurrenceCount);
        hasFiveOrMoreConsecutiveValues = BoardParser.hasFiveOrMoreConsecutiveValues(this.cards);
        hasFourOfAKind = BoardParser.countNumberOfCombinations(valueOccurrenceCount, 4) == 1;
        tripsCount = BoardParser.countNumberOfCombinations(valueOccurrenceCount, 3);
        pairCount = BoardParser.countNumberOfCombinations(valueOccurrenceCount, 2);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Card> getBestHand() {
        return bestHand;
    }


    public boolean isStraightFlush() {
        ArrayList<Card> flushCards = getFlushCards();
        return BoardParser.hasFiveOrMoreConsecutiveValues(flushCards);
    }

    public void getBestStraightFlush() {
        ArrayList<Card> straightFlushCards = getStraightCards(getFlushCards());

        while (straightFlushCards.size() > 5) {
            straightFlushCards.remove(0);
        }

        System.out.println(straightFlushCards.toString());
        bestHand.addAll(straightFlushCards);
    }

    public boolean isFourOfAKind() {
        return hasFourOfAKind;
    }

    public void getBestFourOfAKind() {
        int biggestQuadsCard = BoardParser.getHighestCardOfCombination(valueOccurrenceCount, 4);
        int biggestSingleCard = BoardParser.getHighestCardOfCombination(valueOccurrenceCount, 1);
        int index = 0;

        for (Card card : cards) {
            if (card.getValue() == biggestQuadsCard) {
                bestHand.add(index, card);
                index++;
            }
        }

        for (Card card : cards) {
            if (card.getValue() == biggestSingleCard) {
                bestHand.add(index, card);
                break;
            }
        }
    }

    public boolean isFullHouse() {
        return ((!hasFourOfAKind) &&
                ((tripsCount == 1) && (pairCount >= 1) || (tripsCount == 2)));
    }

    public void getBestFullHouse() {
        int biggestTripsCard = BoardParser.getHighestCardOfCombination(valueOccurrenceCount, 3);
        int biggestPairCard = BoardParser.getHighestCardOfCombination(valueOccurrenceCount, 2);
        int index = 0;

        for (Card card : cards) {
            if (card.getValue() == biggestTripsCard) {
                bestHand.add(index, card);
                index++;
            }
        }

        for (Card card : cards) {
            if (card.getValue() == biggestPairCard) {
                bestHand.add(index, card);
                index++;
            }
        }
    }

    public boolean isFlush() {
        return hasFiveOrMoreOfSameSuit && !hasFourOfAKind && !isFullHouse();
    }

    public ArrayList<Card> getFlushCards() {
        int flushedSuit = BoardParser.getFlushSuit(suitOccurrenceCount);
        ArrayList<Card> flushedCards = new ArrayList<Card>();

        for (Card card : cards) {
            if (card.getSuit() == flushedSuit) {
                flushedCards.add(card);
            }
        }

        return flushedCards;
    }

    public void getBestFlush() {
        ArrayList<Card> flushedCards = getFlushCards();

        while (flushedCards.size() > 5) {
            flushedCards.remove(0);
        }

        bestHand.addAll(0, flushedCards);
    }

    public boolean isStraight() {
        return !hasFiveOrMoreOfSameSuit && hasFiveOrMoreConsecutiveValues;
    }

    private int getStartingIndexForStraight(ArrayList<Card> sortedStraightCards) {
        int startingIndex = 7;

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

    private int getEndingIndexForStraight(ArrayList<Card> sortedStraightCards) {
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

    public ArrayList<Card> getStraightCards(ArrayList<Card> sortedStraightCards) {
        ArrayList<Card> consecutiveCards = new ArrayList<Card>();

        int firstCardInStraightIndex = getStartingIndexForStraight(sortedStraightCards);
        int lastCardInStraightIndex = getEndingIndexForStraight(sortedStraightCards);

        for (int i = firstCardInStraightIndex; i < lastCardInStraightIndex + 1; i++) {
            consecutiveCards.add(sortedStraightCards.get(i));
        }

        return consecutiveCards;
    }

    public void getBestStraight() {
        ArrayList<Card> consecutiveCards = getStraightCards(this.cards);

        while (consecutiveCards.size() > 5) {
            consecutiveCards.remove(0);
        }

        bestHand.addAll(consecutiveCards);
    }



//    public boolean isThreeOfAKind() {
//        return BoardParser.countNumberOfCombinations(3) == 1 && BoardParser.countNumberOfCombinations(2) == 0 && BoardParser.countNumberOfCombinations(4) == 0;
//    }
//
//    public boolean isTwoPair() {
//        return BoardParser.countNumberOfCombinations(2) >= 2 && BoardParser.countNumberOfCombinations(3) == 0;
//    }

    /*cd
    *
    * Quads - boolean
    * Trips count
    * Pair count
    *
    * straight flush
    * four of a kind
    * full house
    * flush
    * straight
    * three of a kind
    * two pair
    * pair
    * high card
    *
    * */

}
