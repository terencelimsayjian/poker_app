package com.pokerapp.models;

import com.pokerapp.models.Card;
import com.pokerapp.models.Deck;

import java.util.ArrayList;

public class GameRound {
    private ArrayList<Card> board = new ArrayList<Card>(5);
    private Deck deck;

    // ArrayList<com.pokerapp.models.Player> activePlayers
    // int pot = 0;
    // Dealer / blinds info?

    public GameRound() {
        deck = new Deck();
    }

    public ArrayList<Card> getBoard() {
        return board;
    }

    public void dealFlop() {
        board.add(0, deck.dealCard());
        board.add(1, deck.dealCard());
        board.add(2, deck.dealCard());
    }



    public void dealTurn() {
        board.add(3, deck.dealCard());
    }

    public void dealRiver() {
        board.add(4, deck.dealCard());
    }
    /*
    *   checkWin()?
    *
    * */

}
