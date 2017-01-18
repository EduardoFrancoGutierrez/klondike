package klondike;

import klondike.controller.PlayController;
import klondike.model.Board;
import klondike.view.IOS;

public class GameM {

    public static void main(String[] argv) {
        Board board = new Board();
        board.boardConstructionInitial();
        IOS ios = new IOS();
        PlayController playcontrol = new PlayController(board, ios);
        playcontrol.controlOfConductOfMenus();

    }

}
