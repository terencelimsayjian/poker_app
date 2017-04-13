import com.pokerapp.models.Card;
import com.pokerapp.models.hands.PokerHand;
import com.pokerapp.models.hands.StraightFlush;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StraightFlushTest {
    @Test
    public void testStraightFlush() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(5, 1);
        Card c3 = new Card(6, 1);
        Card c4 = new Card(7, 1);
        Card c5 = new Card(8, 1);
        Card c6 = new Card(10, 2);
        Card c7 = new Card(12, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        StraightFlush straightFlush = new StraightFlush(cards);
        ArrayList<Card> bestStraightFlush = straightFlush.getBestHand();

        assertEquals(bestStraightFlush.contains(c1), true);
        assertEquals(bestStraightFlush.contains(c2), true);
        assertEquals(bestStraightFlush.contains(c3), true);
        assertEquals(bestStraightFlush.contains(c4), true);
        assertEquals(bestStraightFlush.contains(c5), true);
        assertEquals(bestStraightFlush.contains(c6), false);
        assertEquals(bestStraightFlush.contains(c7), false);
        assertEquals(bestStraightFlush.size() == 5, true);
    }

    @Test
    public void testTwoToSixOverAceToFiveStraightFlush() {
        Card c1 = new Card(2, 1);
        Card c2 = new Card(3, 1);
        Card c3 = new Card(4, 1);
        Card c4 = new Card(5, 1);
        Card c5 = new Card(8, 2);
        Card c6 = new Card(6, 1);
        Card c7 = new Card(1, 1);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        StraightFlush straightFlush = new StraightFlush(cards);
        ArrayList<Card> bestStraightFlush = straightFlush.getBestHand();

        assertEquals(bestStraightFlush.contains(c1), true);
        assertEquals(bestStraightFlush.contains(c2), true);
        assertEquals(bestStraightFlush.contains(c3), true);
        assertEquals(bestStraightFlush.contains(c4), true);
        assertEquals(bestStraightFlush.contains(c6), true);
        assertEquals(bestStraightFlush.contains(c5), false);
        assertEquals(bestStraightFlush.contains(c7), false);
        assertEquals(bestStraightFlush.size() == 5, true);
    }

    @Test
    public void testCompareStraightFlush() {
        ArrayList<Card> straightFlushCards1 = new ArrayList<Card>(7);
        straightFlushCards1.add(new Card(4, 1));
        straightFlushCards1.add(new Card(5, 1));
        straightFlushCards1.add(new Card(6, 1));
        straightFlushCards1.add(new Card(7, 1));
        straightFlushCards1.add(new Card(8, 1));
        straightFlushCards1.add(new Card(10, 2));
        straightFlushCards1.add(new Card(12, 3));

        PokerHand fourToEightStraightFlush = new StraightFlush(straightFlushCards1);

        ArrayList<Card> straightFlushCards2 = new ArrayList<Card>(7);
        straightFlushCards2.add(new Card(3, 2));
        straightFlushCards2.add(new Card(5, 1));
        straightFlushCards2.add(new Card(6, 1));
        straightFlushCards2.add(new Card(7, 1));
        straightFlushCards2.add(new Card(8, 1));
        straightFlushCards2.add(new Card(9, 1));
        straightFlushCards2.add(new Card(12, 3));

        PokerHand fiveToNineStraightFlush = new StraightFlush(straightFlushCards2);

        int compareNum = fourToEightStraightFlush.compareTo(fiveToNineStraightFlush);
        assertTrue(compareNum < 0);
    }

    @Test
    public void testCompareNineToKingWithTenToAceStraightFlush() {
        ArrayList<Card> straightFlushCards1 = new ArrayList<Card>(7);
        straightFlushCards1.add(new Card(4, 3));
        straightFlushCards1.add(new Card(13, 1));
        straightFlushCards1.add(new Card(12, 1));
        straightFlushCards1.add(new Card(11, 1));
        straightFlushCards1.add(new Card(10, 1));
        straightFlushCards1.add(new Card(9, 1));
        straightFlushCards1.add(new Card(1, 2));

        PokerHand nineToKingStraightFlush = new StraightFlush(straightFlushCards1);

        ArrayList<Card> straightFlushCards2 = new ArrayList<Card>(7);
        straightFlushCards2.add(new Card(13, 1));
        straightFlushCards2.add(new Card(1, 1));
        straightFlushCards2.add(new Card(6, 2));
        straightFlushCards2.add(new Card(2, 2));
        straightFlushCards2.add(new Card(10, 1));
        straightFlushCards2.add(new Card(11, 1));
        straightFlushCards2.add(new Card(12, 1));

        PokerHand tenToAceStraightFlush = new StraightFlush(straightFlushCards2);

        int compareNum = nineToKingStraightFlush.compareTo(tenToAceStraightFlush);
        assertTrue(compareNum < 0);
    }

    @Test
    public void testCompareTwoToSixWithAceToFiveStraightFlush() {
        ArrayList<Card> straightFlushCards1 = new ArrayList<Card>(7);
        straightFlushCards1.add(new Card(4, 1));
        straightFlushCards1.add(new Card(5, 1));
        straightFlushCards1.add(new Card(8, 2));
        straightFlushCards1.add(new Card(9, 2));
        straightFlushCards1.add(new Card(3, 1));
        straightFlushCards1.add(new Card(2, 1));
        straightFlushCards1.add(new Card(1, 1));

        PokerHand aceToFiveStraightFlush = new StraightFlush(straightFlushCards1);

        ArrayList<Card> straightFlushCards2 = new ArrayList<Card>(7);
        straightFlushCards2.add(new Card(3, 1));
        straightFlushCards2.add(new Card(4, 1));
        straightFlushCards2.add(new Card(6, 2));
        straightFlushCards2.add(new Card(2, 1));
        straightFlushCards2.add(new Card(8, 2));
        straightFlushCards2.add(new Card(6, 1));
        straightFlushCards2.add(new Card(5, 1));

        PokerHand twoToSixStraightFlush = new StraightFlush(straightFlushCards2);

        int compareNum = aceToFiveStraightFlush.compareTo(twoToSixStraightFlush);
        assertTrue(compareNum < 0);
    }

    @Test
    public void testIdenticalStraightFlushes() {
        ArrayList<Card> straightFlushCards1 = new ArrayList<Card>(7);
        straightFlushCards1.add(new Card(4, 1));
        straightFlushCards1.add(new Card(5, 1));
        straightFlushCards1.add(new Card(6, 1));
        straightFlushCards1.add(new Card(7, 1));
        straightFlushCards1.add(new Card(8, 1));
        straightFlushCards1.add(new Card(2, 1));
        straightFlushCards1.add(new Card(1, 1));

        PokerHand straightFlush1 = new StraightFlush(straightFlushCards1);

        ArrayList<Card> straightFlushCards2 = new ArrayList<Card>(7);
        straightFlushCards2.add(new Card(4, 1));
        straightFlushCards2.add(new Card(5, 1));
        straightFlushCards2.add(new Card(6, 1));
        straightFlushCards2.add(new Card(7, 1));
        straightFlushCards2.add(new Card(8, 1));
        straightFlushCards2.add(new Card(2, 3));
        straightFlushCards2.add(new Card(1, 2));

        PokerHand straightFlush2 = new StraightFlush(straightFlushCards2);

        int compareNum = straightFlush1.compareTo(straightFlush2);
        assertTrue(compareNum == 0);
    }

}