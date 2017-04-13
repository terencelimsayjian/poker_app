import com.pokerapp.models.Card;
import com.pokerapp.models.hands.FullHouse;
import com.pokerapp.models.hands.PokerHand;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FullHouseTest {
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

    @Test
    public void testCompareFullHouseWithDifferentThreeOfAKind () {
        ArrayList<Card> fullHouseCards1 = new ArrayList<Card>(7);
        fullHouseCards1.add(new Card(13, 1));
        fullHouseCards1.add(new Card(13, 2));
        fullHouseCards1.add(new Card(13, 3));
        fullHouseCards1.add(new Card(10, 2));
        fullHouseCards1.add(new Card(10, 1));
        fullHouseCards1.add(new Card(3, 2));
        fullHouseCards1.add(new Card(4, 3));

        PokerHand kingHouseFullOfTens = new FullHouse(fullHouseCards1);

        ArrayList<Card> fullHouseCards2 = new ArrayList<Card>(7);
        fullHouseCards2.add(new Card(12, 1));
        fullHouseCards2.add(new Card(12, 2));
        fullHouseCards2.add(new Card(12, 3));
        fullHouseCards2.add(new Card(10, 4));
        fullHouseCards2.add(new Card(10, 2));
        fullHouseCards2.add(new Card(1, 1));
        fullHouseCards2.add(new Card(2, 1));

        PokerHand queenHouseFullOfTens = new FullHouse(fullHouseCards2);
        int compareNum = kingHouseFullOfTens.compareTo(queenHouseFullOfTens);
        assertTrue(compareNum > 0);
    }

    @Test
    public void testCompareFullHouseWithSameThreeOfAKindButDifferentPair() {
        ArrayList<Card> fullHouseCards1 = new ArrayList<Card>(7);
        fullHouseCards1.add(new Card(13, 1));
        fullHouseCards1.add(new Card(13, 2));
        fullHouseCards1.add(new Card(13, 3));
        fullHouseCards1.add(new Card(10, 2));
        fullHouseCards1.add(new Card(10, 1));
        fullHouseCards1.add(new Card(3, 2));
        fullHouseCards1.add(new Card(4, 3));

        PokerHand kingHouseFullOfTens = new FullHouse(fullHouseCards1);

        ArrayList<Card> fullHouseCards2 = new ArrayList<Card>(7);
        fullHouseCards2.add(new Card(13, 1));
        fullHouseCards2.add(new Card(13, 2));
        fullHouseCards2.add(new Card(13, 3));
        fullHouseCards2.add(new Card(11, 4));
        fullHouseCards2.add(new Card(11, 2));
        fullHouseCards2.add(new Card(1, 1));
        fullHouseCards2.add(new Card(2, 1));

        PokerHand kingHouseFullOfJacks = new FullHouse(fullHouseCards2);

        int compareNum = kingHouseFullOfTens.compareTo(kingHouseFullOfJacks);

        assertTrue(compareNum < 0);
    }
    @Test
    public void testCompareFullHouseWithTwoThreeOfAKinds() {
        ArrayList<Card> fullHouseCards1 = new ArrayList<Card>(7);
        fullHouseCards1.add(new Card(13, 1));
        fullHouseCards1.add(new Card(13, 2));
        fullHouseCards1.add(new Card(13, 3));
        fullHouseCards1.add(new Card(10, 2));
        fullHouseCards1.add(new Card(10, 1));
        fullHouseCards1.add(new Card(10, 3));
        fullHouseCards1.add(new Card(4, 3));

        PokerHand kingHouseFullOfTens = new FullHouse(fullHouseCards1);

        ArrayList<Card> fullHouseCards2 = new ArrayList<Card>(7);
        fullHouseCards2.add(new Card(13, 1));
        fullHouseCards2.add(new Card(13, 2));
        fullHouseCards2.add(new Card(13, 3));
        fullHouseCards2.add(new Card(11, 4));
        fullHouseCards2.add(new Card(11, 2));
        fullHouseCards2.add(new Card(11, 1));
        fullHouseCards2.add(new Card(2, 1));

        PokerHand kingHouseFullOfJacks = new FullHouse(fullHouseCards2);

        int compareNum = kingHouseFullOfTens.compareTo(kingHouseFullOfJacks);

        assertTrue(compareNum < 0);
    }

    @Test
    public void compareIdenticalFullHouse() {
        ArrayList<Card> fullHouseCards1 = new ArrayList<Card>(7);
        fullHouseCards1.add(new Card(13, 1));
        fullHouseCards1.add(new Card(13, 2));
        fullHouseCards1.add(new Card(13, 3));
        fullHouseCards1.add(new Card(10, 2));
        fullHouseCards1.add(new Card(10, 1));
        fullHouseCards1.add(new Card(6, 3));
        fullHouseCards1.add(new Card(4, 3));

        PokerHand fullHouse1 = new FullHouse(fullHouseCards1);

        ArrayList<Card> fullHouseCards2 = new ArrayList<Card>(7);
        fullHouseCards2.add(new Card(13, 1));
        fullHouseCards2.add(new Card(13, 2));
        fullHouseCards2.add(new Card(13, 3));
        fullHouseCards2.add(new Card(10, 4));
        fullHouseCards2.add(new Card(10, 2));
        fullHouseCards2.add(new Card(11, 1));
        fullHouseCards2.add(new Card(2, 1));

        PokerHand fullHouse2 = new FullHouse(fullHouseCards2);

        int compareNum = fullHouse1.compareTo(fullHouse2);

        assertTrue(compareNum == 0);
    }


}