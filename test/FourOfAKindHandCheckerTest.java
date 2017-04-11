import com.pokerapp.PokerCheckers.FourOfAKindHandChecker;
import com.pokerapp.models.Card;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FourOfAKindHandCheckerTest {
    @Test
    public void testIsFourOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(5, 1));

        assertEquals(FourOfAKindHandChecker.isTrue(cards),true);
    }

    @Test
    public void testIsNotFourOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(3, 1));
        cards.add(new Card(5, 1));
        cards.add(new Card(7, 1));

        assertEquals(FourOfAKindHandChecker.isTrue(cards),false);
    }

    @Test
    public void testFourCardsIsNotFourOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));
        cards.add(new Card(2, 1));

        assertEquals(FourOfAKindHandChecker.isTrue(cards),false);
    }

}