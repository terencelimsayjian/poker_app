import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlushHandCheckerTest {
    @Test
    public void testIsFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(9, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));

        assertEquals(FlushHandChecker.isTrue(cards),true);
    }

    @Test
    public void testIsNotFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(9, 4));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));

        assertEquals(FlushHandChecker.isTrue(cards),false);
    }

    @Test
    public void testSixCardFlushIsFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(9, 1));
        cards.add(new Card(11, 1));
        cards.add(new Card(13, 3));

        assertEquals(FlushHandChecker.isTrue(cards),true);
    }

}