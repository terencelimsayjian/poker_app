import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CardTest {
    @Test
    public void aceValue() {
        Card c = new Card(1, 1);
        assertEquals(c.getValue(), 14);
    }

    @Test
    public void testIsAce() {
        Card c1 = new Card(Card.ACE, Card.SPADES);
        assertEquals(c1.isAce(), true);

        Card c2 = new Card(2, Card.SPADES);
        assertEquals(c2.isAce(), false);
    }

    @Test
    public void valueToString() {
        Card aceSpades = new Card(1, 1);
        assertEquals(aceSpades.toString(), "Ace of Spades");
        Card twoSpades = new Card(2, 1);
        assertEquals(twoSpades.toString(), "Deuce of Spades");
        Card threeHearts = new Card(3, 2);
        assertEquals(threeHearts.toString(), "Three of Hearts");
        Card fourClubs = new Card(4, 3);
        assertEquals(fourClubs.toString(), "Four of Clubs");
        Card fiveDiamonds = new Card(5, 4);
        assertEquals(fiveDiamonds.toString(), "Five of Diamonds");
        Card sixSpades = new Card(6, 1);
        assertEquals(sixSpades.toString(), "Six of Spades");
        Card sevenHearts = new Card(7, 2);
        assertEquals(sevenHearts.toString(), "Seven of Hearts");
        Card eightClubs = new Card(8, 3);
        assertEquals(eightClubs.toString(), "Eight of Clubs");
        Card NineDiamonds = new Card(9, 4);
        assertEquals(NineDiamonds.toString(), "Nine of Diamonds");
        Card tenSpades = new Card(10, 1);
        assertEquals(tenSpades.toString(), "Ten of Spades");
        Card jackHearts = new Card(11, 2);
        assertEquals(jackHearts.toString(), "Jack of Hearts");
        Card queenClubs = new Card(12, 3);
        assertEquals(queenClubs.toString(), "Queen of Clubs");
        Card kingDiamonds = new Card(13, 4);
        assertEquals(kingDiamonds.toString(), "King of Diamonds");
    }

}
