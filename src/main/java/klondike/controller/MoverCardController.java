package klondike.controller;

import java.util.List;

import klondike.model.Board;
import klondike.model.Card;
import klondike.model.OptionMenu;
import klondike.model.StackFamilyCards;
import klondike.view.IOS;

public abstract class MoverCardController {
    private Board board;

    private IOS ios;

    private ActionMoveCardController actionMoveCardController;

    public MoverCardController(Board board, IOS ios) {
        super();
        this.board = board;
        this.ios = ios;
        this.actionMoveCardController = new ActionMoveCardController();
    }

    public OptionMenu moveControlCardToStackFamilyCards() {
        int readIOS = -1;
        boolean repeat = true;
        OptionMenu returnMenu = OptionMenu.MainMenu;
        do {
            ios.showTablero(board);
            readIOS = ios.optionMenuMoveCardsToStackFamilyCard();
            if ((readIOS >= 1) && (readIOS < 5)) {
                List<Card> origin = this.selectionListOfCardOrigin();
                Card card = this.selecctionCardToMove();
                int position = readIOS - 1;
                if (this.actionMoveCardController.moveCardToStackFamilyCards(origin, board.getStackFamilyCards().get(position).getCards(),
                        card)) {
                    this.updateCardsToShow(board.getStackFamilyCards().get(position));
                    repeat = false;
                    returnMenu = OptionMenu.MainMenu;

                }

            } else {
                repeat = false;
                if (readIOS == 5)
                    returnMenu = OptionMenu.MainMenu;
                if (readIOS == 6)
                    returnMenu = OptionMenu.Exit;
            }
        } while (repeat);
        return returnMenu;
    }

    public OptionMenu controlMoveCardToLadder() {
        int readIOS = -1;
        boolean repeat = true;
        OptionMenu returnMenu = OptionMenu.MainMenu;
        do {
            ios.showTablero(board);
            readIOS = ios.optionMenuMoveCardLadder();
            if ((readIOS >= 1) && (readIOS < 8)) {
                int position = readIOS - 1;
                List<Card> origin = this.selectionListOfCardOrigin();
                Card card = this.selectionCardToMoveToLadder();
                List<Card> destinLadder = board.getLadders().getStairsLadder().get(position).getSatckCards();
                if (this.moveCardsToLadder(origin, destinLadder, card)) {
                    repeat = false;
                    returnMenu = OptionMenu.MainMenu;
                }
            } else {
                repeat = false;
                if (readIOS == 8)
                    returnMenu = OptionMenu.MainMenu;
                if (readIOS == 9)
                    returnMenu = OptionMenu.Exit;
            }
        } while (repeat);
        return returnMenu;
    }

    public abstract void updateCardsToShow(StackFamilyCards stackFamilyCards);

    public abstract List<Card> selectionListOfCardOrigin();

    public abstract Card selectionCardToMoveToLadder();

    public abstract Card selecctionCardToMove();

    public abstract Boolean moveCardsToLadder(List<Card> origin, List<Card> destin, Card card);

    public void updateCardToShowInStackFamilyCards(StackFamilyCards stackFamilyCards) {
        int indicePos = stackFamilyCards.getPosShowCard() + 1;
        stackFamilyCards.setPosShowCard(indicePos);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public IOS getIos() {
        return ios;
    }

    public void setIos(IOS ios) {
        this.ios = ios;
    }

    public ActionMoveCardController getMoveCardController() {
        return actionMoveCardController;
    }

}
