import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TwoPairHandCheckerTest {
    @Test
    public void testIsTwoPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(10, 3));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 2));

        assertEquals(TwoPairHandChecker.isTrue(cards), true);
    }

    @Test
    public void testThreePairIsTwoPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(10, 3));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(11, 4));

        assertEquals(TwoPairHandChecker.isTrue(cards), true);
    }

    @Test
    public void testOnePairIsNotTwoPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(7, 3));
        cards.add(new Card(8, 1));
        cards.add(new Card(9, 2));
        cards.add(new Card(11, 4));

        assertEquals(TwoPairHandChecker.isTrue(cards), false);
    }

    @Test
    public void testFourOfAKindIsNotTwoPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(1, 4));
        cards.add(new Card(9, 2));
        cards.add(new Card(11, 4));

        assertEquals(TwoPairHandChecker.isTrue(cards), false);
    }

    @Test
    public void testFullHosueIsNotTwoPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(9, 4));
        cards.add(new Card(9, 2));
        cards.add(new Card(11, 4));

        assertEquals(TwoPairHandChecker.isTrue(cards), false);
    }
}