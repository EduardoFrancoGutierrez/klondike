package klondike;

import java.util.List;

public class MoveCardFromLadderController  extends MoverCardController {

    public MoveCardFromLadderController(Board board, IOS ios) {
        super(board, ios);
    }

    @Override
    public void updateCardsToShow(StackFamilyCards stackFamilyCards) {
        this.updateCardToShowInStackFamilyCards (stackFamilyCards);
        
    }

    @Override
    public List<Card> selectionListOfCardOrigin() {
        List<Card> origin = null;
        int positionCard = this.getBoard().getLadders().getCardLadderSelected();
        origin = this.getBoard().getLadders().getLadders().get(positionCard).getSatckCards();
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
        // obtengo la position de la carta
        int positionCard = this.getBoard().getLadders().getLadders().get(positionStack).getSatckCards().size() - 1;
        // carta seleccionada para mover de una escalera seleccionada
        card = this.getBoard().getLadders().getLadders().get(positionStack).getSatckCards().get(positionCard);
        return card;
    }

}
