import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GetFlushCardsTest {
    @Test
    public void testGetFlushCards() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(5, 1);
        Card c3 = new Card(6, 1);
        Card c4 = new Card(7, 1);
        Card c5 = new Card(8, 1);
        Card c6 = new Card(10, 2);
        Card c7 = new Card(10, 4);
        Card c8 = new Card(10, 4);
        Card c9 = new Card(10, 4);
        Card c10 = new Card(12, 4);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);
        cards.add(c8);
        cards.add(c9);
        cards.add(c10);

        ArrayList<Card> flushCards = GetFlushCards.call(cards);

        assertEquals(flushCards.contains(c1), true);
        assertEquals(flushCards.contains(c2), true);
        assertEquals(flushCards.contains(c3), true);
        assertEquals(flushCards.contains(c4), true);
        assertEquals(flushCards.contains(c5), true);
        assertEquals(flushCards.contains(c6), false);
        assertEquals(flushCards.contains(c7), false);
        assertEquals(flushCards.contains(c8), false);
        assertEquals(flushCards.contains(c9), false);
        assertEquals(flushCards.contains(c10), false);
        assertEquals(flushCards.size() == 5, true);
    }

}