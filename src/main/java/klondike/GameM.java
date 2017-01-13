package klondike;



public class GameM {

    public static void main (String[] argv){
        Board board= new Board();
        board.boardConstructionInitial();
        IOS ios = new IOS ();
        PlayController playcontrol= new PlayController(board,ios);
        playcontrol.controlOfConductOfMenus();

    }
      
    
}


    
    
    
    
    
   

