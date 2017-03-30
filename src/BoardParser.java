import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class BoardParser {
    public final static Map<Integer, Integer> getValueOccurrenceCount(ArrayList<Card> cards) {
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

    public final static Map<Integer, Integer> getSuitOccurrenceCount(ArrayList<Card> cards) {
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

    public final static int getHighestCardOfCombination(Map<Integer, Integer> valueOccurrenceCount, int x) {
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

    public final static int countNumberOfCombinations(Map<Integer, Integer> valueOccurrenceCount, int x) {
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : valueOccurrenceCount.entrySet()) {
            if (entry.getValue() == x) {
                count++;
            }
        }

        return count;
    }

    public final static int getFlushSuit(Map<Integer, Integer> suitOccurrenceCount) {
        int suit = 0;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                suit = entry.getKey();
                break;
            }
        }

        return suit;
    }

    public final static boolean hasFiveOrMoreOfSameSuit(Map<Integer, Integer> suitOccurrenceCount) {
        boolean isFlush = false;

        for (Map.Entry<Integer, Integer> entry : suitOccurrenceCount.entrySet()) {
            if (entry.getValue() >= 5) {
                isFlush = true;
            }
        }

        return isFlush;
    }

    public final static boolean hasFiveOrMoreConsecutiveValues(ArrayList<Card> sortedCards) {
        int consecutiveCardCount = 0;
        boolean isStraight = false;
        int indexOfThirdLastCard = sortedCards.size() - 2;

        for (int i = 0; i < indexOfThirdLastCard; i++) {
            Card currentCard = sortedCards.get(i);
            Card nextCard = sortedCards.get(i + 1);
            Card followingCard = sortedCards.get(i + 2);

            if ((currentCard.getValue() == nextCard.getValue() - 1) & (nextCard.getValue() == followingCard.getValue() - 1)) {
                consecutiveCardCount++;
            }
        }

        if (consecutiveCardCount >= 3) {
            isStraight = true;
        }

        return isStraight;
    }
}
