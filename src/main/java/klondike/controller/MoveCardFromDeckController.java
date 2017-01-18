package klondike.controller;

import java.util.List;

import klondike.model.Board;
import klondike.model.Card;
import klondike.model.StackFamilyCards;
import klondike.view.IOS;

public class MoveCardFromDeckController extends MoverCardController {

    private static final int POSITION_CARD_INITIAL = 0;

    public MoveCardFromDeckController(Board board, IOS ios) {
        super(board, ios);
    }

    @Override
    public void updateCardsToShow(StackFamilyCards stackFamilyCards) {
        this.updateCardToShowInStackFamilyCards(stackFamilyCards);
        this.updateCardToShowInDeck();

    }

    public void updateCardToShowInDeck() {
        if (this.getBoard().getDeck().getPosCardShow() >= POSITION_CARD_INITIAL) {
            int position = this.getBoard().getDeck().getPosCardShow() - 1;
            getBoard().getDeck().sePosCardShow(position);
        }
    }

    @Override
    public List<Card> selectionListOfCardOrigin() {
        List<Card> origin = null;
        origin = this.getBoard().getDeck().getCards();
        return origin;
    }

    @Override
    public Boolean moveCardsToLadder(List<Card> origin, List<Card> destin, Card card) {
        boolean returnMoveCardsToLadder = this.getMoveCardController().moveCardToLadder(origin, card, destin);
        if (returnMoveCardsToLadder)
            this.updateCardToShowInDeck();
        return returnMoveCardsToLadder;
    }

    @Override
    public Card selectionCardToMoveToLadder() {
        Card card;
        card = this.getBoard().getDeck().getCards().get(this.getBoard().getDeck().getPosCardShow());
        return card;
    }

    @Override
    public Card selecctionCardToMove() {
        return this.selectionCardToMoveToLadder();
    }

}
