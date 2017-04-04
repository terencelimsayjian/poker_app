import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokerStraightsAnalyserTest {
    @Test
    public void testHasFiveOrMoreConsecutiveValues() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(13, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(11, 1));

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        assertEquals(cca.getHasFiveOrMoreConsecutiveValues(), true);
    }

    @Test
    public void testDoesNotHasFiveOrMoreConsecutiveValues() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(13, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(12, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(11, 1));

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        assertEquals(cca.getHasFiveOrMoreConsecutiveValues(), false);
    }

    @Test
    public void testHasFiveOrMoreConsecutiveValuesStartingWithAce() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(1, 1));
        cards.add(new Card(12, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(11, 1));

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        assertEquals(cca.getHasFiveOrMoreConsecutiveValues(), true);
    }

    @Test
    public void testHasFiveOrMoreConsecutiveValuesWithDuplicates() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(6, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(4, 3));
        cards.add(new Card(3, 4));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 2));
        cards.add(new Card(2, 1));

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);

        assertEquals(cca.getHasFiveOrMoreConsecutiveValues(), true);
    }

    @Test
    public void testGetStraightCards() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(3, 1);
        Card c2 = new Card(4, 2);
        Card c3 = new Card(5, 3);
        Card c4 = new Card(6, 4);
        Card c5 = new Card(7, 1);
        Card c6 = new Card(10, 2);
        Card c7 = new Card(12, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        ArrayList<Card> straightCards = cca.getBestMadeStraight();
        assertEquals(straightCards.contains(c1), true);
        assertEquals(straightCards.contains(c2), true);
        assertEquals(straightCards.contains(c3), true);
        assertEquals(straightCards.contains(c4), true);
        assertEquals(straightCards.contains(c5), true);
        assertEquals(straightCards.size() == 5, true);
    }

    @Test
    public void testGetStraightCardsWithDuplicates() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(8, 1);
        Card c2 = new Card(9, 2);
        Card c3 = new Card(10, 3);
        Card c4 = new Card(10, 4);
        Card c5 = new Card(10, 1);
        Card c6 = new Card(11, 2);
        Card c7 = new Card(12, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        ArrayList<Card> straightCards = cca.getBestMadeStraight();
        assertEquals(straightCards.contains(c1), true);
        assertEquals(straightCards.contains(c2), true);
        assertEquals(straightCards.contains(c3), true);
        assertEquals(straightCards.contains(c6), true);
        assertEquals(straightCards.contains(c7), true);
        assertEquals(straightCards.size() == 5, true);
    }

    @Test
    public void testGetStraightCardsWithOtherConsecutiveCards() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(3, 1);
        Card c2 = new Card(4, 2);
        Card c3 = new Card(5, 3);
        Card c4 = new Card(6, 4);
        Card c5 = new Card(10, 1);
        Card c6 = new Card(11, 2);
        Card c7 = new Card(7, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        ArrayList<Card> straightCards = cca.getBestMadeStraight();
        System.out.println(straightCards.toString());
        assertEquals(straightCards.contains(c1), true);
        assertEquals(straightCards.contains(c2), true);
        assertEquals(straightCards.contains(c3), true);
        assertEquals(straightCards.contains(c4), true);
        assertEquals(straightCards.contains(c7), true);
        assertEquals(straightCards.size() == 5, true);
    }

    @Test
    public void testAceToFiveStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(2, 1);
        Card c2 = new Card(1, 2);
        Card c3 = new Card(3, 3);
        Card c4 = new Card(8, 4);
        Card c5 = new Card(10, 1);
        Card c6 = new Card(4, 2);
        Card c7 = new Card(5, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        ArrayList<Card> straightCards = cca.getBestMadeStraight();
        System.out.println(straightCards.toString());
        assertEquals(straightCards.contains(c1), true);
        assertEquals(straightCards.contains(c2), true);
        assertEquals(straightCards.contains(c3), true);
        assertEquals(straightCards.contains(c6), true);
        assertEquals(straightCards.contains(c7), true);
        assertEquals(straightCards.size() == 5, true);
    }

    @Test
    public void testSixCardStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(3, 1);
        Card c2 = new Card(5, 2);
        Card c3 = new Card(12, 3);
        Card c4 = new Card(7, 4);
        Card c5 = new Card(6, 1);
        Card c6 = new Card(8, 2);
        Card c7 = new Card(4, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        ArrayList<Card> straightCards = cca.getBestMadeStraight();
        System.out.println(straightCards.toString());
        assertEquals(straightCards.contains(c2), true);
        assertEquals(straightCards.contains(c4), true);
        assertEquals(straightCards.contains(c5), true);
        assertEquals(straightCards.contains(c6), true);
        assertEquals(straightCards.contains(c7), true);
        assertEquals(straightCards.size() == 5, true);
    }

    @Test
    public void testSevenCardStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(3, 1);
        Card c2 = new Card(5, 2);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(7, 4);
        Card c5 = new Card(6, 1);
        Card c6 = new Card(8, 2);
        Card c7 = new Card(4, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        ArrayList<Card> straightCards = cca.getBestMadeStraight();
        System.out.println(straightCards.toString());
        assertEquals(straightCards.contains(c2), true);
        assertEquals(straightCards.contains(c4), true);
        assertEquals(straightCards.contains(c5), true);
        assertEquals(straightCards.contains(c6), true);
        assertEquals(straightCards.contains(c7), true);
        assertEquals(straightCards.size() == 5, true);
    }

    @Test
    public void testSixCardStraightAceStraightReturnsTwoToSixStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(3, 1);
        Card c2 = new Card(5, 2);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(12, 4);
        Card c5 = new Card(6, 1);
        Card c6 = new Card(1, 2);
        Card c7 = new Card(4, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        ArrayList<Card> straightCards = cca.getBestMadeStraight();
        System.out.println(straightCards.toString());
        assertEquals(straightCards.contains(c1), true);
        assertEquals(straightCards.contains(c2), true);
        assertEquals(straightCards.contains(c3), true);
        assertEquals(straightCards.contains(c5), true);
        assertEquals(straightCards.contains(c7), true);
        assertEquals(straightCards.size() == 5, true);
    }

    @Test
    public void testSevenCardStraightAceStraightReturnsTwoToSixStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = new Card(3, 1);
        Card c2 = new Card(5, 2);
        Card c3 = new Card(2, 3);
        Card c4 = new Card(7, 4);
        Card c5 = new Card(6, 1);
        Card c6 = new Card(1, 2);
        Card c7 = new Card(4, 1);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);

        PokerStraightsAnalyser cca = new PokerStraightsAnalyser(cards);
        ArrayList<Card> straightCards = cca.getBestMadeStraight();
        System.out.println(straightCards.toString());
        assertEquals(straightCards.contains(c1), true);
        assertEquals(straightCards.contains(c2), true);
        assertEquals(straightCards.contains(c4), true);
        assertEquals(straightCards.contains(c5), true);
        assertEquals(straightCards.contains(c7), true);
        assertEquals(straightCards.size() == 5, true);
    }


}