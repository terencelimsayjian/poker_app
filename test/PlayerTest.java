import com.pokerapp.models.Card;
import com.pokerapp.models.Player;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
//    @Before TODO: Explore

    @Test
    public void testAddCardToHand() {
        Player p = new Player("TestPlayer");

        p.addFirstCardToHand(new Card(1, 1));
        p.addSecondCardToHand(new Card(1, 2));
        ArrayList<Card> hand = p.getHand();

        assertEquals(hand.get(0) instanceof Card, true);
        assertEquals(hand.get(1) instanceof Card, true);
    }

    @Test
    public void testResetHand() {
        Player p = new Player("TestPlayer");
        p.addFirstCardToHand(new Card(1, 1));
        p.addSecondCardToHand(new Card(1, 2));
        ArrayList<Card> hand = p.getHand();

        p.resetHand();

        assertEquals(hand.size(), 0);
    }

}
