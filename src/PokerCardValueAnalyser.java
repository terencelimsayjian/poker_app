import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PokerCardValueAnalyser {
    private Map<Integer, Integer> valueOccurrenceCount;

    public static final int SINGLE_CARD = 1;
    public static final int PAIR = 2;
    public static final int THREE_OF_A_KIND = 3;
    public static final int FOUR_OF_A_KIND = 4;

    public PokerCardValueAnalyser(ArrayList<Card> cards) {
        valueOccurrenceCount = getValueOccurrenceCount(cards);
    }

    private Map<Integer, Integer> getValueOccurrenceCount(ArrayList<Card> cards) {
        Map<Integer, Integer> valueOccurrenceMap = new HashMap<Integer, Integer>();

        for (Card card : cards) {
            Integer numOccurrence = valueOccurrenceMap.get(card.getValue());

            if(numOccurrence == null){
                valueOccurrenceMap.put(card.getValue(), 1);
            } else {
                valueOccurrenceMap.put(card.getValue(), ++numOccurrence);
            }
        }

        return valueOccurrenceMap;
    }

    public int countCombinations(int combination) {
         int count = 0;

         for (Map.Entry<Integer, Integer> entry : valueOccurrenceCount.entrySet()) {
             if (entry.getValue() == combination) {
                 count++;
             }
         }

         return count;
     }

    public int getHighestCardOfCombination(int combination) {
         int highestCard = 0;

         for (Map.Entry<Integer, Integer> entry : valueOccurrenceCount.entrySet()) {
             if (entry.getValue() == combination) {
                 if (entry.getKey() > highestCard) {
                     highestCard = entry.getKey();
                 }
             }
         }

         return highestCard;
     }

    public int getNextHighestCardOfCombination(int combination, int highCard) {
        int highestCard = highCard;
        int secondHighestCard = 0;

        for (Map.Entry<Integer, Integer> entry : valueOccurrenceCount.entrySet()) {
            if (entry.getValue() == combination) {
                if (entry.getKey() < highestCard && entry.getKey() > secondHighestCard) {
                    secondHighestCard = entry.getKey();
                }
            }
        }

        return secondHighestCard;
    }
}
