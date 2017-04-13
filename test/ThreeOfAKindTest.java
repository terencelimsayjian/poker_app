import com.pokerapp.models.Card;
import com.pokerapp.models.hands.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ThreeOfAKindTest {
    @Test
    public void testBestThreeOfAKind() {
        Card c1 = new Card(3, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(3, 3);
        Card c4 = new Card(5, 1);
        Card c5 = new Card(6, 2);
        Card c6 = new Card(7, 1);
        Card c7 = new Card(8, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        ThreeOfAKind threeOfAKind = new ThreeOfAKind(cards);
        ArrayList<Card> bestThreeOfAKind = threeOfAKind.getBestHand();
        assertEquals(bestThreeOfAKind.contains(c1), true);
        assertEquals(bestThreeOfAKind.contains(c2), true);
        assertEquals(bestThreeOfAKind.contains(c3), true);
        assertEquals(bestThreeOfAKind.contains(c6), true);
        assertEquals(bestThreeOfAKind.contains(c7), true);
        assertEquals(bestThreeOfAKind.contains(c4), false);
        assertEquals(bestThreeOfAKind.contains(c5), false);
        assertEquals(bestThreeOfAKind.size() == 5, true);
    }

    @Test
    public void testBestThreeOfAKindWithMixedOrder() {
        Card c1 = new Card(1, 1);
        Card c2 = new Card(13, 2);
        Card c3 = new Card(6, 3);
        Card c4 = new Card(1, 2);
        Card c5 = new Card(8, 2);
        Card c6 = new Card(9, 1);
        Card c7 = new Card(1, 3);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        ThreeOfAKind threeOfAKind = new ThreeOfAKind(cards);
        ArrayList<Card> bestThreeOfAKind = threeOfAKind.getBestHand();
        assertEquals(bestThreeOfAKind.contains(c1), true);
        assertEquals(bestThreeOfAKind.contains(c2), true);
        assertEquals(bestThreeOfAKind.contains(c4), true);
        assertEquals(bestThreeOfAKind.contains(c6), true);
        assertEquals(bestThreeOfAKind.contains(c7), true);
        assertEquals(bestThreeOfAKind.contains(c3), false);
        assertEquals(bestThreeOfAKind.contains(c5), false);
        assertEquals(bestThreeOfAKind.size() == 5, true);
    }

    @Test
    public void testCompareThreeOfAKind() {
        ArrayList<Card> threeOfAKindCards1 = new ArrayList<Card>(7);
        threeOfAKindCards1.add(new Card(6, 1));
        threeOfAKindCards1.add(new Card(8, 2));
        threeOfAKindCards1.add(new Card(9, 3));
        threeOfAKindCards1.add(new Card(2, 4));
        threeOfAKindCards1.add(new Card(12, 1));
        threeOfAKindCards1.add(new Card(9, 2));
        threeOfAKindCards1.add(new Card(9, 4));

        PokerHand nineSetThreeOfAKind = new ThreeOfAKind(threeOfAKindCards1);

        ArrayList<Card> threeOfAKindCards2 = new ArrayList<Card>(7);
        threeOfAKindCards2.add(new Card(6, 1));
        threeOfAKindCards2.add(new Card(8, 2));
        threeOfAKindCards2.add(new Card(9, 3));
        threeOfAKindCards2.add(new Card(2, 4));
        threeOfAKindCards2.add(new Card(12, 1));
        threeOfAKindCards2.add(new Card(8, 2));
        threeOfAKindCards2.add(new Card(8, 3));

        PokerHand eightSetThreeOfAKind = new ThreeOfAKind(threeOfAKindCards2);

        int compareNum = nineSetThreeOfAKind.compareTo(eightSetThreeOfAKind);

        assertTrue(compareNum > 0);
    }

    @Test
    public void testCompareThreeOfAKindWithDifferentHighCard() {
        ArrayList<Card> threeOfAKindCards1 = new ArrayList<Card>(7);
        threeOfAKindCards1.add(new Card(6, 1));
        threeOfAKindCards1.add(new Card(6, 2));
        threeOfAKindCards1.add(new Card(6, 3));
        threeOfAKindCards1.add(new Card(2, 4));
        threeOfAKindCards1.add(new Card(12, 1));
        threeOfAKindCards1.add(new Card(9, 2));
        threeOfAKindCards1.add(new Card(1, 3));

        PokerHand threeOfAKindWithAceHigh = new ThreeOfAKind(threeOfAKindCards1);

        ArrayList<Card> threeOfAKindCards2 = new ArrayList<Card>(7);
        threeOfAKindCards2.add(new Card(6, 1));
        threeOfAKindCards2.add(new Card(6, 2));
        threeOfAKindCards2.add(new Card(6, 3));
        threeOfAKindCards2.add(new Card(2, 4));
        threeOfAKindCards2.add(new Card(12, 1));
        threeOfAKindCards2.add(new Card(8, 2));
        threeOfAKindCards2.add(new Card(13, 3));

        PokerHand threeOfAKindWithKingHigh = new ThreeOfAKind(threeOfAKindCards2);

        int compareNum = threeOfAKindWithAceHigh.compareTo(threeOfAKindWithKingHigh);

        assertTrue(compareNum > 0);
    }

    @Test
    public void testCompareThreeOfAKindWithDifferentSecondHighCard() {
        ArrayList<Card> threeOfAKindCards1 = new ArrayList<Card>(7);
        threeOfAKindCards1.add(new Card(6, 1));
        threeOfAKindCards1.add(new Card(6, 2));
        threeOfAKindCards1.add(new Card(6, 3));
        threeOfAKindCards1.add(new Card(1, 4));
        threeOfAKindCards1.add(new Card(10, 1));
        threeOfAKindCards1.add(new Card(13, 2));
        threeOfAKindCards1.add(new Card(5, 3));

        PokerHand threeOfAKindWithKingSecondHigh = new ThreeOfAKind(threeOfAKindCards1);

        ArrayList<Card> threeOfAKindCards2 = new ArrayList<Card>(7);
        threeOfAKindCards2.add(new Card(6, 1));
        threeOfAKindCards2.add(new Card(6, 2));
        threeOfAKindCards2.add(new Card(6, 3));
        threeOfAKindCards2.add(new Card(1, 4));
        threeOfAKindCards2.add(new Card(10, 1));
        threeOfAKindCards2.add(new Card(8, 2));
        threeOfAKindCards2.add(new Card(12, 3));

        PokerHand threeOfAKindWithQueenSecondHigh = new ThreeOfAKind(threeOfAKindCards2);

        int compareNum = threeOfAKindWithKingSecondHigh.compareTo(threeOfAKindWithQueenSecondHigh);

        assertTrue(compareNum > 0);
    }

    @Test
    public void testCompareIdenticalThreeOfAKind() {
        ArrayList<Card> threeOfAKindCards1 = new ArrayList<Card>(7);
        threeOfAKindCards1.add(new Card(6, 1));
        threeOfAKindCards1.add(new Card(6, 2));
        threeOfAKindCards1.add(new Card(6, 3));
        threeOfAKindCards1.add(new Card(1, 4));
        threeOfAKindCards1.add(new Card(13, 1));
        threeOfAKindCards1.add(new Card(2, 2));
        threeOfAKindCards1.add(new Card(5, 3));

        PokerHand threeOfAKind1 = new ThreeOfAKind(threeOfAKindCards1);

        ArrayList<Card> threeOfAKindCards2 = new ArrayList<Card>(7);
        threeOfAKindCards2.add(new Card(6, 1));
        threeOfAKindCards2.add(new Card(6, 2));
        threeOfAKindCards2.add(new Card(6, 3));
        threeOfAKindCards2.add(new Card(1, 4));
        threeOfAKindCards2.add(new Card(13, 1));
        threeOfAKindCards2.add(new Card(4, 2));
        threeOfAKindCards2.add(new Card(8, 3));

        PokerHand threeOfAKind2 = new ThreeOfAKind(threeOfAKindCards2);

        int compareNum = threeOfAKind1.compareTo(threeOfAKind2);

        assertTrue(compareNum == 0);
    }
}