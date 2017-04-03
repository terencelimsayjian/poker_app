import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardSuitAnalyserTest {
    @Test
    public void testhasFiveOrMoreOfTheSameSuit() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));

        CardSuitAnalyser csa = new CardSuitAnalyser(cards);
        assertEquals(csa.hasFiveOrMoreOfTheSameSuit(),true);
    }

    @Test
    public void testNotFiveOrMoreOfTheSameSuit() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 2));
        cards.add(new Card(6, 2));
        cards.add(new Card(7, 2));

        CardSuitAnalyser csa = new CardSuitAnalyser(cards);
        assertEquals(csa.hasFiveOrMoreOfTheSameSuit(),false);
    }

    @Test
    public void testGetFlushSuit() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 2));
        cards.add(new Card(7, 2));

        CardSuitAnalyser csa = new CardSuitAnalyser(cards);
        assertEquals(csa.getFlushSuit() == 1,true);
    }

    @Test
    public void testWrongFlushSuit() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 3));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 2));
        cards.add(new Card(5, 2));
        cards.add(new Card(6, 2));
        cards.add(new Card(7, 2));

        CardSuitAnalyser csa = new CardSuitAnalyser(cards);
        assertEquals(csa.getFlushSuit() == 2,false);
    }



}