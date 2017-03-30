import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PokerCombinationCheckerTest {
    @Test
    public void testIsQuads () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        Card c1 = new Card(6, 1);
        Card c2 = new Card(2, 2);
        Card c3 = new Card(6, 3);
        Card c4 = new Card(6, 4);
        Card c5 = new Card(13, 1);
        Card c6 = new Card(6, 2);
        Card c7 = new Card(1, 3);

        board.add(0, c1);
        board.add(1, c2);
        board.add(2, c3);
        board.add(3, c4);
        board.add(4, c5);

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, c6);
        hand.add(1, c7);

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
        assertEquals(pcc.isFourOfAKind(), true);

        pcc.getBestFourOfAKind();
        ArrayList<Card> bestHand = pcc.getBestHand();
        assertEquals(bestHand.contains(c1), true);
        assertEquals(bestHand.contains(c3), true);
        assertEquals(bestHand.contains(c4), true);
        assertEquals(bestHand.contains(c6), true);
        assertEquals(bestHand.contains(c7), true);
        assertEquals(bestHand.size() == 5, true);
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
        Card c1 = new Card(7, 1);
        Card c2 = new Card(2, 2);
        Card c3 = new Card(7, 3);
        Card c4 = new Card(1, 4);
        Card c5 = new Card(13, 1);
        Card c6 = new Card(7, 2);
        Card c7 = new Card(1, 3);

        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, c1);
        board.add(1, c2);
        board.add(2, c3);
        board.add(3, c4);
        board.add(4, c5);

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, c6);
        hand.add(1, c7);

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFullHouse(), true);

        pcc.getBestFullHouse();
        ArrayList<Card> bestHand = pcc.getBestHand();
        assertEquals(bestHand.contains(c1), true);
        assertEquals(bestHand.contains(c3), true);
        assertEquals(bestHand.contains(c4), true);
        assertEquals(bestHand.contains(c6), true);
        assertEquals(bestHand.contains(c7), true);
        assertEquals(bestHand.size() == 5, true);
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
    public void testFourOfAKindIsNotFullHouse () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(2, 1));
        board.add(1, new Card(2, 2));
        board.add(2, new Card(2, 3));
        board.add(3, new Card(2, 4));
        board.add(4, new Card(13, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(13, 2));
        hand.add(1, new Card(1, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isFullHouse(), false);
    }

    @Test
    public void testIsFlush () {
        Card c1 = new Card(7, 1);
        Card c2 = new Card(1, 1);
        Card c3 = new Card(2, 1);
        Card c4 = new Card(3, 4);
        Card c5 = new Card(13, 2);
        Card c6 = new Card(8, 1);
        Card c7 = new Card(4, 1);

        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, c1);
        board.add(1, c2);
        board.add(2, c3);
        board.add(3, c4);
        board.add(4, c5);

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, c6);
        hand.add(1, c7);

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
        assertEquals(pcc.isFlush(), true);

        pcc.getBestFlush();
        ArrayList<Card> bestHand = pcc.getBestHand();
        assertEquals(bestHand.contains(c1), true);
        assertEquals(bestHand.contains(c2), true);
        assertEquals(bestHand.contains(c3), true);
        assertEquals(bestHand.contains(c6), true);
        assertEquals(bestHand.contains(c7), true);
        assertEquals(bestHand.size() == 5, true);
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
        Card c1 = new Card(10, 3);
        Card c2 = new Card(11, 3);
        Card c3 = new Card(12, 3);
        Card c4 = new Card(8, 3);
        Card c5 = new Card(4, 2);
        Card c6 = new Card(5, 3);
        Card c7 = new Card(6, 3);

        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, c1);
        board.add(1, c2);
        board.add(2, c3);
        board.add(3, c4);
        board.add(4, c5);

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, c6);
        hand.add(1, c7);

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
        assertEquals(pcc.isFlush(), true);

        pcc.getBestFlush();
        ArrayList<Card> bestHand = pcc.getBestHand();
        assertEquals(bestHand.contains(c1), true);
        assertEquals(bestHand.contains(c2), true);
        assertEquals(bestHand.contains(c3), true);
        assertEquals(bestHand.contains(c4), true);
        assertEquals(bestHand.contains(c7), true);
        assertEquals(bestHand.size() == 5, true);
    }

    @Test
    public void testIsStraight () {
        Card c1 = new Card(7, 1);
        Card c2 = new Card(8, 2);
        Card c3 = new Card(9, 3);
        Card c4 = new Card(1, 4);
        Card c5 = new Card(3, 1);
        Card c6 = new Card(10, 2);
        Card c7 = new Card(11, 3);


        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, c1);
        board.add(1, c2);
        board.add(2, c3);
        board.add(3, c4);
        board.add(4, c5);

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, c6);
        hand.add(1, c7);

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
        assertEquals(pcc.isStraight(), true);

        pcc.getBestStraight();
        ArrayList<Card> bestHand = pcc.getBestHand();
        assertEquals(bestHand.contains(c1), true);
        assertEquals(bestHand.contains(c2), true);
        assertEquals(bestHand.contains(c3), true);
        assertEquals(bestHand.contains(c6), true);
        assertEquals(bestHand.contains(c7), true);
        assertEquals(bestHand.size() == 5, true);
    }

    @Test
    public void test10ToAceIsStraight () {
        Card c1 = new Card(10, 1);
        Card c2 = new Card(11, 2);
        Card c3 = new Card(1, 3);
        Card c4 = new Card(4, 4);
        Card c5 = new Card(3, 1);
        Card c6 = new Card(12, 2);
        Card c7 = new Card(13, 3);

        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, c1);
        board.add(1, c2);
        board.add(2, c3);
        board.add(3, c4);
        board.add(4, c5);

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, c6);
        hand.add(1, c7);

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
        assertEquals(pcc.isStraight(), true);

        pcc.getBestStraight();
        ArrayList<Card> bestHand = pcc.getBestHand();
        assertEquals(bestHand.contains(c1), true);
        assertEquals(bestHand.contains(c2), true);
        assertEquals(bestHand.contains(c3), true);
        assertEquals(bestHand.contains(c6), true);
        assertEquals(bestHand.contains(c7), true);
        assertEquals(bestHand.size() == 5, true);
    }

    @Test
    public void testJackToTwoIsNotStraight () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(2, 1));
        board.add(1, new Card(11, 2));
        board.add(2, new Card(1, 3));
        board.add(3, new Card(5, 4));
        board.add(4, new Card(6, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(12, 2));
        hand.add(1, new Card(13, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isStraight(), false);
    }

    @Test
    public void testFourCardStraightIsNotStraight () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(2, 1));
        board.add(1, new Card(8, 2));
        board.add(2, new Card(9, 3));
        board.add(3, new Card(1, 4));
        board.add(4, new Card(3, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(10, 2));
        hand.add(1, new Card(11, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isStraight(), false);
    }

    @Test
    public void testSixCardStraightIsStraight () {
        Card c1 = new Card(7, 1);
        Card c2 = new Card(8, 2);
        Card c3 = new Card(9, 3);
        Card c4 = new Card(12, 4);
        Card c5 = new Card(3, 1);
        Card c6 = new Card(10, 2);
        Card c7 = new Card(11, 3);

        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, c1);
        board.add(1, c2);
        board.add(2, c3);
        board.add(3, c4);
        board.add(4, c5);

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, c6);
        hand.add(1, c7);

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
        assertEquals(pcc.isStraight(), true);

        pcc.getBestStraight();
        ArrayList<Card> bestHand = pcc.getBestHand();
        assertEquals(bestHand.contains(c2), true);
        assertEquals(bestHand.contains(c3), true);
        assertEquals(bestHand.contains(c4), true);
        assertEquals(bestHand.contains(c6), true);
        assertEquals(bestHand.contains(c7), true);
        assertEquals(bestHand.size() == 5, true);
    }

    @Test
    public void testSevenCardStraightIsStraight () {
        Card c1 = new Card(7, 1);
        Card c2 = new Card(8, 2);
        Card c3 = new Card(9, 3);
        Card c4 = new Card(12, 4);
        Card c5 = new Card(13, 1);
        Card c6 = new Card(10, 2);
        Card c7 = new Card(11, 3);

        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, c1);
        board.add(1, c2);
        board.add(2, c3);
        board.add(3, c4);
        board.add(4, c5);

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, c6);
        hand.add(1, c7);

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
        assertEquals(pcc.isStraight(), true);

        pcc.getBestStraight();
        ArrayList<Card> bestHand = pcc.getBestHand();
        assertEquals(bestHand.contains(c3), true);
        assertEquals(bestHand.contains(c4), true);
        assertEquals(bestHand.contains(c5), true);
        assertEquals(bestHand.contains(c6), true);
        assertEquals(bestHand.contains(c7), true);
        assertEquals(bestHand.size() == 5, true);
    }

    @Test
    public void testFlushIsNotStraight () {
        ArrayList<Card> board = new ArrayList<Card>(5);
        board.add(0, new Card(7, 1));
        board.add(1, new Card(8, 1));
        board.add(2, new Card(9, 3));
        board.add(3, new Card(2, 1));
        board.add(4, new Card(3, 1));

        ArrayList<Card> hand = new ArrayList<Card>(2);
        hand.add(0, new Card(10, 1));
        hand.add(1, new Card(11, 3));

        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);

        assertEquals(pcc.isStraight(), false);
    }
//
//    @Test
//    public void testIsThreeOfAKind () {
//        ArrayList<Card> board = new ArrayList<Card>(5);
//        board.add(0, new Card(7, 1));
//        board.add(1, new Card(7, 2));
//        board.add(2, new Card(7, 3));
//        board.add(3, new Card(12, 4));
//        board.add(4, new Card(3, 1));
//
//        ArrayList<Card> hand = new ArrayList<Card>(2);
//        hand.add(0, new Card(10, 2));
//        hand.add(1, new Card(11, 3));
//
//        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
//
//        assertEquals(pcc.isThreeOfAKind(), true);
//    }
//
//    @Test
//    public void testPairIsNotThreeOfAKind () {
//        ArrayList<Card> board = new ArrayList<Card>(5);
//        board.add(0, new Card(7, 1));
//        board.add(1, new Card(7, 2));
//        board.add(2, new Card(1, 3));
//        board.add(3, new Card(12, 4));
//        board.add(4, new Card(3, 1));
//
//        ArrayList<Card> hand = new ArrayList<Card>(2);
//        hand.add(0, new Card(10, 2));
//        hand.add(1, new Card(11, 3));
//
//        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
//
//        assertEquals(pcc.isThreeOfAKind(), false);
//    }
//
//    @Test
//    public void testFullHouseIsNotThreeOfAKind () {
//        ArrayList<Card> board = new ArrayList<Card>(5);
//        board.add(0, new Card(7, 1));
//        board.add(1, new Card(7, 2));
//        board.add(2, new Card(7, 3));
//        board.add(3, new Card(12, 4));
//        board.add(4, new Card(3, 1));
//
//        ArrayList<Card> hand = new ArrayList<Card>(2);
//        hand.add(0, new Card(11, 2));
//        hand.add(1, new Card(11, 3));
//
//        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
//
//        assertEquals(pcc.isThreeOfAKind(), false);
//    }
//
//    @Test
//    public void testIsTwoPair () {
//        ArrayList<Card> board = new ArrayList<Card>(5);
//        board.add(0, new Card(7, 1));
//        board.add(1, new Card(7, 2));
//        board.add(2, new Card(9, 3));
//        board.add(3, new Card(12, 4));
//        board.add(4, new Card(3, 1));
//
//        ArrayList<Card> hand = new ArrayList<Card>(2);
//        hand.add(0, new Card(1, 2));
//        hand.add(1, new Card(1, 3));
//
//        PokerCombinationChecker pcc = new PokerCombinationChecker(board, hand);
//
//        assertEquals(pcc.isTwoPair(), true);
//    }

}
