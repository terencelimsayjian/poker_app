import com.pokerapp.models.Card;
import com.pokerapp.models.hands.*;
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

    @Test
    public void testCompareFlush() {
        ArrayList<Card> flushCards1 = new ArrayList<Card>(7);
        flushCards1.add(new Card(9, 1));
        flushCards1.add(new Card(7, 1));
        flushCards1.add(new Card(5, 1));
        flushCards1.add(new Card(3, 1));
        flushCards1.add(new Card(10, 3));
        flushCards1.add(new Card(1, 1));
        flushCards1.add(new Card(4, 3));

        PokerHand aceHighFlush = new Flush(flushCards1);

        ArrayList<Card> flushCards2 = new ArrayList<Card>(7);
        flushCards2.add(new Card(9, 1));
        flushCards2.add(new Card(7, 1));
        flushCards2.add(new Card(5, 1));
        flushCards2.add(new Card(3, 1));
        flushCards2.add(new Card(11, 2));
        flushCards2.add(new Card(13, 1));
        flushCards2.add(new Card(2, 2));

        PokerHand kingHighFlush = new Flush(flushCards2);

        int compareNum = aceHighFlush.compareTo(kingHighFlush);

        assertTrue(compareNum > 0);
    }

    @Test
    public void testCompareSecondHighCardFlush() {
        ArrayList<Card> flushCards1 = new ArrayList<Card>(7);
        flushCards1.add(new Card(9, 1));
        flushCards1.add(new Card(7, 1));
        flushCards1.add(new Card(5, 1));
        flushCards1.add(new Card(1, 1));
        flushCards1.add(new Card(10, 3));
        flushCards1.add(new Card(10, 1));
        flushCards1.add(new Card(4, 3));

        PokerHand tenSecondHighestCardFlush = new Flush(flushCards1);

        ArrayList<Card> flushCards2 = new ArrayList<Card>(7);
        flushCards2.add(new Card(9, 1));
        flushCards2.add(new Card(7, 1));
        flushCards2.add(new Card(5, 1));
        flushCards2.add(new Card(1, 1));
        flushCards2.add(new Card(11, 2));
        flushCards2.add(new Card(11, 1));
        flushCards2.add(new Card(2, 2));

        PokerHand jackSecondHighestCardFlush = new Flush(flushCards2);

        int compareNum = tenSecondHighestCardFlush.compareTo(jackSecondHighestCardFlush);

        assertTrue(compareNum < 0);
    }

    @Test
    public void testCompareThirdHighCardFlush() {
        ArrayList<Card> flushCards1 = new ArrayList<Card>(7);
        flushCards1.add(new Card(11, 1));
        flushCards1.add(new Card(7, 1));
        flushCards1.add(new Card(5, 1));
        flushCards1.add(new Card(1, 1));
        flushCards1.add(new Card(10, 3));
        flushCards1.add(new Card(9, 1));
        flushCards1.add(new Card(4, 3));

        PokerHand nineThirdHighestCardFlush = new Flush(flushCards1);

        ArrayList<Card> flushCards2 = new ArrayList<Card>(7);
        flushCards2.add(new Card(11, 1));
        flushCards2.add(new Card(7, 1));
        flushCards2.add(new Card(5, 1));
        flushCards2.add(new Card(1, 1));
        flushCards2.add(new Card(11, 2));
        flushCards2.add(new Card(8, 1));
        flushCards2.add(new Card(2, 2));

        PokerHand eightThirdHighestCardFlush = new Flush(flushCards2);

        int compareNum = nineThirdHighestCardFlush.compareTo(eightThirdHighestCardFlush);

        assertTrue(compareNum > 0);
    }

    @Test
    public void testCompareIdenticalFlush() {
        ArrayList<Card> flushCards1 = new ArrayList<Card>(7);
        flushCards1.add(new Card(11, 1));
        flushCards1.add(new Card(7, 1));
        flushCards1.add(new Card(13, 1));
        flushCards1.add(new Card(1, 1));
        flushCards1.add(new Card(10, 1));
        flushCards1.add(new Card(3, 1));
        flushCards1.add(new Card(4, 3));

        PokerHand nineThirdHighestCardFlush = new Flush(flushCards1);

        ArrayList<Card> flushCards2 = new ArrayList<Card>(7);
        flushCards2.add(new Card(11, 1));
        flushCards2.add(new Card(7, 1));
        flushCards2.add(new Card(13, 1));
        flushCards2.add(new Card(1, 1));
        flushCards2.add(new Card(10, 1));
        flushCards2.add(new Card(2, 1));
        flushCards2.add(new Card(2, 2));

        PokerHand eightThirdHighestCardFlush = new Flush(flushCards2);

        int compareNum = nineThirdHighestCardFlush.compareTo(eightThirdHighestCardFlush);

        assertTrue(compareNum == 0);
    }
}