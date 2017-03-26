import java.util.HashMap;

public class Card {
    public final static int SPADES = 1;
    public final static int HEARTS = 2;
    public final static int CLUBS = 3;
    public final static int DIAMONDS = 4;

    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;
    public final static int ACE = 1;

    private final int value; // 1 - 13
    private final int suit; // 1 - 13 (s, h , c, d)

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        int pokerValue = value;

        if (value == Card.ACE) {
            return 14;
        }

        return pokerValue;
    }

    public int getSuit() {
        return suit;
    }

    public String toString() {
        return valueToString() + " of " + suitToString();
    }

    private String suitToString() {
        HashMap<Integer, String> suitStringHashMap = new HashMap<Integer, String>();
        {
            suitStringHashMap.put(1,"Spades");
            suitStringHashMap.put(2,"Hearts");
            suitStringHashMap.put(3,"Clubs");
            suitStringHashMap.put(4,"Diamonds");
        }
        return suitStringHashMap.get(suit);
    }

    private String valueToString() {
        HashMap<Integer, String> valueStringHashMap = new HashMap<Integer, String>();
        {
            valueStringHashMap.put(1,"Ace");
            valueStringHashMap.put(2,"Deuce");
            valueStringHashMap.put(3,"Three");
            valueStringHashMap.put(4,"Four");
            valueStringHashMap.put(5,"Five");
            valueStringHashMap.put(6,"Six");
            valueStringHashMap.put(7,"Seven");
            valueStringHashMap.put(8,"Eight");
            valueStringHashMap.put(9,"Nine");
            valueStringHashMap.put(10,"Ten");
            valueStringHashMap.put(11,"Jack");
            valueStringHashMap.put(12,"Queen");
            valueStringHashMap.put(13,"King");
        }
        return valueStringHashMap.get(value);
    }

}
