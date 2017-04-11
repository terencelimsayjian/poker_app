import com.pokerapp.models.Card;
import com.pokerapp.models.hands.Pair;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PairTest {
    @Test
    public void testPair() {
        Card c1 = new Card(1, 1);
        Card c2 = new Card(5, 2);
        Card c3 = new Card(6, 3);
        Card c4 = new Card(7, 1);
        Card c5 = new Card(9, 2);
        Card c6 = new Card(13, 1);
        Card c7 = new Card(1, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        Pair pair = new Pair(cards);
        ArrayList<Card> bestPair = pair.getBestHand();
        assertEquals(bestPair.contains(c1), true);
        assertEquals(bestPair.contains(c4), true);
        assertEquals(bestPair.contains(c5), true);
        assertEquals(bestPair.contains(c6), true);
        assertEquals(bestPair.contains(c7), true);
        assertEquals(bestPair.contains(c2), false);
        assertEquals(bestPair.contains(c3), false);
        assertEquals(bestPair.size() == 5, true);
    }

    @Test
    public void testPairWithDifferentHighCards() {
        Card c1 = new Card(2, 1);
        Card c2 = new Card(9, 2);
        Card c3 = new Card(10, 3);
        Card c4 = new Card(11, 1);
        Card c5 = new Card(12, 2);
        Card c6 = new Card(2, 1);
        Card c7 = new Card(1, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        Pair pair = new Pair(cards);
        ArrayList<Card> bestPair = pair.getBestHand();
        assertEquals(bestPair.contains(c1), true);
        assertEquals(bestPair.contains(c4), true);
        assertEquals(bestPair.contains(c5), true);
        assertEquals(bestPair.contains(c6), true);
        assertEquals(bestPair.contains(c7), true);
        assertEquals(bestPair.contains(c2), false);
        assertEquals(bestPair.contains(c3), false);
        assertEquals(bestPair.size() == 5, true);
    }
}