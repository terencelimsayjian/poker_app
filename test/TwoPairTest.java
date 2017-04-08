import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TwoPairTest {
    @Test
    public void testTwoPair() {
        Card c1 = new Card(13, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(3, 3);
        Card c4 = new Card(5, 1);
        Card c5 = new Card(6, 2);
        Card c6 = new Card(12, 1);
        Card c7 = new Card(13, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        TwoPair twoPair = new TwoPair(cards);
        ArrayList<Card> bestTwoPair = twoPair.getBestHand();
        assertEquals(bestTwoPair.contains(c1), true);
        assertEquals(bestTwoPair.contains(c2), true);
        assertEquals(bestTwoPair.contains(c3), true);
        assertEquals(bestTwoPair.contains(c6), true);
        assertEquals(bestTwoPair.contains(c7), true);
        assertEquals(bestTwoPair.contains(c4), false);
        assertEquals(bestTwoPair.contains(c5), false);
        assertEquals(bestTwoPair.size() == 5, true);
    }

    @Test
    public void testTwoPairWithThreePairs() {
        Card c1 = new Card(13, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(3, 3);
        Card c4 = new Card(6, 1);
        Card c5 = new Card(6, 2);
        Card c6 = new Card(12, 1);
        Card c7 = new Card(13, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        TwoPair twoPair = new TwoPair(cards);
        ArrayList<Card> bestTwoPair = twoPair.getBestHand();
        assertEquals(bestTwoPair.contains(c1), true);
        assertEquals(bestTwoPair.contains(c4), true);
        assertEquals(bestTwoPair.contains(c5), true);
        assertEquals(bestTwoPair.contains(c6), true);
        assertEquals(bestTwoPair.contains(c7), true);
        assertEquals(bestTwoPair.contains(c2), false);
        assertEquals(bestTwoPair.contains(c3), false);
        assertEquals(bestTwoPair.size() == 5, true);
    }

}