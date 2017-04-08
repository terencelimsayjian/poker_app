import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StraightFlushTest {
    @Test
    public void testStraightFlush() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(5, 1);
        Card c3 = new Card(6, 1);
        Card c4 = new Card(7, 1);
        Card c5 = new Card(8, 1);
        Card c6 = new Card(10, 2);
        Card c7 = new Card(12, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        StraightFlush straightFlush = new StraightFlush(cards);
        ArrayList<Card> bestStraightFlush = straightFlush.getBestHand();

        assertEquals(bestStraightFlush.contains(c1), true);
        assertEquals(bestStraightFlush.contains(c2), true);
        assertEquals(bestStraightFlush.contains(c3), true);
        assertEquals(bestStraightFlush.contains(c4), true);
        assertEquals(bestStraightFlush.contains(c5), true);
        assertEquals(bestStraightFlush.contains(c6), false);
        assertEquals(bestStraightFlush.contains(c7), false);
        assertEquals(bestStraightFlush.size() == 5, true);
    }

}