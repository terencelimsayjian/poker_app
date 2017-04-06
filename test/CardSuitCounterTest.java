import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardSuitCounterTest {
    @Test
    public void testGetHighestOccurrenceOfAnySuitFour() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 2));
        cards.add(new Card(6, 2));
        cards.add(new Card(7, 2));

        CardSuitCounter csa = new CardSuitCounter(cards);
        assertEquals(csa.getHighestOccurrenceOfAnySuit() == 4,true);
    }

    @Test
    public void testGetHighestOccurrenceOfAnySuitFive() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 2));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 3));
        cards.add(new Card(4, 2));
        cards.add(new Card(5, 2));
        cards.add(new Card(6, 2));
        cards.add(new Card(7, 2));

        CardSuitCounter csa = new CardSuitCounter(cards);
        assertEquals(csa.getHighestOccurrenceOfAnySuit() == 5,true);
    }



}