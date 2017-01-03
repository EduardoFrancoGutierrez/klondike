package klondike;

import java.util.ArrayList;
import java.util.List;

public class GameM {

    public static void main (String[] argv){
        Escaleras escalera= new Escaleras();
        List<Baraja> barajas =inicializacionBarajas();
        Baraja baraja= barajas.get(0);
        baraja.construir();
        baraja.mezclar();
        escalera.componerTableroInicial(baraja);
        IOS ios = new IOS ();
        PlayController playcontrol= new PlayController();
        playcontrol.controlMenus(barajas,escalera,ios);
        PilaCartas pila= new PilaCartas();
        Card carta = new Card(FamilyCards.Diamonds,NumbersCards.K);
        carta.setVisible(true);
        Card carta2 = new Card(FamilyCards.Spades,NumbersCards.K);
        carta2.setVisible(true);
        pila.getPilaCartas().add(carta);
        if (pila.moverCartaApila(carta2))
            System.out.println("MOVER=TRUE");
//        int retorno=ios.showTablero(baraja, escalera);
//        if (retorno==0){
//            if (baraja.mostrarSiguienteCarta())
//                ios.showTablero(baraja, escalera);
//        }
        
        
//        System.out.println("tamanio="+baraja.size());
//        int count=0;
//        escalera.componerTableroInicial(baraja);
//        System.out.println(String.format("%1$-25s",0+".LIST"));
//        System.out.print(String.format("%1$-25s",baraja.getCards().get(0).toString()));
//        System.out.println();
//        System.out.println();
//        escalera.mostrar();
//        System.out.println();
//        System.out.println();
//        IOS ios = new IOS ();
//        int retorno=ios.showMenu();
//        if (retorno==0){
//            if (baraja.mostrarSiguienteCarta()){
//                System.out.println(String.format("%1$-25s",0+".LIST"));
//                System.out.print(String.format("%1$-25s",baraja.getCards().get(baraja.getPosCartaMostrada()).toString()));
//                System.out.println();
//                System.out.println();
//                ios.mostrar();
//            }
//        }
        
//            for (int i=0; i<7;i++){
//                for (int j=0;j<i;j++){
//                    baraja.moveCard(baraja.getCards(), columnas.getStackCards(), baraja.getCards().get(0));
//                }
//                baraja.getCards().get(0).setVisible(true);
//                baraja.moveCard(baraja.getCards(), columnas.getStackCards(), baraja.getCards().get(0));
//            }
        
        
       /* for (int i=0; i<8;i++){
            Stack stack= new Stack();
            for(int j=0;j<7;j++){
                    stack.getStackCards().add(baraja.getCards().get(count));
                    System.out.print(String.format("%1$-25s",baraja.getCards().get(count).toString()));
                    count++;
               
            }
            System.out.println();
            fila.add(stack);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        baraja.mezclar();
        count=0;
        baraja.getCards().remove(0);
        baraja.getCards().remove(0);
        baraja.getCards().remove(0);
        baraja.getCards().remove(0);
        for (int i=0; i<8;i++){
            for(int j=0;j<7;j++){
                    if (count<baraja.getCards().size()){
                    System.out.print(String.format("%1$-25s",baraja.getCards().get(count).toString()));
                    count++;
                    }
               
            }
            System.out.println();
        }*/
    }

    public static List<Baraja> inicializacionBarajas(){
        List<Baraja> barajas = new ArrayList<Baraja> ();
        for (int i=0; i<5;i++){
            Baraja baraja = new Baraja();
            barajas.add(baraja);
        }
        return barajas;
    }
    
    
  
    
}


    
    
    
    
    
   

