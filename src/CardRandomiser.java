import java.util.ArrayList;

public class CardRandomiser {

    public static ArrayList<Integer> generateRandomUniqueCardValues(int numberOfCards) {
        ArrayList<Integer> randomUniqueCardValues = new ArrayList<Integer>(numberOfCards);

        while (randomUniqueCardValues.size() < numberOfCards) {
            int cardValue = (int) (Math.random() * 12 + 1);

            if (!randomUniqueCardValues.contains(cardValue)) {
                randomUniqueCardValues.add(cardValue);
            }
        }

        return randomUniqueCardValues;
    }

}
