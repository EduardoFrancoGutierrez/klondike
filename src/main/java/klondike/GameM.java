package klondike;



public class GameM {

    public static void main (String[] argv){
        Tablero tablero= new Tablero();
        tablero.construccionDelTableroInicial();
        IOS ios = new IOS ();
        PlayController playcontrol= new PlayController(tablero,ios);
        playcontrol.controlDeGestionDeMenus();

    }
      
    
}


    
    
    
    
    
   

