import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>(52);
    private int currentCardIndex = 0;

    public Deck() {
        populateDeck();
        Collections.shuffle(this.cards);
    }

    public Card dealCard() {
        Card c = cards.get(currentCardIndex);
        currentCardIndex++;
        return c;
    }

    private void populateDeck () {
        int currentIndex = 0;

        for (int suit = 1; suit <= 4; suit++) {
            for (int value = 1; value <= 13; value++) {
                Card c = new Card(value, suit);
                cards.add(currentIndex, c);
                currentIndex++;
            }
        }
    }

}
