import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ThreeOfAKindHandCheckerTest {
    @Test
    public void testIsThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 2));

        assertEquals(ThreeOfAKindHandChecker.isTrue(cards), true);
    }

    @Test
    public void testIsNotThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(6, 3));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 2));

        assertEquals(ThreeOfAKindHandChecker.isTrue(cards), false);
    }

    @Test
    public void testFourOfAKindIsNotThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(6, 1));
        cards.add(new Card(6, 2));
        cards.add(new Card(6, 3));
        cards.add(new Card(6, 4));
        cards.add(new Card(12, 1));
        cards.add(new Card(12, 1));
        cards.add(new Card(12, 2));

        assertEquals(ThreeOfAKindHandChecker.isTrue(cards), false);
    }

    @Test
    public void testFullHouseIsNotThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(6, 1));
        cards.add(new Card(6, 2));
        cards.add(new Card(6, 3));
        cards.add(new Card(11, 4));
        cards.add(new Card(11, 1));
        cards.add(new Card(12, 1));
        cards.add(new Card(12, 2));

        assertEquals(ThreeOfAKindHandChecker.isTrue(cards), false);
    }



}