package klondike;

import java.util.ArrayList;
import java.util.List;

public class GameM {

    public static void main (String[] argv){
        Escaleras escalera= new Escaleras();
        Baraja baraja =new Baraja();
        List<PilaFamiliaCartas> pilasFamily= inicializacionPilasFamily();
        baraja.construir();
        baraja.mezclar();
        escalera.componerTableroInicial(baraja);
        IOS ios = new IOS ();
        PlayController playcontrol= new PlayController();
        playcontrol.controlMenus(baraja,pilasFamily,escalera,ios);
        PilaCartas pila= new PilaCartas();
        Card carta = new Card(FamilyCards.Diamonds,NumbersCards.K);
        carta.setVisible(true);
        Card carta2 = new Card(FamilyCards.Spades,NumbersCards.K);
        carta2.setVisible(true);
        pila.getPilaCartas().add(carta);
        if (pila.moverCartaApila(carta2))
            System.out.println("MOVER=TRUE");

    }

    public static List<PilaFamiliaCartas> inicializacionPilasFamily(){
        List<PilaFamiliaCartas> pilasFamilys = new ArrayList<PilaFamiliaCartas> ();
        for (int i=0; i<4;i++){
            PilaFamiliaCartas pilasFamily = new PilaFamiliaCartas();
            pilasFamilys.add(pilasFamily);
        }
        return pilasFamilys;
    }
    
    
  
    
}


    
    
    
    
    
   

