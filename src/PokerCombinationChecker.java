import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by littletinyhippo on 26/3/17.
 */
public class PokerCombinationChecker {
    private ArrayList<Card> cards = new ArrayList<>(7);

    public PokerCombinationChecker(ArrayList<Card> board, ArrayList<Card> hand) {
        this.cards.addAll(0, board);
        this.cards.addAll(5, hand);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Map<Integer, Integer> getValueOccurenceCount() {
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

    public Map<Integer, Integer> getSuitOccurenceCount() {
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
        Map<Integer, Integer> valueOccurenceCount = getValueOccurenceCount();

        for (Map.Entry<Integer, Integer> entry : valueOccurenceCount.entrySet()) {
            if (entry.getValue() >= 4) {
                isFourOfAKind = true;
            }
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        return isFourOfAKind;
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
