import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokerFlushAnalyserTest {
    @Test
    public void testhasFiveOrMoreOfTheSameSuit() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));

        PokerFlushAnalyser csa = new PokerFlushAnalyser(cards);
        assertEquals(csa.hasFiveOrMoreOfTheSameSuit(),true);
    }

    @Test
    public void testNotFiveOrMoreOfTheSameSuit() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 2));
        cards.add(new Card(6, 2));
        cards.add(new Card(7, 2));

        PokerFlushAnalyser csa = new PokerFlushAnalyser(cards);
        assertEquals(csa.hasFiveOrMoreOfTheSameSuit(),false);
    }

    @Test
    public void testGetFlushSuit() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 2));
        cards.add(new Card(7, 2));

        PokerFlushAnalyser csa = new PokerFlushAnalyser(cards);
        assertEquals(csa.getFlushSuit() == 1,true);
    }

    @Test
    public void testWrongFlushSuit() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 3));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 2));
        cards.add(new Card(5, 2));
        cards.add(new Card(6, 2));
        cards.add(new Card(7, 2));

        PokerFlushAnalyser csa = new PokerFlushAnalyser(cards);
        assertEquals(csa.getFlushSuit() == 2,false);
    }

    @Test
    public void testGetBestFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(3, 1);
        Card c2 = new Card(5, 1);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(7, 1);
        Card c5 = new Card(6, 2);
        Card c6 = new Card(1, 1);
        Card c7 = new Card(4, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerFlushAnalyser pfa = new PokerFlushAnalyser(cards);
        ArrayList<Card> flushCards = pfa.getBestMadeFlush();
        assertEquals(flushCards.contains(c1), true);
        assertEquals(flushCards.contains(c2), true);
        assertEquals(flushCards.contains(c4), true);
        assertEquals(flushCards.contains(c6), true);
        assertEquals(flushCards.contains(c7), true);
        assertEquals(flushCards.size() == 5, true);
    }

    @Test
    public void testGetBestSixCardFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(3, 1);
        Card c2 = new Card(5, 1);
        Card c3 = new Card(2, 1);
        Card c4 = new Card(7, 1);
        Card c5 = new Card(6, 2);
        Card c6 = new Card(1, 1);
        Card c7 = new Card(4, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerFlushAnalyser pfa = new PokerFlushAnalyser(cards);
        ArrayList<Card> flushCards = pfa.getBestMadeFlush();
        assertEquals(flushCards.contains(c1), true);
        assertEquals(flushCards.contains(c2), true);
        assertEquals(flushCards.contains(c4), true);
        assertEquals(flushCards.contains(c6), true);
        assertEquals(flushCards.contains(c7), true);
        System.out.println(flushCards.toString());
        assertEquals(flushCards.size() == 5, true);
    }

    @Test
    public void testGetBestSevenCardFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(8, 1);
        Card c2 = new Card(10, 1);
        Card c3 = new Card(1, 1);
        Card c4 = new Card(2, 1);
        Card c5 = new Card(3, 1);
        Card c6 = new Card(13, 1);
        Card c7 = new Card(12, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerFlushAnalyser pfa = new PokerFlushAnalyser(cards);
        ArrayList<Card> flushCards = pfa.getBestMadeFlush();
        assertEquals(flushCards.contains(c1), true);
        assertEquals(flushCards.contains(c2), true);
        assertEquals(flushCards.contains(c3), true);
        assertEquals(flushCards.contains(c6), true);
        assertEquals(flushCards.contains(c7), true);
        System.out.println(flushCards.toString());
        assertEquals(flushCards.size() == 5, true);
    }

}