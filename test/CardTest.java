import static org.junit.Assert.assertEquals;

import com.pokerapp.models.Card;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

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
        assertEquals(aceSpades.toFullString(), "Ace of Spades");
        Card twoSpades = new Card(2, 1);
        assertEquals(twoSpades.toFullString(), "Deuce of Spades");
        Card threeHearts = new Card(3, 2);
        assertEquals(threeHearts.toFullString(), "Three of Hearts");
        Card fourClubs = new Card(4, 3);
        assertEquals(fourClubs.toFullString(), "Four of Clubs");
        Card fiveDiamonds = new Card(5, 4);
        assertEquals(fiveDiamonds.toFullString(), "Five of Diamonds");
        Card sixSpades = new Card(6, 1);
        assertEquals(sixSpades.toFullString(), "Six of Spades");
        Card sevenHearts = new Card(7, 2);
        assertEquals(sevenHearts.toFullString(), "Seven of Hearts");
        Card eightClubs = new Card(8, 3);
        assertEquals(eightClubs.toFullString(), "Eight of Clubs");
        Card NineDiamonds = new Card(9, 4);
        assertEquals(NineDiamonds.toFullString(), "Nine of Diamonds");
        Card tenSpades = new Card(10, 1);
        assertEquals(tenSpades.toFullString(), "Ten of Spades");
        Card jackHearts = new Card(11, 2);
        assertEquals(jackHearts.toFullString(), "Jack of Hearts");
        Card queenClubs = new Card(12, 3);
        assertEquals(queenClubs.toFullString(), "Queen of Clubs");
        Card kingDiamonds = new Card(13, 4);
        assertEquals(kingDiamonds.toFullString(), "King of Diamonds");
    }

    @Test
    public void testCardSort() {
        ArrayList<Card> cards = new ArrayList<Card>();
        int cardQuantity = 50;

        for (int i = 0; i < cardQuantity; i++) {
            int randomCardNumber = (int) Math.random() * 13 + 1;
            cards.add(new Card(randomCardNumber, 1));
        }

        Collections.sort(cards);

        for (int i = 1; i < cardQuantity; i++) {
            Card previousCard = cards.get(i - 1);
            Card currentCard = cards.get(i - 1);
            assertEquals(previousCard.getValue() <= currentCard.getValue(), true);
        }


    }

}
