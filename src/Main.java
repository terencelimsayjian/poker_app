import com.pokerapp.helpers.BestPokerHand;
import com.pokerapp.models.Card;
import com.pokerapp.models.Deck;
import com.pokerapp.models.hands.PokerHand;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
            Deck deck = new Deck();
            ArrayList<Card> board = new ArrayList<>(5);
            board.add(deck.dealCard());
            board.add(deck.dealCard());
            board.add(deck.dealCard());
            board.add(deck.dealCard());
            board.add(deck.dealCard());

            System.out.println("BOARD: " + board.toString());

            ArrayList<Card> hand1 = new ArrayList<>(2);
            hand1.add(deck.dealCard());
            hand1.add(deck.dealCard());
            System.out.println("Player 1: " + hand1.toString());

            ArrayList<Card> hand2 = new ArrayList<Card>(2);
            hand2.add(deck.dealCard());
            hand2.add(deck.dealCard());
            System.out.println("Player 2: " + hand2.toString());

            ArrayList<Card> hand3 = new ArrayList<Card>(2);
            hand3.add(deck.dealCard());
            hand3.add(deck.dealCard());
            System.out.println("Player 3: " + hand3.toString());

            ArrayList<Card> hand4 = new ArrayList<Card>(2);
            hand4.add(deck.dealCard());
            hand4.add(deck.dealCard());
            System.out.println("Player 4: " + hand4.toString());

            ArrayList<Card> hand5 = new ArrayList<Card>(2);
            hand5.add(deck.dealCard());
            hand5.add(deck.dealCard());
            System.out.println("Player 5: " + hand5.toString());

            ArrayList<Card> hand6 = new ArrayList<Card>(2);
            hand6.add(deck.dealCard());
            hand6.add(deck.dealCard());
            System.out.println("Player 6: " + hand6.toString());

            PokerHand pokerHand1 = BestPokerHand.get(board, hand1);
            PokerHand pokerHand2 = BestPokerHand.get(board, hand2);
            PokerHand pokerHand3 = BestPokerHand.get(board, hand3);
            PokerHand pokerHand4 = BestPokerHand.get(board, hand4);
            PokerHand pokerHand5 = BestPokerHand.get(board, hand5);
            PokerHand pokerHand6 = BestPokerHand.get(board, hand6);

            System.out.println("Player 1 has a " + pokerHand1.toString());
            System.out.println("Player 2 has a " + pokerHand2.toString());
            System.out.println("Player 3 has a " + pokerHand3.toString());
            System.out.println("Player 4 has a " + pokerHand4.toString());
            System.out.println("Player 5 has a " + pokerHand5.toString());
            System.out.println("Player 6 has a " + pokerHand6.toString());

    }

}

