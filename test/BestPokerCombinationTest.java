import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class BestPokerCombinationTest {
    @Test
    public void testFourOfAKind () {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(2, 3));
        cards.add(new Card(2, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));

        PokerHand bestHand = BestPokerCombination.get(cards);
        assertEquals(bestHand instanceof FourOfAKind, true);
    }
//
//    @Test
//    public void testFullHouse () {
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(new Card(3, 1));
//        cards.add(new Card(3, 2));
//        cards.add(new Card(3, 3));
//        cards.add(new Card(5, 4));
//        cards.add(new Card(6, 1));
//        cards.add(new Card(13, 2));
//        cards.add(new Card(13, 3));
//
//        assertEquals(BestPokerCombination.get(cards), PokerHand.FULL_HOUSE);
//    }
//
//    @Test
//    public void testFlush () {
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(new Card(1, 2));
//        cards.add(new Card(3, 2));
//        cards.add(new Card(5, 3));
//        cards.add(new Card(7, 4));
//        cards.add(new Card(9, 2));
//        cards.add(new Card(11, 2));
//        cards.add(new Card(13, 2));
//
//        assertEquals(BestPokerCombination.get(cards), PokerHand.FLUSH);
//    }
//
//    @Test
//    public void testStraight () {
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(new Card(1, 1));
//        cards.add(new Card(3, 2));
//        cards.add(new Card(4, 3));
//        cards.add(new Card(5, 4));
//        cards.add(new Card(6, 1));
//        cards.add(new Card(7, 2));
//        cards.add(new Card(13, 3));
//
//        assertEquals(BestPokerCombination.get(cards), PokerHand.STRAIGHT);
//    }
//
//    @Test
//    public void testThreeOfAKind () {
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(new Card(1, 1));
//        cards.add(new Card(3, 2));
//        cards.add(new Card(3, 3));
//        cards.add(new Card(3, 4));
//        cards.add(new Card(6, 1));
//        cards.add(new Card(7, 2));
//        cards.add(new Card(13, 3));
//
//        assertEquals(BestPokerCombination.get(cards), PokerHand.THREE_OF_A_KIND);
//    }
//
//    @Test
//    public void testTwoPair () {
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(new Card(1, 1));
//        cards.add(new Card(7, 2));
//        cards.add(new Card(3, 3));
//        cards.add(new Card(3, 4));
//        cards.add(new Card(6, 1));
//        cards.add(new Card(7, 2));
//        cards.add(new Card(13, 3));
//
//        assertEquals(BestPokerCombination.get(cards), PokerHand.TWO_PAIR);
//    }
//
//    @Test
//    public void testPair () {
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(new Card(1, 1));
//        cards.add(new Card(2, 2));
//        cards.add(new Card(3, 3));
//        cards.add(new Card(8, 4));
//        cards.add(new Card(6, 1));
//        cards.add(new Card(13, 2));
//        cards.add(new Card(13, 3));
//
//        assertEquals(BestPokerCombination.get(cards), PokerHand.PAIR);
//    }
//
//    @Test
//    public void testHighCard () {
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(new Card(1, 1));
//        cards.add(new Card(2, 2));
//        cards.add(new Card(3, 3));
//        cards.add(new Card(8, 4));
//        cards.add(new Card(9, 1));
//        cards.add(new Card(10, 2));
//        cards.add(new Card(13, 3));
//
//        assertEquals(BestPokerCombination.get(cards), PokerHand.HIGH_CARD);
//    }
//
//    @Test
//    public void flushOverStraight () {
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(new Card(1, 1));
//        cards.add(new Card(2, 2));
//        cards.add(new Card(3, 3));
//        cards.add(new Card(4, 3));
//        cards.add(new Card(5, 3));
//        cards.add(new Card(10, 3));
//        cards.add(new Card(13, 3));
//
//        assertEquals(BestPokerCombination.get(cards), PokerHand.FLUSH);
//    }

}