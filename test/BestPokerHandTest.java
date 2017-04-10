import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class BestPokerHandTest {
    @Test
    public void testStraightFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(2, 4));
        cards.add(new Card(6, 2));
        cards.add(new Card(7, 1));
        cards.add(new Card(8, 1));

        PokerHand bestHand = BestPokerHand.get(cards);
        assertEquals(bestHand instanceof StraightFlush, true);
    }

    @Test
    public void testFourOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(2, 3));
        cards.add(new Card(2, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));

        PokerHand bestHand = BestPokerHand.get(cards);
        assertEquals(bestHand instanceof FourOfAKind, true);
    }

    @Test
    public void testFullHouse() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(3, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(5, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(13, 2));
        cards.add(new Card(13, 3));

        PokerHand bestHand = BestPokerHand.get(cards);
        assertEquals(bestHand instanceof FullHouse, true);
    }

    @Test
    public void testFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 2));
        cards.add(new Card(3, 2));
        cards.add(new Card(5, 3));
        cards.add(new Card(7, 4));
        cards.add(new Card(9, 2));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 2));

        PokerHand bestHand = BestPokerHand.get(cards);
        assertEquals(bestHand instanceof Flush, true);
    }

    @Test
    public void testStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(4, 3));
        cards.add(new Card(5, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 2));
        cards.add(new Card(13, 3));

        PokerHand bestHand = BestPokerHand.get(cards);
        assertEquals(bestHand instanceof Straight, true);
    }

    @Test
    public void testThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(3, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 2));
        cards.add(new Card(13, 3));

        PokerHand bestHand = BestPokerHand.get(cards);
        assertEquals(bestHand instanceof ThreeOfAKind, true);
    }

    @Test
    public void testTwoPair() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(7, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(3, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 2));
        cards.add(new Card(13, 3));

        PokerHand bestHand = BestPokerHand.get(cards);
        assertEquals(bestHand instanceof TwoPair, true);
    }

    @Test
    public void testPair() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(8, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(13, 2));
        cards.add(new Card(13, 3));

        PokerHand bestHand = BestPokerHand.get(cards);
        assertEquals(bestHand instanceof Pair, true);
    }

    @Test
    public void testHighCard() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(8, 4));
        cards.add(new Card(9, 1));
        cards.add(new Card(10, 2));
        cards.add(new Card(13, 3));

        PokerHand bestHand = BestPokerHand.get(cards);
        assertEquals(bestHand instanceof HighCard, true);
    }

}