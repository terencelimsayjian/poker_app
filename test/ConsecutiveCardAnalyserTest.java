import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConsecutiveCardAnalyserTest {
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

        ConsecutiveCardAnalyser cca = new ConsecutiveCardAnalyser(cards);
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

        ConsecutiveCardAnalyser cca = new ConsecutiveCardAnalyser(cards);
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

        ConsecutiveCardAnalyser cca = new ConsecutiveCardAnalyser(cards);
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

        ConsecutiveCardAnalyser cca = new ConsecutiveCardAnalyser(cards);

        assertEquals(cca.getHasFiveOrMoreConsecutiveValues(), true);
    }


}