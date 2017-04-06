import java.util.*;

public class BestPokerCombination {
    private ArrayList<Card> cards = new ArrayList<Card>(7);
    private ArrayList<Card> bestHand = new ArrayList<Card>(5);

    CardValueCounter cardValueCounter;
    CardSuitCounter cardSuitCounter;
    PokerStraightsAnalyser pokerStraightsAnalyser;

    private boolean hasFiveOrMoreConsecutiveValues;
    private boolean hasFiveOrMoreOfSameSuit;

    public BestPokerCombination(ArrayList<Card> board, ArrayList<Card> hand) {
        this.cards.addAll(0, board);
        this.cards.addAll(5, hand);

        // TODO: Check is sort should be called in the constructor
        Collections.sort(this.cards);

        cardValueCounter = new CardValueCounter(this.cards);
        cardSuitCounter = new CardSuitCounter(this.cards);
        pokerStraightsAnalyser = new PokerStraightsAnalyser(this.cards);

        hasFiveOrMoreOfSameSuit = cardSuitCounter.getHighestOccurrenceOfAnySuit() >= 5;
        hasFiveOrMoreConsecutiveValues = pokerStraightsAnalyser.getHasFiveOrMoreConsecutiveValues();

        // TODO: Check if heavy lifting should be done here
        calculateBestHand();
    }

    public ArrayList<Card> getBestHand() {
        return bestHand;
    }

    public void calculateBestHand() {

        FlushHand flushHand = new FlushHand(cards);

//         if (isStraightFlush()) {
//            addBestStraightFlushToBestHand();
//        } else if (cardValueCounter.isFourOfAKind()) {
//             bestHand.addAll(cardValueCounter.getBestFourOfAKind());
//        } else if (cardValueCounter.isFullHouse()) {
//             bestHand.addAll(cardValueCounter.getBestFullHouse());
//        } else if (flushHand.isTrue()) {
//            bestHand.addAll(cardSuitCounter.getBestMadeFlush());
//        } else if (isStraight()) {
//            addBestStraightToBestHand();
//        } else if (cardValueCounter.isThreeOfAKind()) {
//             bestHand.addAll(cardValueCounter.getBestThreeOfAKind());
//        } else if (cardValueCounter.isTwoPair()) {
//             bestHand.addAll(cardValueCounter.getBestTwoPair());
//        } else if (cardValueCounter.isPair()) {
//             bestHand.addAll(cardValueCounter.getBestPair());
//        } else if (cardValueCounter.isHighCard()) {
//             bestHand.addAll(cardValueCounter.getBestHighCard());
//        }
    }


}
