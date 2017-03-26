import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        boolean trips = false;
        boolean pair = false;

        for (Map.Entry<Integer, Integer> entry : valueOccurenceCount.entrySet()) {
            if (entry.getValue() == 3) {
                trips = true;
            }

            if (entry.getValue() == 2) {
                pair = true;
            }
        }

        return trips & pair;
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



    /*
    * Check if
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
