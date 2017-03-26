import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> hand = new ArrayList<Card>(2);
    // chips: int

    public Player(String name) {
        this.name = name;
    }

    public void addFirstCardToHand(Card c) {
        hand.add(0, c);
    }

    public void addSecondCardToHand(Card c) {
        hand.add(1, c);
    }

    // Security for revealing hands?
    public ArrayList<Card> getHand() {
        return hand;
    }

    public void resetHand() {
        hand.clear();
    }

}
