import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokerCardValueAnalyserTest {
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.countCombinations(PokerCardValueAnalyser.SINGLE_CARD) == 7, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.countCombinations(PokerCardValueAnalyser.PAIR) == 1, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.countCombinations(PokerCardValueAnalyser.PAIR) == 2, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.countCombinations(PokerCardValueAnalyser.THREE_OF_A_KIND) == 1, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.countCombinations(PokerCardValueAnalyser.FOUR_OF_A_KIND) == 1, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.getHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD) == 13, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.getHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD) == 14, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.getHighestCardOfCombination(PokerCardValueAnalyser.PAIR) == 4, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.getHighestCardOfCombination(PokerCardValueAnalyser.THREE_OF_A_KIND) == 13, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.getHighestCardOfCombination(PokerCardValueAnalyser.FOUR_OF_A_KIND) == 12, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.getNextHighestCardOfCombination(PokerCardValueAnalyser.SINGLE_CARD, Card.KING) == 12, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.getNextHighestCardOfCombination(PokerCardValueAnalyser.PAIR, Card.JACK) == 9, true);
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

        PokerCardValueAnalyser cva = new PokerCardValueAnalyser(cards);
        assertEquals(cva.getNextHighestCardOfCombination(PokerCardValueAnalyser.THREE_OF_A_KIND, Card.KING) == 8, true);
    }

}