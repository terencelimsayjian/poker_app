import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class FlushHandTest {
    @Test
    public void testFlushIsTrue () {
        ArrayList<Integer> randomUniqueCardValues = CardRandomiser.generateRandomUniqueCardValues(5);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(randomUniqueCardValues.get(0), 1));
        cards.add(new Card(randomUniqueCardValues.get(1), 1));
        cards.add(new Card(randomUniqueCardValues.get(2), 1));
        cards.add(new Card(randomUniqueCardValues.get(3), 1));
        cards.add(new Card(randomUniqueCardValues.get(4), 1));

        FlushHand fhc = new FlushHand(cards);
        assertEquals(fhc.isTrue(),true);
    }

    @Test
    public void testNoFlushIsNotTrue () {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 2));
        cards.add(new Card(6, 3));
        cards.add(new Card(7, 4));

        FlushHand fhc = new FlushHand(cards);
        assertEquals(fhc.isTrue(),false);
    }

    @Test
    public void testGetBestFlush () {

        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> randomUniqueCardValues = CardRandomiser.generateRandomUniqueCardValues(7);

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

            FlushHand flushHand = new FlushHand(cards);
            ArrayList<Card> bestFlush = flushHand.getBestHand();

            Collections.sort(cards);

            assertEquals(flushHand.isTrue(), true);
            assertEquals(bestFlush.contains(cards.get(2)), true);
            assertEquals(bestFlush.contains(cards.get(3)), true);
            assertEquals(bestFlush.contains(cards.get(4)), true);
            assertEquals(bestFlush.contains(cards.get(5)), true);
            assertEquals(bestFlush.contains(cards.get(6)), true);
            assertEquals(bestFlush.size() == 5, true);
        }
    }




}