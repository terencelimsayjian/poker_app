import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StraightFlushHandCheckerTest {
    @Test
    public void isNotStraightFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(7, 1));
        cards.add(new Card(9, 1));
        cards.add(new Card(11, 2));
        cards.add(new Card(13, 3));

        assertEquals(StraightHandChecker.isTrue(cards),false);
    }

}