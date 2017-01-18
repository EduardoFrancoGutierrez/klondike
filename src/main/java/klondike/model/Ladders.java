package klondike.model;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    static public final int NUM_COLUMN = 7;

    static public final int MAX_NUM_ROW = 20;

    private List<StackCards> stairsLadder;

    private int cardLadderSelected;

    public Ladders() {
        this.stairsLadder = new ArrayList<StackCards>();
        for (int i = 0; i < NUM_COLUMN; i++) {
            stairsLadder.add(new StackCards());
        }
    }

    public void cardDealInitial(Deck deck) {
        for (int i = 0; i < NUM_COLUMN; i++) {
            StackCards stackCards = this.stairsLadder.get(i);
            for (int j = 0; j <= i; j++) {
                deck.moveCard(deck.getCards(), stackCards.getSatckCards(), deck.getCards().get(0));
            }
            stackCards.getSatckCards().get(this.stairsLadder.get(i).getSatckCards().size() - 1).setVisible(true);
        }
    }

    public List<StackCards> getStairsLadder() {
        return stairsLadder;
    }

    public void setStairsLadder(List<StackCards> stairsLadder) {
        this.stairsLadder = stairsLadder;
    }

    public int getCardLadderSelected() {
        return cardLadderSelected;
    }

    public void setCardLadderSelected(int cardLadderSelected) {
        this.cardLadderSelected = cardLadderSelected;
    }

}
