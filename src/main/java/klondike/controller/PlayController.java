package klondike.controller;

import klondike.model.Board;
import klondike.model.Card;
import klondike.model.NumbersCards;
import klondike.model.OptionMenu;
import klondike.model.StackFamilyCards;
import klondike.view.IOS;

public class PlayController {

    private static final int INITIAL_VALUE_READ_IOS = -1;

    private static final int POSITION_INVALID_CARD_SHOW = -1;

    private static final int STAIR_LADDER_SIZE = 0;

    private static final int POSITION_CARD_SHOW = 0;

    private Board board;

    private IOS ios;

    private MoveCardFromLadderController moveCardFromLadderController;

    private MoveCardFromDeckController moveCardFromDeckController;

    public PlayController(Board board, IOS ios) {
        super();
        this.board = board;
        this.ios = ios;
        this.moveCardFromDeckController = new MoveCardFromDeckController(board, ios);
        this.moveCardFromLadderController = new MoveCardFromLadderController(board, ios);
    }

    public void controlOfConductOfMenus() {
        boolean repeat = true;
        OptionMenu menu = OptionMenu.MainMenu;
        do {
            if (this.checkFinishPlay()) {
                this.ios.ShowFinishPlay();
                menu = OptionMenu.Exit;
            }
            switch (menu) {
            case MainMenu:
                menu = ControlMainMenu();
                break;
            case DeckMenu:
                menu = controlDeck();
                break;
            case LadderMenu:
                menu = controlLadder();
                break;
            case MoveCardToStickFromDeckMenu:
                menu = moveCardFromDeckController.moveControlCardToStackFamilyCards();
                break;
            case MoveCardToStickFromLadderMenu:
                menu = this.moveCardFromLadderController.moveControlCardToStackFamilyCards();
                break;
            case MoveLetterToStairFromDeckMenu:
                menu = this.moveCardFromDeckController.controlMoveCardToLadder();
                break;
            case MoveLetterToStairFromStaircaseMenu:
                menu = this.moveCardFromLadderController.controlMoveCardToLadder();
                break;
            case Exit:
                repeat = false;
                break;

            }

        } while (repeat);
    }

    public OptionMenu ControlMainMenu() {
        int readIOS = INITIAL_VALUE_READ_IOS;
        boolean repeat = true;
        OptionMenu testControlMainMenu = OptionMenu.MainMenu;
        do {
            ios.showTablero(board);
            readIOS = ios.showMenu();
            if (readIOS == 0) {
                testControlMainMenu = OptionMenu.DeckMenu;
                repeat = false;
            } else if ((readIOS > 0) && (readIOS < 8)) {
                this.putSelecctionLadder(readIOS);
                testControlMainMenu = OptionMenu.LadderMenu;
                repeat = false;
            } else if (readIOS == 8) {
                testControlMainMenu = OptionMenu.Exit;
                repeat = false;
            }
        } while (repeat);
        return testControlMainMenu;
    }

    public OptionMenu controlDeck() {
        int readIOS = INITIAL_VALUE_READ_IOS;
        boolean testControlDeck = true;
        OptionMenu retorno = OptionMenu.MainMenu;
        do {
            ios.showTablero(board);
            readIOS = ios.optionMenuDeck();
            switch (readIOS) {
            case 0:
                if (!board.getDeck().showNextCard()) {
                    testControlDeck = false;
                }
                break;
            case 1:
                if ((board.getDeck().size() > 0) && (board.getDeck().getPosCardShow() >= POSITION_CARD_SHOW)) {
                    retorno = OptionMenu.MoveLetterToStairFromDeckMenu;
                    testControlDeck = false;
                }
                break;
            case 2:
                if (this.checkVisibleCardInDeck()) {
                    retorno = OptionMenu.MoveCardToStickFromDeckMenu;
                    testControlDeck = false;
                }
                break;
            case 3:
                retorno = OptionMenu.MainMenu;
                testControlDeck = false;
                break;
            case 4:
                retorno = OptionMenu.Exit;
                testControlDeck = false;
            }

        } while (testControlDeck);
        return retorno;
    }

    public OptionMenu controlLadder() {
        int readIOS = INITIAL_VALUE_READ_IOS;
        boolean repeat = true;
        OptionMenu testControlLadder = OptionMenu.MainMenu;
        do {
            ios.showTablero(board);
            readIOS = ios.optionMenuLadder();
            Card card = this.moveCardFromLadderController.selecctionCardToMove();
            switch (readIOS) {
            case 0:
                if (card.getVisible()) {
                    testControlLadder = OptionMenu.MoveLetterToStairFromStaircaseMenu;
                    repeat = false;
                }
                break;
            case 1:
                if (card.getVisible()) {
                    testControlLadder = OptionMenu.MoveCardToStickFromLadderMenu;
                    repeat = false;
                }
                break;
            case 2:
                if (!card.getVisible()) {
                    card.setVisible(true);
                }
                break;
            case 3:
                testControlLadder = OptionMenu.MainMenu;
                repeat = false;
                break;
            case 4:
                testControlLadder = OptionMenu.Exit;
                repeat = false;
            }
        } while (repeat);
        return testControlLadder;
    }

    public void putSelecctionLadder(Integer selectionLadder) {
        int positionSelecctionLadder = selectionLadder - 1;
        if (board.getLadders().getStairsLadder().get(positionSelecctionLadder).size() > STAIR_LADDER_SIZE) {
            board.getLadders().setCardLadderSelected(positionSelecctionLadder);
        }
    }

    public boolean checkVisibleCardInDeck() {
        boolean testCheckVisibleCardInDeck = false;
        int pos = board.getDeck().getPosCardShow();
        if (pos != POSITION_INVALID_CARD_SHOW) {
            Card card = board.getDeck().getCards().get(pos);
            if (card.getVisible()) {
                testCheckVisibleCardInDeck = true;
            }
        }
        return testCheckVisibleCardInDeck;
    }

    public boolean checkFinishPlay() {
        boolean testCheckFinishPlay = false;
        int numberCompleteStackFamilyCard = 0;
        for (StackFamilyCards stack : this.board.getStackFamilyCards()) {
            if (stack.getCards().size() == NumbersCards.values().length) {
                numberCompleteStackFamilyCard++;
            }
        }
        if (numberCompleteStackFamilyCard == this.board.getStackFamilyCards().size())
            testCheckFinishPlay = true;
        return testCheckFinishPlay;
    }

}
