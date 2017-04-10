import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Deck deck = new Deck();
            ArrayList<Card> cards = new ArrayList<Card>(7);

            cards.add(deck.dealCard());
            cards.add(deck.dealCard());
            cards.add(deck.dealCard());
            cards.add(deck.dealCard());
            cards.add(deck.dealCard());
            cards.add(deck.dealCard());
            cards.add(deck.dealCard());

            System.out.println("Cards: " + cards.toString());

            PokerHand pokerHand = BestPokerHand.get(cards);

            System.out.println(pokerHand.toString());
        }


    }

}

