import java.util.*;

public class PokerCombinationChecker {
    private ArrayList<Card> cards = new ArrayList<Card>(7);
    private ArrayList<Card> bestHand = new ArrayList<Card>(5);

    private Map<Integer, Integer> valueOccurenceCount;
    private Map<Integer, Integer> suitOccurenceCount;

    public PokerCombinationChecker(ArrayList<Card> board, ArrayList<Card> hand) {
        this.cards.addAll(0, board);
        this.cards.addAll(5, hand);

        valueOccurenceCount = getValueOccurenceCount();
        suitOccurenceCount = getSuitOccurenceCount();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    private Map<Integer, Integer> getValueOccurenceCount() {
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

    private Map<Integer, Integer> getSuitOccurenceCount() {
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

    // two people with same quads on the board, high card wins
    // Two people hit quads, higher quads wins
    // Still need to return the five winning cards
    public boolean isFourOfAKind() {
        boolean isFourOfAKind = false;

        for (Map.Entry<Integer, Integer> entry : valueOccurenceCount.entrySet()) {
            if (entry.getValue() == 4) {
                isFourOfAKind = true;
            }
        }

        return isFourOfAKind;
    }

    // Need to identify the bigger trips to use
    // Need to identify the bigger pair to use
    public boolean isFullHouse() {
        return ((countXOfAKind(3) == 1) && (countXOfAKind(2) == 1) ||
                (countXOfAKind(3) == 2));

    }

    public boolean isFlush() {
        boolean isFlush = false;

        for (Map.Entry<Integer, Integer> entry : suitOccurenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                isFlush = true;
            }
        }

        return isFlush;
    }

    // 10 through Ace straight
    public boolean isStraight() {
        int consecutiveCardCount = 0;
        boolean isStraight = false;

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.addAll(this.cards);

        Collections.sort(cards);

        System.out.println(cards.toString());

        for (int i = 0; i < 5; i++) {
            Card currentCard = cards.get(i);
            Card nextCard = cards.get(i + 1);
            Card followingCard = cards.get(i + 2);

            if ((currentCard.getValue() == nextCard.getValue() - 1) & (nextCard.getValue() == followingCard.getValue() - 1)) {
                System.out.println(currentCard.toString());
                consecutiveCardCount++;
            }
        }

        if (consecutiveCardCount >= 3) {
            isStraight = true;
        }

        return isStraight;
    }

    private int countXOfAKind(int x) {
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : valueOccurenceCount.entrySet()) {
            if (entry.getValue() == x) {
                count++;
            }
        }

        return count;
    }

    /*
    * Check if
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
