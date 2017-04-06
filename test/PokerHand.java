public enum PokerHand {
    STRAIGHT_FLUSH (1),
    FOUR_OF_A_KIND (2),
    FULL_HOUSE(3),
    FLUSH (4),
    STRAIGHT  (5),
    THREE_OF_A_KIND (6),
    TWO_PAIR  (7),
    PAIR  (8),
    HIGH_CARD (9);

    private int ranking;

    PokerHand(int ranking) {
        this.ranking = ranking;
    }


}
