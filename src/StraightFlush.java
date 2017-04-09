import java.util.ArrayList;

public class StraightFlush extends PokerHand {
    private int highestStraightCardValue;

    public StraightFlush(ArrayList<Card> cards) {
        super(cards, PokerHand.STRAIGHT_FLUSH);
        calculateBestHand();
        setHighestStraightCardValue();
    }

    private void setHighestStraightCardValue() {
        if (StraightHandChecker.hasAceToFiveStraight(bestHand)) {
            highestStraightCardValue = bestHand.get(bestHand.size() - 2).getValue();
        } else {
            highestStraightCardValue = bestHand.get(bestHand.size() - 1).getValue();
        }
    }

    public int getHighestStraightCardValue() {
        return highestStraightCardValue;
    }

    @Override
    protected void calculateBestHand() {
        ArrayList<Card> flushCards = GetFlushCards.call(cards);

        PokerHand straightFlush = new Straight(flushCards);
        bestHand.addAll(straightFlush.getBestHand());
    }

    @Override
    protected int subCompare(PokerHand o) {
        StraightFlush sf = (StraightFlush) o;
        return highestStraightCardValue - sf.getHighestStraightCardValue();
    }
}
