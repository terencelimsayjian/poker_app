import com.pokerapp.models.Card;
import com.pokerapp.models.hands.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class PokerHandTest {
    @Test
    public void compareTo() {

        ArrayList<PokerHand> pokerHands = new ArrayList<PokerHand>();

        ArrayList<Card> straightFlushCards = new ArrayList<Card>(5);
        straightFlushCards.add(new Card(2, 1));
        straightFlushCards.add(new Card(3, 1));
        straightFlushCards.add(new Card(4, 1));
        straightFlushCards.add(new Card(5, 1));
        straightFlushCards.add(new Card(6, 1));
        PokerHand straightFlush = new StraightFlush(straightFlushCards);

        ArrayList<Card> fourOfAKindCards = new ArrayList<Card>(5);
        fourOfAKindCards.add(new Card(1, 1));
        fourOfAKindCards.add(new Card(13, 4));
        fourOfAKindCards.add(new Card(13, 3));
        fourOfAKindCards.add(new Card(13, 2));
        fourOfAKindCards.add(new Card(13, 1));
        PokerHand fourOfAKind = new FourOfAKind(fourOfAKindCards);

        ArrayList<Card> fullHouseCards = new ArrayList<Card>(5);
        fullHouseCards.add(new Card(2, 1));
        fullHouseCards.add(new Card(5, 4));
        fullHouseCards.add(new Card(2, 3));
        fullHouseCards.add(new Card(5, 2));
        fullHouseCards.add(new Card(2, 1));
        PokerHand fullHouse = new FullHouse(fullHouseCards);

        ArrayList<Card> flushCards = new ArrayList<Card>(5);
        flushCards.add(new Card(1, 2));
        flushCards.add(new Card(3, 2));
        flushCards.add(new Card(4, 2));
        flushCards.add(new Card(7, 2));
        flushCards.add(new Card(9, 2));
        PokerHand flush = new Flush(flushCards);

        ArrayList<Card> straightCards = new ArrayList<Card>(5);
        straightCards.add(new Card(4, 1));
        straightCards.add(new Card(5, 4));
        straightCards.add(new Card(6, 3));
        straightCards.add(new Card(7, 2));
        straightCards.add(new Card(8, 1));
        PokerHand straight = new Straight(straightCards);

        ArrayList<Card> threeOfAKindCards = new ArrayList<Card>(5);
        threeOfAKindCards.add(new Card(1, 1));
        threeOfAKindCards.add(new Card(13, 4));
        threeOfAKindCards.add(new Card(13, 3));
        threeOfAKindCards.add(new Card(13, 2));
        threeOfAKindCards.add(new Card(4, 1));
        PokerHand threeOfAKind = new ThreeOfAKind(threeOfAKindCards);

        ArrayList<Card> twoPairCards = new ArrayList<Card>(5);
        twoPairCards.add(new Card(1, 1));
        twoPairCards.add(new Card(13, 4));
        twoPairCards.add(new Card(13, 3));
        twoPairCards.add(new Card(11, 2));
        twoPairCards.add(new Card(11, 1));
        PokerHand twoPair = new TwoPair(twoPairCards);

        ArrayList<Card> pairCards = new ArrayList<Card>(5);
        pairCards.add(new Card(1, 1));
        pairCards.add(new Card(6, 4));
        pairCards.add(new Card(6, 3));
        pairCards.add(new Card(3, 2));
        pairCards.add(new Card(9, 1));
        PokerHand pair = new Pair(pairCards);

        ArrayList<Card> highCardCards = new ArrayList<Card>(5);
        highCardCards.add(new Card(1, 1));
        highCardCards.add(new Card(3, 4));
        highCardCards.add(new Card(5, 3));
        highCardCards.add(new Card(7, 2));
        highCardCards.add(new Card(9, 1));
        PokerHand highCard = new HighCard(highCardCards);

        pokerHands.add(straightFlush);
        pokerHands.add(fourOfAKind);
        pokerHands.add(fullHouse);
        pokerHands.add(flush);
        pokerHands.add(straight);
        pokerHands.add(threeOfAKind);
        pokerHands.add(twoPair);
        pokerHands.add(pair);
        pokerHands.add(highCard);

        Collections.shuffle(pokerHands);
        Collections.sort(pokerHands);
        assertTrue(pokerHands.get(0) instanceof HighCard);
        assertTrue(pokerHands.get(1) instanceof Pair);
        assertTrue(pokerHands.get(2) instanceof TwoPair);
        assertTrue(pokerHands.get(3) instanceof ThreeOfAKind);
        assertTrue(pokerHands.get(4) instanceof Straight);
        assertTrue(pokerHands.get(5) instanceof Flush);
        assertTrue(pokerHands.get(6) instanceof FullHouse);
        assertTrue(pokerHands.get(7) instanceof FourOfAKind);
        assertTrue(pokerHands.get(8) instanceof StraightFlush);
    }

}