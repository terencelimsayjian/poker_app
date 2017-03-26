import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PokerCombinationCheckerTest {
    @Test
    public void testIsQuads () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(6, 1));
        board.add(1, new Card(2, 2));
        board.add(2, new Card(6, 3));
        board.add(3, new Card(6, 4));
        board.add(4, new Card(13, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(6, 2));
        hand.add(1, new Card(1, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFourOfAKind(), true);
    }

    @Test
    public void testIsNotQuads () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(6, 1));
        board.add(1, new Card(2, 2));
        board.add(2, new Card(6, 3));
        board.add(3, new Card(6, 4));
        board.add(4, new Card(13, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(7, 2));
        hand.add(1, new Card(1, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFourOfAKind(), false);
    }


}
