import com.pokerapp.models.Card;
import com.pokerapp.models.hands.Flush;
import com.pokerapp.models.hands.PokerHand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class FlushTest {
    @Test
    public void testGetBestFlush () {

        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> randomUniqueCardValues = generateRandomUniqueCardValues(7);

            Card c1 = new Card(randomUniqueCardValues.get(0), 1);
            Card c2 = new Card(randomUniqueCardValues.get(1), 1);
            Card c3 = new Card(randomUniqueCardValues.get(2), 1);
            Card c4 = new Card(randomUniqueCardValues.get(3), 1);
            Card c5 = new Card(randomUniqueCardValues.get(4), 1);
            Card c6 = new Card(randomUniqueCardValues.get(5), 1);
            Card c7 = new Card(randomUniqueCardValues.get(6), 1);

            ArrayList<Card> cards = new ArrayList<Card>();
            cards.add(c1);
            cards.add(c2);
            cards.add(c3);
            cards.add(c4);
            cards.add(c5);
            cards.add(c6);
            cards.add(c7);

            PokerHand flush = new Flush(cards);
            ArrayList<Card> bestFlush = flush.getBestHand();

            Collections.sort(cards);

            assertEquals(bestFlush.contains(cards.get(2)), true);
            assertEquals(bestFlush.contains(cards.get(3)), true);
            assertEquals(bestFlush.contains(cards.get(4)), true);
            assertEquals(bestFlush.contains(cards.get(5)), true);
            assertEquals(bestFlush.contains(cards.get(6)), true);
            assertEquals(bestFlush.contains(cards.get(0)), false);
            assertEquals(bestFlush.contains(cards.get(1)), false);
            assertEquals(bestFlush.size() == 5, true);
        }
    }

    private ArrayList<Integer> generateRandomUniqueCardValues(int numberOfCards) {
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