import com.pokerapp.PokerCheckers.StraightHandChecker;
import com.pokerapp.models.Card;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StraightHandCheckerTest {
    @Test
    public void testIsStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(4, 3));
        cards.add(new Card(5, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));

        assertEquals(StraightHandChecker.isTrue(cards),true);
    }

    @Test
    public void testSixCardStraightIsStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(4, 3));
        cards.add(new Card(5, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 2));
        cards.add(new Card(13, 3));

        assertEquals(StraightHandChecker.isTrue(cards),true);
    }

    @Test
    public void testSevenCardStraightIsStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(9, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(4, 3));
        cards.add(new Card(5, 4));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(8, 3));

        assertEquals(StraightHandChecker.isTrue(cards),true);
    }

    @Test
    public void shuffledStraightIsStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(6, 1));
        cards.add(new Card(9, 2));
        cards.add(new Card(8, 3));
        cards.add(new Card(10, 4));
        cards.add(new Card(1, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(3, 3));

        assertEquals(StraightHandChecker.isTrue(cards),true);
    }

    @Test
    public void testAceToFiveIsStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(7, 1));
        cards.add(new Card(9, 2));
        cards.add(new Card(5, 3));
        cards.add(new Card(4, 4));
        cards.add(new Card(3, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(1, 3));

        assertEquals(StraightHandChecker.isTrue(cards),true);
    }

    @Test
    public void testTenToKingIsStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(11, 1));
        cards.add(new Card(3, 2));
        cards.add(new Card(4, 3));
        cards.add(new Card(10, 4));
        cards.add(new Card(12, 1));
        cards.add(new Card(1, 1));
        cards.add(new Card(13, 3));

        assertEquals(StraightHandChecker.isTrue(cards),true);
    }

    @Test
    public void testDuplicateCards() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(2, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(1, 4));
        cards.add(new Card(2, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 3));

        assertEquals(StraightHandChecker.isTrue(cards), true);
    }
}