package klondike.controller;

import java.util.List;

import klondike.model.Board;
import klondike.model.Card;
import klondike.model.StackFamilyCards;
import klondike.view.IOS;

public class MoveCardFromLadderController extends MoverCardController {

    public MoveCardFromLadderController(Board board, IOS ios) {
        super(board, ios);
    }

    @Override
    public void updateCardsToShow(StackFamilyCards stackFamilyCards) {
        this.updateCardToShowInStackFamilyCards(stackFamilyCards);

    }

    @Override
    public List<Card> selectionListOfCardOrigin() {
        List<Card> origin = null;
        int positionCard = this.getBoard().getLadders().getCardLadderSelected();
        origin = this.getBoard().getLadders().getStairsLadder().get(positionCard).getSatckCards();
        return origin;
    }

    @Override
    public Card selectionCardToMoveToLadder() {
        return null;
    }

    @Override
    public Boolean moveCardsToLadder(List<Card> origin, List<Card> destin, Card card) {

        return this.getMoveCardController().moveCardsVisiblesToLadders(origin, destin);
    }

    @Override
    public Card selecctionCardToMove() {
        Card card;
        int positionStack = this.getBoard().getLadders().getCardLadderSelected();
        int positionCard = this.getBoard().getLadders().getStairsLadder().get(positionStack).getSatckCards().size() - 1;
        card = this.getBoard().getLadders().getStairsLadder().get(positionStack).getSatckCards().get(positionCard);
        return card;
    }

}
