import java.util.*;

public class PokerCombinationChecker {
    private ArrayList<Card> cards = new ArrayList<Card>(7);
    private ArrayList<Card> bestHand = new ArrayList<Card>(5);

    private boolean hasFiveOrMoreConsecutiveValues;
    private boolean hasFiveOrMoreOfSameSuit;
    private boolean hasFourOfAKind;
    private int tripsCount;
    private int pairCount;

    private Map<Integer, Integer> valueOccurrenceCount;
    private Map<Integer, Integer> suitOccurrenceCount;

    /*
    * Result:
    * bestHand
    * string
    * hand rank
    * card rank
    * */

    public PokerCombinationChecker(ArrayList<Card> board, ArrayList<Card> hand) {
        this.cards.addAll(0, board);
        this.cards.addAll(5, hand);

        valueOccurrenceCount = getValueOccurrenceCount();
        suitOccurrenceCount = getSuitOccurrenceCount();

        hasFiveOrMoreOfSameSuit = hasFiveOrMoreOfSameSuit();
        hasFiveOrMoreConsecutiveValues = hasFiveOrMoreConsecutiveValues();
        hasFourOfAKind = countXOfAKind(4) == 1;
        tripsCount = countXOfAKind(3);
        pairCount = countXOfAKind(2);
    }

    public ArrayList<Card> getCards() {
        return cards;
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

    private int countXOfAKind(int x) {
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

    private boolean hasFiveOrMoreOfSameSuit() {
        boolean isFlush = false;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                isFlush = true;
            }
        }

        return isFlush;
    }

    private boolean hasFiveOrMoreConsecutiveValues() {
        int consecutiveCardCount = 0;
        boolean isStraight = false;

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.addAll(this.cards);

        Collections.sort(cards);

        for (int i = 0; i < 5; i++) {
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



    public ArrayList<Card> getBestHand() {
        return bestHand;
    }

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

    public void getBestFlush() {
        int flushedSuit = getFlushSuit();
        ArrayList<Card> flushedCards = new ArrayList<Card>();

        for (Card card : cards) {
            if (card.getSuit() == flushedSuit) {
                flushedCards.add(card);
            }
        }

        Collections.sort(flushedCards);

        while (flushedCards.size() > 5) {
            flushedCards.remove(0);
        }

        bestHand.addAll(0, flushedCards);
    }

    public boolean isThreeOfAKind() {
        return countXOfAKind(3) == 1 && countXOfAKind(2) == 0 && countXOfAKind(4) == 0;
    }

    public boolean isTwoPair() {
        return countXOfAKind(2) >= 2 && countXOfAKind(3) == 0;
    }

    /*cd
    * Check if
    *
    * State variables
    * flush: boolean
    * straight: boolean
    * quads: boolean
    * tripsCount: int
    * pairCount: int
    *
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
