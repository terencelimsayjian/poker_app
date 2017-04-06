import java.util.ArrayList;
import java.util.Collections;

public class FlushHand extends PokerHand {
    private CardSuitCounter cardSuitCounter;

    public FlushHand(ArrayList<Card> cards) {
        super(cards);
        cardSuitCounter = new CardSuitCounter(cards);


        if (this.isTrue()) {
            calculateBestHand();
        }
    }

    public boolean isTrue() {
        boolean hasFlush = cardSuitCounter.getHighestOccurrenceOfAnySuit() >= 5;

        return hasFlush;
    }

    @Override
    public ArrayList<Card> getBestHand() {
        return bestHand;
    }

    @Override
    protected void calculateBestHand () {
        int flushSuit = getFlushSuit();

        addCardsWithSuitToBestHand(flushSuit);
        Collections.sort(bestHand);
        shiftCardsFromBestHandUntilFiveRemain();
    }

    private int getFlushSuit() {
        return cardSuitCounter.getFlushSuit();
    }

    private void shiftCardsFromBestHandUntilFiveRemain() {
        while (bestHand.size() > 5) {
            bestHand.remove(0);
        }
    }

    private void addCardsWithSuitToBestHand(int suit) {
        for (Card card : cards) {
            if (card.getSuit() == suit) {
                bestHand.add(card);
            }
        }
    }



    // Encapsulation: Poker hands should be able to compare themselves
    // Demeter's Law: Decide who needs to own what behaviour
    // Game class: Shouldn't need to know how to compare, it only cares about the winner

    // Come up with the psedo code of the flow, and go from there
    // Probably deal a hand to each player, and determine who wins with what hand

    /*
    *
    * GameRound starts
    * Deck gets shuffled, containing 52 unique Cards
    * Players get dealt Hands containing two Cards
    * Board containing Five Cards gets dealt
    * Players compare Hands
    *   Player.getHand().compare(Hand)
    *
    * Hands need to know how it wins. How would you compare a MadeHand to another Hand?
    *
    * 1. Abstract class containing all the rankings
    * 2. Strength value instance variable on each of the subclass
    *
    *
    * */
}
