package klondike;

import java.util.ArrayList;
import java.util.List;

public class GameM {

    public static void main (String[] argv){
        Escaleras escalera= new Escaleras();
        Baraja baraja= new Baraja();
        baraja.construir();
        baraja.mezclar();
        escalera.componerTableroInicial(baraja);
        IOS ios = new IOS ();
        controlMenus(baraja,escalera,ios);
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
    
    public static int controlMenus(Baraja baraja , Escaleras escalera, IOS ios){
        int lectura=-1;
        int pila=-1;
        Card card;
        boolean repetir=true;
        OptionMenu menu= OptionMenu.MenuPrinicpal;
        do{
            //ios.showTablero(baraja, escalera);
            switch (menu) {
                case MenuPrinicpal :
                    pila=menuPrincipal(baraja,escalera,ios);
                    if (pila==0)
                        menu=OptionMenu.MenuBaraja;
                    else if ((pila>0)&&(pila<8))
                        menu=OptionMenu.MenuListaPilas;
                    break;
                case MenuBaraja:
                    menu=controlBaraja(baraja,escalera,ios);
                    if (menu== OptionMenu.MenuMoverCarta)
                        card=baraja.getCards().get(baraja.getPosCartaMostrada());
                    break;
                case MenuListaPilas:
                    menu=controlListaPilas(baraja,escalera,ios);
                    if (menu== OptionMenu.MenuMoverCarta){
                        pila=pila-1;
                        int pos= escalera.getEscaleras().get(pila).getPilaCartas().size()-1;
                        card=escalera.getEscaleras().get(pila).getPilaCartas().get(pos);
                    }
                    break;
                case Exit:
                    repetir=false;
                    break;
                case MenuMoverCarta:
                    //pila=controlMoverCarta(baraja, escalera,ios, card, menu);
                    break;
                   
            }
            
        }while (repetir);
        return lectura;
    }
    
    public static int menuPrincipal (Baraja baraja , Escaleras escalera, IOS ios){
        
        int lectura=-1;
        boolean repetir=true;
        do{
            ios.showTablero(baraja, escalera);
            lectura=ios.showMenu();
            if (lectura==0){
                //menu=OptionMenu.MenuBaraja;
                repetir=false;
            }
            else if ((lectura>0)&&(lectura<8)){
                repetir=false;
            }
        }while (repetir);
        return lectura;
    }
    public static OptionMenu controlBaraja(Baraja baraja , Escaleras escalera, IOS ios){
        int lectura=-1;
        boolean repetir=true;
        OptionMenu retorno=OptionMenu.MenuPrinicpal;
        do{
            ios.showTablero(baraja, escalera);
            lectura = ios.opcionesMenuBaraja();
            if (lectura == 0) {
                if (!baraja.mostrarSiguienteCarta()){
                    repetir=false;
                }
            }
            else if (lectura==1){
              //opcionesMenuMoverCarta
                if ((baraja.size()>0) &&(baraja.getPosCartaMostrada()>=0)){
                    retorno=OptionMenu.MenuMoverCarta;
                    repetir=false;                
                }
            }
            else if (lectura==2){
                retorno=OptionMenu.MenuPrinicpal;
                repetir=false; 
            }
        } while (repetir);
        return retorno;
    }
    
    public static OptionMenu controlListaPilas(Baraja baraja , Escaleras escalera, IOS ios){
        int lectura=-1;
        boolean repetir=true;
        OptionMenu retorno=OptionMenu.MenuPrinicpal;
        do{
            ios.showTablero(baraja, escalera);
            lectura=ios.opcionesMenuListaPila();
            if (lectura==0){
                retorno= OptionMenu.MenuMoverCarta;
                repetir =false;
            }
            else if (lectura==1){
                retorno=OptionMenu.MenuPrinicpal;
                repetir =false;
            }
            
        }while (repetir);
        return retorno;
    }
    
    public static int controlMoverCarta(Baraja baraja , Escaleras escalera, IOS ios, Card card,OptionMenu menu){
        int lectura=-1;
        boolean repetir=true;
        do{
            ios.showTablero(baraja, escalera);
            lectura=ios.opcionesMenuMoverCarta();
            if ((lectura >= 0)||(lectura<7)) {
                if (escalera.getEscaleras().get(lectura).moverCartaApila(card)){
                    repetir =false;
                    menu= OptionMenu.MenuPrinicpal;
                }
            }
            else if (lectura==7){
                repetir =false;
                menu= OptionMenu.MenuPrinicpal;
            }
        }while (repetir);
        return lectura;
    }
   
}
