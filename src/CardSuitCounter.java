import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CardSuitCounter {
    private Map<Integer, Integer> suitOccurrenceCount;
    private ArrayList<Card> cards;

    public CardSuitCounter(ArrayList<Card> cards) {
        Collections.sort(cards);
        this.cards = cards;

        suitOccurrenceCount =  getSuitOccurrenceCount(cards);
    }

    private Map<Integer, Integer> getSuitOccurrenceCount(ArrayList<Card> cards) {
        Map<Integer, Integer> suitOccurrenceMap = new HashMap<Integer, Integer>();

        for (Card card : cards) {
            Integer numOccurrence = suitOccurrenceMap.get(card.getSuit());

            if(numOccurrence == null){
                suitOccurrenceMap.put(card.getSuit(), 1);
            } else {
                suitOccurrenceMap.put(card.getSuit(), ++numOccurrence);
            }
        }

        return suitOccurrenceMap;
    }

    public int getHighestOccurrenceOfAnySuit() {
        int highestOccurrence = 0;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() > highestOccurrence) {
                highestOccurrence = entry.getValue();
            }
        }
        return highestOccurrence;
    }

    public int getFlushSuit() {
        int suit = 0;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                suit = entry.getKey();
                break;
            }
        }

        return suit;
    }

}

