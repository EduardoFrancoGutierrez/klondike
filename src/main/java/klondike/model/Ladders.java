package klondike.model;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    static public final int NUM_COLUMN = 7;

    static public final int MAX_NUM_ROW = 20;

    private List<StackCards> ladders;

    private int cardLadderSelected;

    public Ladders() {
        this.ladders = new ArrayList<StackCards>();
        for (int i = 0; i < NUM_COLUMN; i++) {
            ladders.add(new StackCards());
        }
    }

    public void cardDealInitial(Deck deck) {
        for (int i = 0; i < NUM_COLUMN; i++) {
            StackCards stackCards = this.ladders.get(i);
            for (int j = 0; j <= i; j++) {
                deck.moveCard(deck.getCards(), stackCards.getSatckCards(), deck.getCards().get(0));
            }
            stackCards.getSatckCards().get(this.ladders.get(i).getSatckCards().size() - 1).setVisible(true);
        }
    }

    public List<StackCards> getLadders() {
        return ladders;
    }

    public void setLadders(List<StackCards> ladders) {
        this.ladders = ladders;
    }

    public int getCardLadderSelected() {
        return cardLadderSelected;
    }

    public void setCardLadderSelected(int cardLadderSelected) {
        this.cardLadderSelected = cardLadderSelected;
    }

}
