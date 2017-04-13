import com.pokerapp.models.Card;
import com.pokerapp.models.hands.*;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StraightTest {
    @Test
    public void testStraight() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(5, 2);
        Card c3 = new Card(6, 3);
        Card c4 = new Card(7, 4);
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

        Straight straight = new Straight(cards);
        ArrayList<Card> bestStraight = straight.getBestHand();

        assertEquals(bestStraight.contains(c1), true);
        assertEquals(bestStraight.contains(c2), true);
        assertEquals(bestStraight.contains(c3), true);
        assertEquals(bestStraight.contains(c4), true);
        assertEquals(bestStraight.contains(c5), true);
        assertEquals(bestStraight.contains(c6), false);
        assertEquals(bestStraight.contains(c7), false);
        assertEquals(bestStraight.size() == 5, true);
    }

    @Test
    public void testGetHigherStraightForSixCardStraight() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(5, 2);
        Card c3 = new Card(6, 3);
        Card c4 = new Card(7, 4);
        Card c5 = new Card(8, 1);
        Card c6 = new Card(9, 2);
        Card c7 = new Card(12, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        Straight straight = new Straight(cards);
        ArrayList<Card> bestStraight = straight.getBestHand();

        assertEquals(bestStraight.contains(c2), true);
        assertEquals(bestStraight.contains(c3), true);
        assertEquals(bestStraight.contains(c4), true);
        assertEquals(bestStraight.contains(c5), true);
        assertEquals(bestStraight.contains(c6), true);
        assertEquals(bestStraight.contains(c1), false);
        assertEquals(bestStraight.contains(c7), false);
        assertEquals(bestStraight.size() == 5, true);
    }

    @Test
    public void testTenToAceStraight() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(11, 2);
        Card c3 = new Card(13, 3);
        Card c4 = new Card(7, 4);
        Card c5 = new Card(10, 1);
        Card c6 = new Card(1, 2);
        Card c7 = new Card(12, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        Straight straight = new Straight(cards);
        ArrayList<Card> bestStraight = straight.getBestHand();

        assertEquals(bestStraight.contains(c2), true);
        assertEquals(bestStraight.contains(c3), true);
        assertEquals(bestStraight.contains(c5), true);
        assertEquals(bestStraight.contains(c6), true);
        assertEquals(bestStraight.contains(c7), true);
        assertEquals(bestStraight.contains(c1), false);
        assertEquals(bestStraight.contains(c4), false);
        assertEquals(bestStraight.size() == 5, true);
    }

    @Test
    public void testAceToFiveStraight() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(7, 4);
        Card c5 = new Card(10, 1);
        Card c6 = new Card(1, 2);
        Card c7 = new Card(5, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        Straight straight = new Straight(cards);
        ArrayList<Card> bestStraight = straight.getBestHand();

        assertEquals(bestStraight.contains(c1), true);
        assertEquals(bestStraight.contains(c2), true);
        assertEquals(bestStraight.contains(c3), true);
        assertEquals(bestStraight.contains(c6), true);
        assertEquals(bestStraight.contains(c7), true);
        assertEquals(bestStraight.contains(c4), false);
        assertEquals(bestStraight.contains(c5), false);
        assertEquals(bestStraight.size() == 5, true);
    }

    @Test
    public void testTwoToSixOverAceToFiveStraight() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(6, 4);
        Card c5 = new Card(10, 1);
        Card c6 = new Card(1, 2);
        Card c7 = new Card(5, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        Straight straight = new Straight(cards);
        ArrayList<Card> bestStraight = straight.getBestHand();

        assertEquals(bestStraight.contains(c1), true);
        assertEquals(bestStraight.contains(c2), true);
        assertEquals(bestStraight.contains(c3), true);
        assertEquals(bestStraight.contains(c4), true);
        assertEquals(bestStraight.contains(c7), true);
        assertEquals(bestStraight.contains(c5), false);
        assertEquals(bestStraight.contains(c6), false);
        assertEquals(bestStraight.size() == 5, true);
    }

    @Test
    public void testStraightWithDuplicatesInvolved() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(6, 4);
        Card c5 = new Card(4, 3);
        Card c6 = new Card(3, 4);
        Card c7 = new Card(5, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        Straight straight = new Straight(cards);
        ArrayList<Card> bestStraight = straight.getBestHand();

        assertEquals(bestStraight.contains(c1), true);
        assertEquals(bestStraight.contains(c2), true);
        assertEquals(bestStraight.contains(c3), true);
        assertEquals(bestStraight.contains(c4), true);
        assertEquals(bestStraight.contains(c7), true);
        assertEquals(bestStraight.contains(c5), false);
        assertEquals(bestStraight.contains(c6), false);
        assertEquals(bestStraight.size() == 5, true);
    }

    @Test
    public void testTenToAceStraightWithTwoAndThree() {
        Card c1 = new Card(2, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(1, 3);
        Card c4 = new Card(13, 4);
        Card c5 = new Card(12, 3);
        Card c6 = new Card(11, 4);
        Card c7 = new Card(10, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        Straight straight = new Straight(cards);
        ArrayList<Card> bestStraight = straight.getBestHand();

        assertEquals(bestStraight.contains(c3), true);
        assertEquals(bestStraight.contains(c4), true);
        assertEquals(bestStraight.contains(c5), true);
        assertEquals(bestStraight.contains(c6), true);
        assertEquals(bestStraight.contains(c7), true);
        assertEquals(bestStraight.contains(c1), false);
        assertEquals(bestStraight.contains(c2), false);
        assertEquals(bestStraight.size() == 5, true);
    }

    @Test
    public void testCompareOneHigherStraight() {
        ArrayList<Card> straightCards1 = new ArrayList<Card>(7);
        straightCards1.add(new Card(4, 1));
        straightCards1.add(new Card(5, 2));
        straightCards1.add(new Card(6, 3));
        straightCards1.add(new Card(7, 4));
        straightCards1.add(new Card(8, 1));
        straightCards1.add(new Card(10, 2));
        straightCards1.add(new Card(11, 3));

        PokerHand fourToEightStraight = new Straight(straightCards1);

        ArrayList<Card> straightCards2 = new ArrayList<Card>(7);
        straightCards2.add(new Card(4, 1));
        straightCards2.add(new Card(5, 2));
        straightCards2.add(new Card(6, 3));
        straightCards2.add(new Card(7, 4));
        straightCards2.add(new Card(8, 1));
        straightCards2.add(new Card(8, 2));
        straightCards2.add(new Card(9, 3));

        PokerHand fiveToNineStraight = new Straight(straightCards2);

        int compareNum = fourToEightStraight.compareTo(fiveToNineStraight);

        assertTrue(compareNum < 0);
    }

    @Test
    public void testCompareTwoToSixToAceToFiveStraight() {
        ArrayList<Card> straightCards1 = new ArrayList<Card>(7);
        straightCards1.add(new Card(2, 1));
        straightCards1.add(new Card(3, 2));
        straightCards1.add(new Card(4, 3));
        straightCards1.add(new Card(5, 4));
        straightCards1.add(new Card(8, 1));
        straightCards1.add(new Card(1, 2));
        straightCards1.add(new Card(10, 3));

        PokerHand aceToFiveStraight = new Straight(straightCards1);

        ArrayList<Card> straightCards2 = new ArrayList<Card>(7);
        straightCards2.add(new Card(2, 1));
        straightCards2.add(new Card(3, 2));
        straightCards2.add(new Card(4, 3));
        straightCards2.add(new Card(5, 4));
        straightCards2.add(new Card(8, 1));
        straightCards2.add(new Card(1, 3));
        straightCards2.add(new Card(6, 4));

        PokerHand twoToSixStraight = new Straight(straightCards2);

        int compareNum = twoToSixStraight.compareTo(aceToFiveStraight);

        assertTrue(compareNum > 0);
    }

    @Test
    public void testCompareTenToAceStraightToAceToFiveStraight() {
        ArrayList<Card> straightCards1 = new ArrayList<Card>(7);
        straightCards1.add(new Card(1, 1));
        straightCards1.add(new Card(2, 2));
        straightCards1.add(new Card(3, 3));
        straightCards1.add(new Card(10, 4));
        straightCards1.add(new Card(11, 1));
        straightCards1.add(new Card(4, 2));
        straightCards1.add(new Card(5, 3));

        PokerHand aceToFiveStraight = new Straight(straightCards1);

        ArrayList<Card> straightCards2 = new ArrayList<Card>(7);
        straightCards2.add(new Card(1, 1));
        straightCards2.add(new Card(2, 2));
        straightCards2.add(new Card(3, 3));
        straightCards2.add(new Card(10, 4));
        straightCards2.add(new Card(11, 1));
        straightCards2.add(new Card(12, 2));
        straightCards2.add(new Card(13, 3));

        PokerHand tenToAceStraight = new Straight(straightCards2);

        int compareNum = tenToAceStraight.compareTo(aceToFiveStraight);

        assertTrue(compareNum > 0);
    }
}