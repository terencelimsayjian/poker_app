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

        Collections.sort(cards);

        valueOccurrenceCount = getValueOccurrenceCount();
        suitOccurrenceCount = getSuitOccurrenceCount();

        hasFiveOrMoreOfSameSuit = hasFiveOrMoreOfSameSuit();
        hasFiveOrMoreConsecutiveValues = hasFiveOrMoreConsecutiveValues(this.cards);
        hasFourOfAKind = countRepeatsOfOccurrences(4) == 1;
        tripsCount = countRepeatsOfOccurrences(3);
        pairCount = countRepeatsOfOccurrences(2);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Card> getBestHand() {
        return bestHand;
    }


    private Map<Integer, Integer> getValueOccurrenceCount() {
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

    private Map<Integer, Integer> getSuitOccurrenceCount() {
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

    private int getHighestCardOfCombination(int x) {
        int highestCard = 0;

        for (Map.Entry<Integer, Integer> entry : valueOccurrenceCount.entrySet()) {
            if (entry.getValue() == x) {
                if (entry.getKey() > highestCard) {
                    highestCard = entry.getKey();
                }
            }
        }

        return highestCard;
    }

    private int countRepeatsOfOccurrences(int x) {
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : valueOccurrenceCount.entrySet()) {
            if (entry.getValue() == x) {
                count++;
            }
        }

        return count;
    }

    private int getFlushSuit() {
        int suit = 0;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                suit = entry.getKey();
                break;
            }
        }

        return suit;
    }

    private int getStartingIndexForStraight() {
        int startingIndex = 7;

        for (int i = 0; i <= 2; i++) {
            Card currentCard = cards.get(i);
            Card secondCard = cards.get(i + 1);
            Card thirdCard = cards.get(i + 2);

            if ((currentCard.getValue() == secondCard.getValue() - 1) && (secondCard.getValue() == thirdCard.getValue() - 1)) {
                startingIndex = i;
                break;
            }
        }
        return startingIndex;
    }

    private int getEndingIndexForStraight(int startingIndex) {
        int endingIndex = 0;

        Card c5 = cards.get(4);
        Card c6 = cards.get(5);
        Card c7 = cards.get(6);

        if (c7.getValue() == c6.getValue() + 1) {
            endingIndex = 6;
        } else if (c6.getValue() == c5.getValue() + 1) {
            endingIndex = 5;
        } else {
            endingIndex = 4;
        }

        return endingIndex;
    }

    private boolean hasFiveOrMoreOfSameSuit() {
        boolean isFlush = false;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                isFlush = true;
            }
        }

        return isFlush;
    }

    private boolean hasFiveOrMoreConsecutiveValues(ArrayList<Card> cards) {
        int consecutiveCardCount = 0;
        boolean isStraight = false;
        int indexOfThirdLastCard = cards.size() - 2;

        for (int i = 0; i < indexOfThirdLastCard; i++) {
            Card currentCard = cards.get(i);
            Card nextCard = cards.get(i + 1);
            Card followingCard = cards.get(i + 2);

            if ((currentCard.getValue() == nextCard.getValue() - 1) & (nextCard.getValue() == followingCard.getValue() - 1)) {
                consecutiveCardCount++;
            }
        }

        if (consecutiveCardCount >= 3) {
            isStraight = true;
        }

        return isStraight;
    }


    public boolean isStraightFlush() {
        ArrayList<Card> flushCards = getFlushCards();
        return hasFiveOrMoreConsecutiveValues(flushCards);
    }

//    public boolean getBestStraightFlush() {
//
//    }

    public boolean isFourOfAKind() {
        return hasFourOfAKind;
    }

    public void getBestFourOfAKind() {
        int biggestQuadsCard = getHighestCardOfCombination(4);
        int biggestSingleCard = getHighestCardOfCombination(1);
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
        int biggestTripsCard = getHighestCardOfCombination(3);
        int biggestPairCard = getHighestCardOfCombination(2);
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
        int flushedSuit = getFlushSuit();
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

    public ArrayList<Card> getStraightCards() {
        ArrayList<Card> consecutiveCards = new ArrayList<Card>();
        int firstCardInStraightIndex = getStartingIndexForStraight();
        int lastCardInStraightIndex = getEndingIndexForStraight(firstCardInStraightIndex);

        for (int i = firstCardInStraightIndex; i < lastCardInStraightIndex + 1; i++) {
            consecutiveCards.add(cards.get(i));
        }

        return consecutiveCards;
    }

    public void getBestStraight() {
        ArrayList<Card> consecutiveCards = getStraightCards();

        while (consecutiveCards.size() > 5) {
            consecutiveCards.remove(0);
        }

        bestHand.addAll(consecutiveCards);
    }



//    public boolean isThreeOfAKind() {
//        return countRepeatsOfOccurrences(3) == 1 && countRepeatsOfOccurrences(2) == 0 && countRepeatsOfOccurrences(4) == 0;
//    }
//
//    public boolean isTwoPair() {
//        return countRepeatsOfOccurrences(2) >= 2 && countRepeatsOfOccurrences(3) == 0;
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
