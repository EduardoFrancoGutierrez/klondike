package klondike.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int NUMBER_FAMILY = 4;

    private Deck deck;

    private Ladders ladders;

    private List<StackFamilyCards> stackFamilyCards;

    public Board() {
        this.deck = new Deck();
        this.ladders = new Ladders();
        this.stackFamilyCards = InitializationOfStackFamilyCards();
    }

    public void boardConstructionInitial() {
        this.deck.build();
        this.deck.mixCards();
        this.ladders.cardDealInitial(this.deck);
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Ladders getLadders() {
        return ladders;
    }

    public void setLadders(Ladders ladders) {
        this.ladders = ladders;
    }

    public List<StackFamilyCards> getStackFamilyCards() {
        return stackFamilyCards;
    }

    public void setStackFamilyCards(List<StackFamilyCards> stackFamilyCards) {
        this.stackFamilyCards = stackFamilyCards;
    }

    private List<StackFamilyCards> InitializationOfStackFamilyCards() {
        List<StackFamilyCards> pilasFamilys = new ArrayList<StackFamilyCards>();
        for (int i = 0; i < NUMBER_FAMILY; i++) {
            StackFamilyCards pilasFamily = new StackFamilyCards();
            pilasFamilys.add(pilasFamily);
        }
        return pilasFamilys;
    }

}
