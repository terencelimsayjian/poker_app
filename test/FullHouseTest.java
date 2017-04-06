import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FullHouseTest {

    @Test
    public void testIsFullHouse() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 2));

        FullHouse fullHouse = new FullHouse(cards);
        assertEquals(fullHouse.isTrue(), true);
    }

    @Test
    public void testIsNotFullHouse() {
        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 2));

        FullHouse fullHouse = new FullHouse(cards);
        assertEquals(fullHouse.isTrue(), false);
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

        FullHouse fullHouse = new FullHouse(cards);
        assertEquals(fullHouse.isTrue(), true);
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

        FullHouse fullHouse = new FullHouse(cards);
        assertEquals(fullHouse.isTrue(), true);
    }

    @Test
    public void testBestFullHouse() {
        Card c1 = new Card(3, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(3, 3);
        Card c4 = new Card(2, 1);
        Card c5 = new Card(2, 2);
        Card c6 = new Card(10, 1);
        Card c7 = new Card(12, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        FullHouse fullHouse = new FullHouse(cards);
        ArrayList<Card> bestFullHouse = fullHouse.getBestHand();
        assertEquals(bestFullHouse.contains(c1), true);
        assertEquals(bestFullHouse.contains(c2), true);
        assertEquals(bestFullHouse.contains(c3), true);
        assertEquals(bestFullHouse.contains(c4), true);
        assertEquals(bestFullHouse.contains(c5), true);
        assertEquals(bestFullHouse.contains(c6), false);
        assertEquals(bestFullHouse.contains(c7), false);
        assertEquals(bestFullHouse.size() == 5, true);
    }

    @Test
    public void testBestFullHouseWithTwoPair() {
        Card c1 = new Card(3, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(9, 3);
        Card c4 = new Card(9, 1);
        Card c5 = new Card(9, 2);
        Card c6 = new Card(12, 1);
        Card c7 = new Card(12, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        FullHouse fullHouse = new FullHouse(cards);
        ArrayList<Card> bestFullHouse = fullHouse.getBestHand();
        assertEquals(bestFullHouse.contains(c3), true);
        assertEquals(bestFullHouse.contains(c4), true);
        assertEquals(bestFullHouse.contains(c5), true);
        assertEquals(bestFullHouse.contains(c6), true);
        assertEquals(bestFullHouse.contains(c7), true);
        assertEquals(bestFullHouse.contains(c1), false);
        assertEquals(bestFullHouse.contains(c2), false);
        assertEquals(bestFullHouse.size() == 5, true);
    }

    @Test
    public void testBestFullHouseWithTwoThreeOfAKind() {
        Card c1 = new Card(10, 1);
        Card c2 = new Card(11, 2);
        Card c3 = new Card(10, 3);
        Card c4 = new Card(11, 1);
        Card c5 = new Card(10, 2);
        Card c6 = new Card(11, 1);
        Card c7 = new Card(6, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        FullHouse fullHouse = new FullHouse(cards);
        ArrayList<Card> bestFullHouse = fullHouse.getBestHand();
        assertEquals(bestFullHouse.contains(c1), true);
        assertEquals(bestFullHouse.contains(c2), true);
        assertEquals(bestFullHouse.contains(c3), true);
        assertEquals(bestFullHouse.contains(c4), true);
        assertEquals(bestFullHouse.contains(c6), true);
        assertEquals(bestFullHouse.contains(c5), false);
        assertEquals(bestFullHouse.contains(c7), false);
        assertEquals(bestFullHouse.size() == 5, true);
    }

}