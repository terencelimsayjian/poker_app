import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FourOfAKindTest {
    @Test
    public void testBestFourOfAKind() {
        Card c1 = new Card(2, 1);
        Card c2 = new Card(2, 2);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(2, 4);
        Card c5 = new Card(5, 1);
        Card c6 = new Card(6, 2);
        Card c7 = new Card(7, 3);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        FourOfAKind fourOfAKind = new FourOfAKind(cards);
        ArrayList<Card> bestFourOfAKind = fourOfAKind.getBestHand();
        assertEquals(bestFourOfAKind.contains(c1),true);
        assertEquals(bestFourOfAKind.contains(c2),true);
        assertEquals(bestFourOfAKind.contains(c3),true);
        assertEquals(bestFourOfAKind.contains(c4),true);
        assertEquals(bestFourOfAKind.contains(c7),true);
        assertEquals(bestFourOfAKind.size() == 5,true);
    }

    @Test
    public void testBestFourOfAKindWithPair() {
        Card c1 = new Card(2, 1);
        Card c2 = new Card(2, 2);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(2, 4);
        Card c5 = new Card(5, 1);
        Card c6 = new Card(1, 2);
        Card c7 = new Card(1, 3);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        FourOfAKind fourOfAKind = new FourOfAKind(cards);
        ArrayList<Card> bestFourOfAKind = fourOfAKind.getBestHand();
        assertEquals(bestFourOfAKind.contains(c1),true);
        assertEquals(bestFourOfAKind.contains(c2),true);
        assertEquals(bestFourOfAKind.contains(c3),true);
        assertEquals(bestFourOfAKind.contains(c4),true);
        assertEquals(bestFourOfAKind.contains(c6),true);

        assertEquals(bestFourOfAKind.size() == 5,true);
    }

    @Test
    public void testBestFourOfAKindWithThreeOfAKind() {
        Card c1 = new Card(2, 1);
        Card c2 = new Card(2, 2);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(2, 4);
        Card c5 = new Card(8, 1);
        Card c6 = new Card(8, 2);
        Card c7 = new Card(8, 3);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        FourOfAKind fourOfAKind = new FourOfAKind(cards);
        ArrayList<Card> bestFourOfAKind = fourOfAKind.getBestHand();
        assertEquals(bestFourOfAKind.contains(c1),true);
        assertEquals(bestFourOfAKind.contains(c2),true);
        assertEquals(bestFourOfAKind.contains(c3),true);
        assertEquals(bestFourOfAKind.contains(c4),true);
        assertEquals(bestFourOfAKind.contains(c5),true);

        assertEquals(bestFourOfAKind.size() == 5,true);
    }


}