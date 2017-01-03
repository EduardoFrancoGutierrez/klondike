package klondike;

import java.util.ArrayList;
import java.util.List;

public class PilaFamiliaCartas {
    private List<Card> cards;

    private int posCartaMostrada;

    public PilaFamiliaCartas() {
        this.cards = new ArrayList<Card>();
        this.posCartaMostrada = -1;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getPosCartaMostrada() {
        return posCartaMostrada;
    }

    public void setPosCartaMostrada(int posCartaMostrada) {
        this.posCartaMostrada = posCartaMostrada;
    }

}
