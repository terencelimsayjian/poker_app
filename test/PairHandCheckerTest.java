import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PairHandCheckerTest {
    @Test
    public void testIsPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(10, 2));
        cards.add(new Card(2, 3));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 2));

        assertEquals(PairHandChecker.isTrue(cards), true);
    }

    @Test
    public void testIsNotPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(2, 3));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 2));

        assertEquals(PairHandChecker.isTrue(cards), false);
    }

    @Test
    public void testTwoPairIsNotPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(2, 3));
        cards.add(new Card(2, 4));
        cards.add(new Card(10, 1));
        cards.add(new Card(10, 2));
        cards.add(new Card(11, 2));

        assertEquals(PairHandChecker.isTrue(cards), false);
    }

    @Test
    public void testThreeOfAKindIsNotPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(2, 3));
        cards.add(new Card(2, 4));
        cards.add(new Card(12, 1));
        cards.add(new Card(10, 2));
        cards.add(new Card(11, 2));

        assertEquals(PairHandChecker.isTrue(cards), false);
    }

    @Test
    public void testFullHouseIsNotPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));
        cards.add(new Card(13, 4));

        assertEquals(PairHandChecker.isTrue(cards), false);
    }

    @Test
    public void testFourOfAKindIsNotPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(13, 1));
        cards.add(new Card(13, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(11, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));
        cards.add(new Card(13, 4));

        assertEquals(PairHandChecker.isTrue(cards), false);
    }
}