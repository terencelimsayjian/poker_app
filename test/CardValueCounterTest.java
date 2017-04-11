import com.pokerapp.helpers.CardValueCounter;
import com.pokerapp.models.Card;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardValueCounterTest {
    @Test
    public void testCountSingleCards() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.countCombinations(CardValueCounter.SINGLE_CARD) == 7, true);
    }

    @Test
    public void testCountPairs() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.countCombinations(CardValueCounter.PAIR) == 1, true);
    }

    @Test
    public void testCountTwoPairs() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.countCombinations(CardValueCounter.PAIR) == 2, true);
    }

    @Test
    public void testCountThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(1, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.countCombinations(CardValueCounter.THREE_OF_A_KIND) == 1, true);
    }

    @Test
    public void testCountFourOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(7, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.countCombinations(CardValueCounter.FOUR_OF_A_KIND) == 1, true);
    }

    @Test
    public void testGetHighestSingleCard() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(13, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.getHighestCardOfCombination(CardValueCounter.SINGLE_CARD) == 13, true);
    }

    @Test
    public void testGetHighestSingleCardAce() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(1, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.getHighestCardOfCombination(CardValueCounter.SINGLE_CARD) == 14, true);
    }

    @Test
    public void testGetHighestPair() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(2, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(3, 4));
        cards.add(new Card(4, 1));
        cards.add(new Card(4, 2));
        cards.add(new Card(1, 3));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.getHighestCardOfCombination(CardValueCounter.PAIR) == 4, true);
    }

    @Test
    public void testGetHighestThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(6, 1));
        cards.add(new Card(6, 2));
        cards.add(new Card(6, 3));
        cards.add(new Card(13, 1));
        cards.add(new Card(13, 2));
        cards.add(new Card(13,3));
        cards.add(new Card(1, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.getHighestCardOfCombination(CardValueCounter.THREE_OF_A_KIND) == 13, true);
    }

    @Test
    public void testGetHighestFourOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(12, 1));
        cards.add(new Card(12, 1));
        cards.add(new Card(12, 1));
        cards.add(new Card(12, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.getHighestCardOfCombination(CardValueCounter.FOUR_OF_A_KIND) == 12, true);
    }

    @Test
    public void testGetNextHighestSingleCard() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(7, 1));
        cards.add(new Card(8, 1));
        cards.add(new Card(9, 1));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 1));
        cards.add(new Card(12, 1));
        cards.add(new Card(13, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.getNextHighestCardOfCombination(CardValueCounter.SINGLE_CARD, Card.KING) == 12, true);
    }

    @Test
    public void testGetNextHighestPair() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(7, 1));
        cards.add(new Card(7, 2));
        cards.add(new Card(8, 3));
        cards.add(new Card(9, 4));
        cards.add(new Card(9, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(11, 3));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.getNextHighestCardOfCombination(CardValueCounter.PAIR, Card.JACK) == 9, true);
    }

    @Test
    public void testGetNextHighestThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(8, 1));
        cards.add(new Card(8, 1));
        cards.add(new Card(8, 1));
        cards.add(new Card(10, 1));
        cards.add(new Card(13, 1));
        cards.add(new Card(13, 1));
        cards.add(new Card(13, 1));

        CardValueCounter cva = new CardValueCounter(cards);
        assertEquals(cva.getNextHighestCardOfCombination(CardValueCounter.THREE_OF_A_KIND, Card.KING) == 8, true);
    }

}