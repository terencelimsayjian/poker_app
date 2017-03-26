import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.HashSet;


public class DeckTest {
    @Test
    public void drawCard() {
        Deck deck = new Deck();
        assertEquals(deck.dealCard() instanceof Card, true);
    }

    @Test
    public void testUniqueCards() {
        Deck deck = new Deck();
        HashSet<Card> cardHashSet = new HashSet<Card>(52);

        // Without overriding equals() and hashCode() method, this may be a useless test
        for (int i = 0; i < 52; i++) {
            Card c = deck.dealCard();
            assertEquals(cardHashSet.add(c), true);
        }
    }
}
