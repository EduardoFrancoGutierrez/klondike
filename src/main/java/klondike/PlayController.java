package klondike;

import java.util.List;

public class PlayController {


    public  int controlMenus(List<Baraja> barajas , Escaleras escalera, IOS ios){
        int lectura=-1;
        int pila=-1;
        boolean origenBaraja=false;
        boolean repetir=true;
        OptionMenu menu= OptionMenu.MenuPrinicpal;
        do{
            //ios.showTablero(baraja, escalera);
            switch (menu) {
                case MenuPrinicpal :
                    menu=menuPrincipal(barajas,escalera,ios);
                    break;
                case MenuBaraja:
                    menu=controlBaraja(barajas,escalera,ios);
                    if ((menu== OptionMenu.MenuMoverCarta)||(menu==OptionMenu.MenuMoverCartaBaraja)){
                        origenBaraja=true;
                        
                    }
                    break;
                case MenuListaPilas:
                    menu=controlListaPilas(barajas,escalera,ios);
                    break;
                case Exit:
                    repetir=false;
                    break;
                case MenuMoverCartaBaraja:
                    if (origenBaraja){
                        Card card=barajas.get(0).getCards().get(barajas.get(0).getPosCartaMostrada());
                        menu=controlMoverCartaBaraja(barajas, escalera,ios,barajas.get(0).getCards(),card); 
                    }
                    else{
                        int posicionPila=escalera.getPilaCartaSeleccionada();
                        //obtengo la posicion de la carta
                        int posicionCarta= escalera.getEscaleras().get(posicionPila).getPilaCartas().size()-1;
                        //carta seleccionada para mover de una escalera seleccionada
                        Card card =escalera.getEscaleras().get(posicionPila).getPilaCartas().get(posicionCarta);
                        menu=controlMoverCartaBaraja(barajas, escalera,ios , escalera.getEscaleras().get(posicionPila).getPilaCartas(),card);
                    }
                    origenBaraja=false;
                    break;
                case MenuMoverCarta:
                    if (origenBaraja){
                        //coge la carta del monton que esta mostrada
                        Card card=barajas.get(0).getCards().get(barajas.get(0).getPosCartaMostrada());
                        menu=controlMoverCarta(barajas, escalera,ios, card,barajas.get(0).getCards(),origenBaraja);
                    }
                    else{
                        int posicionPila=escalera.getPilaCartaSeleccionada();
                        //obtengo la posicion de la carta
                        int posicionCarta= escalera.getEscaleras().get(posicionPila).getPilaCartas().size()-1;
                        //carta seleccionada para mover de una escalera seleccionada
                        Card card =escalera.getEscaleras().get(posicionPila).getPilaCartas().get(posicionCarta);
                        menu=controlMoverCarta(barajas, escalera,ios, card, escalera.getEscaleras().get(posicionPila).getPilaCartas(),origenBaraja);
                    }
                    origenBaraja=false;
                    break;
                   
            }
            
        }while (repetir);
        return lectura;
    }
    
    public  OptionMenu menuPrincipal (List<Baraja> barajas , Escaleras escalera, IOS ios){
        
        int lectura=-1;
        boolean repetir=true;
        OptionMenu retorno=OptionMenu.MenuPrinicpal;
        do{
            ios.showTablero(barajas, escalera);
            lectura=ios.showMenu();
            if (lectura==0){
                retorno=OptionMenu.MenuBaraja;
                repetir=false;
            }
            else if ((lectura>0)&&(lectura<8)){
                int posicion=lectura-1;
                if (escalera.getEscaleras().get(posicion).size()>0){
                    retorno=OptionMenu.MenuListaPilas;
                    escalera.setPilaCartaSeleccionada(posicion);
                    repetir=false;
                }
            }
        }while (repetir);
        return retorno;
    }
    public  OptionMenu controlBaraja(List<Baraja> barajas , Escaleras escalera, IOS ios){
        int lectura=-1;
        boolean repetir=true;
        OptionMenu retorno=OptionMenu.MenuPrinicpal;
        do{
            ios.showTablero(barajas, escalera);
            lectura = ios.opcionesMenuBaraja();
            if (lectura == 0) {
                if (!barajas.get(0).mostrarSiguienteCarta()){
                    repetir=false;
                }
            }
            else if (lectura==1){
              //opcionesMenuMoverCarta
                if ((barajas.get(0).size()>0) &&(barajas.get(0).getPosCartaMostrada()>=0)){
                    retorno=OptionMenu.MenuMoverCarta;
                    repetir=false;                
                }
            }
            else if (lectura==2){
                retorno=OptionMenu.MenuPrinicpal;
                repetir=false; 
            }
            else if (lectura==3){
               int pos= barajas.get(0).getPosCartaMostrada();
               if (pos!=-1){
                   Card card= barajas.get(0).getCards().get(pos);
                           if (card.getVisible()){
                               retorno=OptionMenu.MenuMoverCartaBaraja;
                               repetir =false;
                           }
                   
               }
               
            }
            
        } while (repetir);
        return retorno;
    }
    
    public  OptionMenu controlListaPilas(List<Baraja> barajas , Escaleras escalera, IOS ios){
        int lectura=-1;
        boolean repetir=true;
        OptionMenu retorno=OptionMenu.MenuPrinicpal;
        do{
            ios.showTablero(barajas, escalera);
            int escaleraSeleccionada=escalera.getPilaCartaSeleccionada();
            //obtengo la posicion de la carta
            int posicionCarta= escalera.getEscaleras().get(escaleraSeleccionada).getPilaCartas().size()-1;
            //carta seleccionada para mover de una escalera seleccionada
            Card card =escalera.getEscaleras().get(escaleraSeleccionada).getPilaCartas().get(posicionCarta); 
            lectura=ios.opcionesMenuListaPila();
            if (lectura==0){
                if (card.getVisible()){
                    retorno= OptionMenu.MenuMoverCarta;
                    repetir =false;
                }
            }
            else if (lectura==1){
                retorno=OptionMenu.MenuPrinicpal;
                repetir =false;
            }
            else if (lectura==2){
                if (!card.getVisible()){
                    card.setVisible(true);
                }
            }
            else if (lectura==3){
                if (card.getVisible()){
                    retorno=OptionMenu.MenuMoverCartaBaraja;
                    repetir =false;
                }
            }
            
        }while (repetir);
        return retorno;
    }
    
    
    public  OptionMenu controlMoverCartaBaraja(List<Baraja> barajas, Escaleras escalera,IOS ios,List<Card> origin,  Card card){
        int lectura=-1;
        boolean repetir=true;
        OptionMenu retorno=OptionMenu.MenuPrinicpal;
        do{
            ios.showTablero(barajas, escalera);
            lectura=ios.opcionesMenuMoverCartaABaraja();
            if ((lectura >= 1)&&(lectura<5)) {
                if (moverCartaBarja(origin,barajas.get(lectura).getCards(),card)){
                    repetir =false;
                    retorno= OptionMenu.MenuPrinicpal;
                    int indicePos=barajas.get(lectura).getPosCartaMostrada()+1;
                    barajas.get(lectura).setPosCartaMostrada(indicePos);
                    Baraja baraja = barajas.get(0);
                    baraja.setPosCartaMostrada(-1);
                }
                
            }
            else if (lectura==5){
                repetir =false;
                retorno= OptionMenu.MenuPrinicpal;
            }
        }while (repetir);
        return retorno;
    }
    
    
    public  boolean moverCartaBarja(List<Card> origin, List<Card> destin, Card card){
        if (destin.size()==0){
            if (NumbersCards.AS.equals(card.getNumbersCards())){
                int index= origin.indexOf(card);
                destin.add(card);
                origin.remove(index);
                return true;
            }
            else
                return false;
        }
        else{
            int positionCardPila=destin.size()-1;
            if (comprobarMover(destin.get(positionCardPila),card)){
                int index= origin.indexOf(card);
                destin.add(card);
                origin.remove(index);
                return true;
            }
            else return false;
        }
    }
    
    public  boolean comprobarMover(Card cardPila, Card card){
        boolean retorno=false;
        if (cardPila.getFamilyCard()==card.getFamilyCard()){
            if (cardPila.getColor()==card.getColor()){
                int diferencia=cardPila.getNumbersCards().ordinal()-card.getNumbersCards().ordinal();
                if(diferencia==1)
                    retorno=true;
            }
        }
        return retorno;
    }
    
    public  OptionMenu controlMoverCarta(List<Baraja> barajas , Escaleras escalera, IOS ios, Card card,List<Card> origin,boolean esBaraja){
        int lectura=-1;
        boolean repetir=true;
        OptionMenu retorno=OptionMenu.MenuPrinicpal;
        do{
            ios.showTablero(barajas, escalera);
            lectura=ios.opcionesMenuMoverCarta();
            if ((lectura >= 0)&&(lectura<7)) {
                if (esBaraja){
                    if (escalera.getEscaleras().get(lectura).moverCartaApila(card)){
                        repetir =false;
                        int index= origin.indexOf(card);
                        origin.remove(index);
                        retorno= OptionMenu.MenuPrinicpal;
                        Baraja baraja = barajas.get(0);
                        baraja.setPosCartaMostrada(-1);
                    }
                }
                else{
                    if (escalera.getEscaleras().get(lectura).moverCartasVisiblesApila(origin)){
                        repetir =false;
                        retorno= OptionMenu.MenuPrinicpal;
                    }
                }
                
            }
            else if (lectura==7){
                repetir =false;
                retorno= OptionMenu.MenuPrinicpal;
            }
        }while (repetir);
        return retorno;
    }







}