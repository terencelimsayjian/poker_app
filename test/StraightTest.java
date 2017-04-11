import com.pokerapp.models.Card;
import com.pokerapp.models.hands.Straight;
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
}