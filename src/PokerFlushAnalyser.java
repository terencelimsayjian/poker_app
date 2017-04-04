import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PokerFlushAnalyser {
    private Map<Integer, Integer> suitOccurrenceCount;
    private ArrayList<Card> cards;
    private ArrayList<Card> bestMadeFlush = new ArrayList<Card>();

    public PokerFlushAnalyser(ArrayList<Card> cards) {
        Collections.sort(cards);
        this.cards = cards;

        suitOccurrenceCount =  getSuitOccurrenceCount(cards);
        addTopFiveFlushCardsToBestMadeFlush();
    }

    // TODO: Get ALL flush cards for use in the straight flush algo

    public ArrayList<Card> getBestMadeFlush() {
        return bestMadeFlush;
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

    private void addTopFiveFlushCardsToBestMadeFlush() {
        int flushedSuit = getFlushSuit();

        for (int i = cards.size() - 1; i >= 0; i--) {
            Card currentCard = cards.get(i);

            if (currentCard.getSuit() == flushedSuit && bestMadeFlush.size() < 5) {
                getBestMadeFlush().add(currentCard);
            }
        }
    }


}

