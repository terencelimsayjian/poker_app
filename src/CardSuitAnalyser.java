import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardSuitAnalyser {
    private Map<Integer, Integer> suitOccurrenceCount;

    public CardSuitAnalyser(ArrayList<Card> cards) {
        suitOccurrenceCount =  getSuitOccurrenceCount(cards);
    }

    private final Map<Integer, Integer> getSuitOccurrenceCount(ArrayList<Card> cards) {
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

    public boolean hasFiveOrMoreOfTheSameSuit() {
        boolean hasFiveOrMoreOfTheSameSuit = false;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                hasFiveOrMoreOfTheSameSuit = true;
            }
        }

        return hasFiveOrMoreOfTheSameSuit;
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

