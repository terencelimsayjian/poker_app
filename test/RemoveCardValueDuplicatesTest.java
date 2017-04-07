import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RemoveCardValueDuplicatesTest {
    @Test
    public void testRemovePairDuplicate() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(4, 2);
        Card c3 = new Card(5, 3);
        Card c4 = new Card(5, 4);
        Card c5 = new Card(6, 1);
        Card c6 = new Card(6, 2);
        Card c7 = new Card(12, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        ArrayList<Card> cardsWithoutDuplicates = RemoveCardValueDuplicates.call(cards);

        assertEquals(cardsWithoutDuplicates.contains(c1), true);
        assertEquals(cardsWithoutDuplicates.contains(c3), true);
        assertEquals(cardsWithoutDuplicates.contains(c5), true);
        assertEquals(cardsWithoutDuplicates.contains(c7), true);
        assertEquals(cardsWithoutDuplicates.contains(c2), false);
        assertEquals(cardsWithoutDuplicates.contains(c4), false);
        assertEquals(cardsWithoutDuplicates.contains(c6), false);
        assertEquals(cardsWithoutDuplicates.size() == 4, true);
    }

    @Test
    public void testRemoveThreeOfAKindDuplicates() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(5, 1);
        Card c3 = new Card(4, 2);
        Card c4 = new Card(5, 2);
        Card c5 = new Card(4, 3);
        Card c6 = new Card(5, 3);
        Card c7 = new Card(7, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        ArrayList<Card> cardsWithoutDuplicates = RemoveCardValueDuplicates.call(cards);

        assertEquals(cardsWithoutDuplicates.contains(c1), true);
        assertEquals(cardsWithoutDuplicates.contains(c2), true);
        assertEquals(cardsWithoutDuplicates.contains(c7), true);
        assertEquals(cardsWithoutDuplicates.contains(c3), false);
        assertEquals(cardsWithoutDuplicates.contains(c4), false);
        assertEquals(cardsWithoutDuplicates.contains(c5), false);
        assertEquals(cardsWithoutDuplicates.contains(c6), false);
        assertEquals(cardsWithoutDuplicates.size() == 3, true);
    }

    @Test
    public void testRemoveFourOfAKind() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(3, 2);
        Card c3 = new Card(4, 3);
        Card c4 = new Card(3, 4);
        Card c5 = new Card(4, 1);
        Card c6 = new Card(3, 2);
        Card c7 = new Card(4, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        ArrayList<Card> cardsWithoutDuplicates = RemoveCardValueDuplicates.call(cards);

        assertEquals(cardsWithoutDuplicates.contains(c1), true);
        assertEquals(cardsWithoutDuplicates.contains(c2), true);
        assertEquals(cardsWithoutDuplicates.contains(c3), false);
        assertEquals(cardsWithoutDuplicates.contains(c4), false);
        assertEquals(cardsWithoutDuplicates.contains(c5), false);
        assertEquals(cardsWithoutDuplicates.contains(c6), false);
        assertEquals(cardsWithoutDuplicates.contains(c7), false);
        assertEquals(cardsWithoutDuplicates.size() == 2, true);
    }

    @Test
    public void testRemoveSevenDuplicates() {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(4, 2);
        Card c3 = new Card(4, 3);
        Card c4 = new Card(4, 4);
        Card c5 = new Card(4, 1);
        Card c6 = new Card(4, 2);
        Card c7 = new Card(4, 3);

        ArrayList<Card> cards = new ArrayList<Card>(7);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        ArrayList<Card> cardsWithoutDuplicates = RemoveCardValueDuplicates.call(cards);

        assertEquals(cardsWithoutDuplicates.contains(c1), true);
        assertEquals(cardsWithoutDuplicates.contains(c3), false);
        assertEquals(cardsWithoutDuplicates.contains(c5), false);
        assertEquals(cardsWithoutDuplicates.contains(c7), false);
        assertEquals(cardsWithoutDuplicates.contains(c2), false);
        assertEquals(cardsWithoutDuplicates.contains(c4), false);
        assertEquals(cardsWithoutDuplicates.contains(c6), false);
        assertEquals(cardsWithoutDuplicates.size() == 1, true);
    }

}