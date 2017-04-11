import com.pokerapp.models.Card;
import com.pokerapp.models.hands.ThreeOfAKind;
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

}