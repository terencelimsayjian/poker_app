import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by terence on 06/04/2017.
 */
public class HighCardHandCheckerTest {
    @Test
    public void testIsHighCardPair() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(13, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(8, 1));
        cards.add(new Card(9, 2));

        assertEquals(HighCardHandChecker.isTrue(cards), true);
    }

    @Test
    public void testPairIsNotHighCard() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(10, 2));
        cards.add(new Card(2, 3));
        cards.add(new Card(6, 3));
        cards.add(new Card(7, 3));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 2));

        assertEquals(HighCardHandChecker.isTrue(cards), false);
    }

    @Test
    public void testTwoPairIsHighCard() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(2, 3));
        cards.add(new Card(2, 4));
        cards.add(new Card(13, 1));
        cards.add(new Card(10, 2));
        cards.add(new Card(11, 2));

        assertEquals(HighCardHandChecker.isTrue(cards), false);
    }

    @Test
    public void testThreeOfAKindIsNotHighCard() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(2, 3));
        cards.add(new Card(2, 4));
        cards.add(new Card(12, 1));
        cards.add(new Card(10, 2));
        cards.add(new Card(11, 2));

        assertEquals(HighCardHandChecker.isTrue(cards), false);
    }

    @Test
    public void testFullHouseIsNotHighCard() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));
        cards.add(new Card(13, 4));

        assertEquals(HighCardHandChecker.isTrue(cards), false);
    }

    @Test
    public void testFourOfAKindIsNotHighCard() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(13, 1));
        cards.add(new Card(13, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(11, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));
        cards.add(new Card(13, 4));

        assertEquals(HighCardHandChecker.isTrue(cards), false);
    }
}