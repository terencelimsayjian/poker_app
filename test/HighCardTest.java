import com.pokerapp.models.Card;
import com.pokerapp.models.hands.HighCard;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HighCardTest {
    @Test
    public void testHighCard() {
        Card c1 = new Card(1, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(5, 3);
        Card c4 = new Card(6, 1);
        Card c5 = new Card(7, 2);
        Card c6 = new Card(9, 1);
        Card c7 = new Card(12, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        HighCard highCard = new HighCard(cards);
        ArrayList<Card> bestHighCard = highCard.getBestHand();
        assertEquals(bestHighCard.contains(c1), true);
        assertEquals(bestHighCard.contains(c4), true);
        assertEquals(bestHighCard.contains(c5), true);
        assertEquals(bestHighCard.contains(c6), true);
        assertEquals(bestHighCard.contains(c7), true);
        assertEquals(bestHighCard.contains(c2), false);
        assertEquals(bestHighCard.contains(c3), false);
        assertEquals(bestHighCard.size() == 5, true);
    }

    @Test
    public void testOtherHighCards() {
        Card c1 = new Card(1, 1);
        Card c2 = new Card(13, 2);
        Card c3 = new Card(12, 3);
        Card c4 = new Card(10, 1);
        Card c5 = new Card(8, 2);
        Card c6 = new Card(6, 1);
        Card c7 = new Card(2, 2);

        ArrayList<Card> cards = new ArrayList<Card>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        HighCard highCard = new HighCard(cards);
        ArrayList<Card> bestHighCard = highCard.getBestHand();
        assertEquals(bestHighCard.contains(c1), true);
        assertEquals(bestHighCard.contains(c2), true);
        assertEquals(bestHighCard.contains(c3), true);
        assertEquals(bestHighCard.contains(c4), true);
        assertEquals(bestHighCard.contains(c5), true);
        assertEquals(bestHighCard.contains(c6), false);
        assertEquals(bestHighCard.contains(c7), false);
        assertEquals(bestHighCard.size() == 5, true);
    }
}