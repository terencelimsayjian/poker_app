import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FullHouseHandCheckerTest {

    @Test
    public void testIsFullHouse() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 2));

        assertEquals(FullHouseHandChecker.isTrue(cards), true);
    }

    @Test
    public void testIsNotFullHouse() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 2));

        assertEquals(FullHouseHandChecker.isTrue(cards), false);
    }

    @Test
    public void testTwoThreeOfAKindIsFullHouse() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(3, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(2, 3));

        assertEquals(FullHouseHandChecker.isTrue(cards), true);
    }

    @Test
    public void testThreeOfAKindAndTwoPairsIsFullHouse() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(3, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(4, 1));
        cards.add(new Card(4, 2));

        assertEquals(FullHouseHandChecker.isTrue(cards), true);
    }
}