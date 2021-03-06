package klondike.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private static final int NOT_EMPTY_DECK = 1;

    private static final int POSITION_CARD_SHOW_INITIAL = -1;

    private List<Card> cards;

    private int posCardShow;

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.posCardShow = POSITION_CARD_SHOW_INITIAL;

    }

    public void build() {
        for (NumbersCards numbersCards : NumbersCards.values()) {
            for (FamilyCards family : FamilyCards.values()) {
                Card card = new Card(family, numbersCards);
                this.cards.add(card);

            }
        }
    }

    public void mixCards() {
        long seed = System.nanoTime();
        Collections.shuffle(this.cards, new Random(seed));
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void moveCard(List<Card> origin, List<Card> destin, Card card) {
        int index = origin.indexOf(card);
        destin.add(origin.get(index));
        origin.remove(index);
    }

    public int size() {
        return this.cards.size();
    }

    public boolean showNextCard() {
        boolean isShowNextCard = false;
        if (this.size() < NOT_EMPTY_DECK) {
            this.posCardShow = POSITION_CARD_SHOW_INITIAL;
            return isShowNextCard;
        } else {
            int posCardNextShow = this.posCardShow + 1;
            if (posCardNextShow == this.size()) {
                this.hideCard();
                isShowNextCard = true;

            } else {
                this.cards.get(posCardNextShow).setVisible(true);
                this.posCardShow = posCardNextShow;
                isShowNextCard = true;
            }

        }
        return isShowNextCard;
    }

    private void hideCard() {
        for (Card card : this.cards) {
            card.setVisible(false);
        }
        this.posCardShow = POSITION_CARD_SHOW_INITIAL;
    }

    public int getPosCardShow() {
        return posCardShow;
    }

    public void sePosCardShow(int posCardShow) {
        this.posCardShow = posCardShow;
    }

}
