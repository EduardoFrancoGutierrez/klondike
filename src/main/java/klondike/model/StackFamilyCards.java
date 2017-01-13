package klondike.model;

import java.util.ArrayList;
import java.util.List;

public class StackFamilyCards {
    private List<Card> cards;

    private int posShowCard;

    public StackFamilyCards() {
        this.cards = new ArrayList<Card>();
        this.posShowCard = -1;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getPosShowCard() {
        return posShowCard;
    }

    public void setPosShowCard(int posShowCard) {
        this.posShowCard = posShowCard;
    }

}
