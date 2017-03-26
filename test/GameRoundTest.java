import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class GameRoundTest {
    @Test
    public void testDealFlop() {
        GameRound gr = new GameRound();
        gr.dealFlop();
        ArrayList<Card> board = gr.getBoard();

        for (int i = 0; i <= 2; i++) {
            assertEquals(board.get(i) instanceof Card, true);
        }
    }

    @Test
    public void testDealTurn() {
        GameRound gr = new GameRound();
        gr.dealFlop();
        gr.dealTurn();
        ArrayList<Card> board = gr.getBoard();

        assertEquals(board.get(3) instanceof Card, true);
    }

    @Test
    public void testDealRiver() {
        GameRound gr = new GameRound();
        gr.dealFlop();
        gr.dealTurn();
        gr.dealRiver();
        ArrayList<Card> board = gr.getBoard();

        assertEquals(board.get(4) instanceof Card, true);
    }

}
