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
    public void testThreeOfAKindIsNotQuads () {
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

    @Test
    public void testIsFullHouse () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(7, 1));
        board.add(1, new Card(2, 2));
        board.add(2, new Card(7, 3));
        board.add(3, new Card(1, 4));
        board.add(4, new Card(13, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(7, 2));
        hand.add(1, new Card(1, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFullHouse(), true);
    }

    @Test
    public void testTwoPairIsNotFullHouse () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(7, 1));
        board.add(1, new Card(2, 2));
        board.add(2, new Card(9, 3));
        board.add(3, new Card(1, 4));
        board.add(4, new Card(13, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(7, 2));
        hand.add(1, new Card(1, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFullHouse(), false);
    }

    @Test
    public void testPairIsNotFullHouse () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(7, 1));
        board.add(1, new Card(2, 2));
        board.add(2, new Card(9, 3));
        board.add(3, new Card(1, 4));
        board.add(4, new Card(13, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(8, 2));
        hand.add(1, new Card(1, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFullHouse(), false);
    }

    @Test
    public void testThreeOfAKindIsNotFullHouse () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(7, 1));
        board.add(1, new Card(2, 2));
        board.add(2, new Card(2, 3));
        board.add(3, new Card(2, 4));
        board.add(4, new Card(13, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(8, 2));
        hand.add(1, new Card(1, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFullHouse(), false);
    }

    @Test
    public void testIsFlush () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(7, 1));
        board.add(1, new Card(1, 1));
        board.add(2, new Card(2, 1));
        board.add(3, new Card(3, 4));
        board.add(4, new Card(13, 2));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(8, 1));
        hand.add(1, new Card(4, 1));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFlush(), true);
    }

    @Test
    public void testFourSuitedIsNotFlush () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(7, 1));
        board.add(1, new Card(1, 1));
        board.add(2, new Card(2, 3));
        board.add(3, new Card(3, 4));
        board.add(4, new Card(13, 2));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(8, 2));
        hand.add(1, new Card(4, 1));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFlush(), false);
    }

    @Test
    public void testSixSuitedIsFlush () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(10, 3));
        board.add(1, new Card(11, 3));
        board.add(2, new Card(12, 3));
        board.add(3, new Card(8, 3));
        board.add(4, new Card(4, 2));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(5, 3));
        hand.add(1, new Card(6, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFlush(), true);
    }

}
