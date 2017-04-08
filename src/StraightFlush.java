import java.util.ArrayList;

public class StraightFlush extends PokerHand {
    private int ranking = PokerHand.STRAIGHT_FLUSH;;

    public StraightFlush(ArrayList<Card> cards) {
        super(cards);
        calculateBestHand();
    }

    @Override
    protected void calculateBestHand() {
        ArrayList<Card> flushCards = GetFlushCards.call(cards);

        PokerHand straightFlush = new Straight(flushCards);
        bestHand.addAll(straightFlush.getBestHand());
    }

    @Override
    public int compareTo(PokerHand o) {
        int rankingComparison = o.getRanking() - getRanking();

        if (rankingComparison != 0) {
//            return
        }

        return rankingComparison;

    }

    // if same ranking, need to compare high card for straight flush
}
