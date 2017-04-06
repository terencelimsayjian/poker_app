import java.util.ArrayList;

public abstract class BestPokerCombination {

//     get best Poker Hand = Something that inherits from poker hand

    public static PokerHand get(ArrayList<Card> cards) {
        PokerHand bestPokerHand;

        // Straight Flush
//        if (FourOfAKindHandChecker.isTrue(cards)) {
            bestPokerHand = new FourOfAKind(cards);
//        }
//
// else if (FullHouseHandChecker.isTrue(cards)) {
//            bestPokerHand = PokerHand.FULL_HOUSE;
//        } else if (FlushHandChecker.isTrue(cards)) {
//            bestPokerHand = PokerHand.FLUSH;
//        } else if (StraightHandChecker.isTrue(cards)) {
//            bestPokerHand = PokerHand.STRAIGHT;
//        } else if (ThreeOfAKindHandChecker.isTrue(cards)) {
//            bestPokerHand = PokerHand.THREE_OF_A_KIND;
//        } else if (TwoPairHandChecker.isTrue(cards)) {
//            bestPokerHand = PokerHand.TWO_PAIR;
//        } else if (PairHandChecker.isTrue(cards)) {
//            bestPokerHand = PokerHand.PAIR;
//        } else if (HighCardHandChecker.isTrue(cards)) {
//            bestPokerHand = PokerHand.HIGH_CARD;
//        }
//
        return bestPokerHand;
    }

}
