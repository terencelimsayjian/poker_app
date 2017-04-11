import com.pokerapp.PokerCheckers.StraightFlushHandChecker;
import com.pokerapp.models.Card;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StraightFlushHandCheckerTest {
    @Test
    public void isStraightFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(3, 1));
        cards.add(new Card(4, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));

        assertEquals(StraightFlushHandChecker.isTrue(cards), true);
    }

    @Test
    public void isFlushWithStraightButNotStraightFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(3, 2));
        cards.add(new Card(4, 3));
        cards.add(new Card(5, 1));
        cards.add(new Card(6, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(11, 1));
        cards.add(new Card(13, 1));

        assertEquals(StraightFlushHandChecker.isTrue(cards), false);
    }

    @Test
    public void isFlushWithStraightButNotStraightFlush2() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(5, 1));
        cards.add(new Card(10, 1));
        cards.add(new Card(11, 1));
        cards.add(new Card(12, 1));
        cards.add(new Card(13, 1));

        assertEquals(StraightFlushHandChecker.isTrue(cards), false);
    }

    @Test
    public void isStraightFlushWithLargerStraightAndFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(2, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(4, 3));
        cards.add(new Card(5, 3));
        cards.add(new Card(6, 3));
        cards.add(new Card(7, 3));
        cards.add(new Card(13, 3));

        assertEquals(StraightFlushHandChecker.isTrue(cards), true);
    }


}