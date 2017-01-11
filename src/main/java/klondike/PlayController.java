package klondike;

import java.util.List;

public class PlayController {

    private Tablero tablero;

    private IOS ios;

    private MoverCartaController moverCartaController;
    
    private MoverCartaAPaloDesdeEscaleraController moverCartaAPaloDesdeEscaleraController;
    
    private MoverCartaAPaloDesdeBarajaController moverCartaAPaloDesdeBarajaController;

    public PlayController(Tablero tablero, IOS ios) {
        super();
        this.tablero = tablero;
        this.ios = ios;
        this.moverCartaController = new MoverCartaController();
        this.moverCartaAPaloDesdeBarajaController = new MoverCartaAPaloDesdeBarajaController(tablero,ios);
        this.moverCartaAPaloDesdeEscaleraController= new MoverCartaAPaloDesdeEscaleraController(tablero,ios);
    }

    public int controlDeGestionDeMenus() {
        int lectura = -1;
        boolean repetir = true;
        OptionMenu menu = OptionMenu.MenuPrinicpal;
        do {
            // ios.showTablero(baraja, escalera);
            switch (menu) {
            case MenuPrinicpal:
                menu = menuPrincipal();
                break;
            case MenuBaraja:
                menu = controlBaraja();
                break;
            case MenuEscaleras:
                menu = controlEscaleras();
                break;
            case MenuMoverCartaAPalosDesdeBaraja:
                menu = moverCartaAPaloDesdeBarajaController.controlMoverCartaAPalos(); 
                break;
            case MenuMoverCartaAPalosDesdeEscalera:
                menu = this.moverCartaAPaloDesdeEscaleraController.controlMoverCartaAPalos();
                break;
            case MenuMoverCartaAEscaleraDesdeBaraja:
                menu = this.moverCartaAPaloDesdeBarajaController.controlMoverCartaAEscalera();
                break;    
            case MenuMoverCartaAEscaleraDesdeEscalera:
                 menu = this.moverCartaAPaloDesdeEscaleraController.controlMoverCartaAEscalera();
                break;
            case Exit:
                repetir = false;
                System.exit(0);
                break;

            }

        } while (repetir);
        return lectura;
    }

    public OptionMenu menuPrincipal() {
        int lectura = -1;
        boolean repetir = true;
        OptionMenu retorno = OptionMenu.MenuPrinicpal;
        do {
            ios.showTablero(tablero);
            lectura = ios.showMenu();
            if (lectura == 0) {
                retorno = OptionMenu.MenuBaraja;
                repetir = false;
            } else if ((lectura > 0) && (lectura < 8)) {
                this.ponerEscaleraSeleccionada(lectura);
                retorno = OptionMenu.MenuEscaleras;
                repetir = false;
            }
            else if (lectura == 8) {
                retorno = OptionMenu.Exit;
                repetir = false;
            }
        } while (repetir);
        return retorno;
    }

    public OptionMenu controlBaraja() {
        int lectura = -1;
        boolean repetir = true;
        OptionMenu retorno = OptionMenu.MenuPrinicpal;
        do {
            ios.showTablero(tablero);
            lectura = ios.opcionesMenuBaraja();
            switch (lectura) {
                case 0:
                    if (!tablero.getBaraja().mostrarSiguienteCarta()) {
                        repetir = false;
                    }
                    break;
                case 1:
                    if ((tablero.getBaraja().size() > 0) && (tablero.getBaraja().getPosCartaMostrada() >= 0)) {
                        retorno = OptionMenu.MenuMoverCartaAEscaleraDesdeBaraja;
                        repetir = false;
                    }
                    break;
                case 2:
                    if (this.comprobarVisibleCartaEnBaraja()){
                        retorno=OptionMenu.MenuMoverCartaAPalosDesdeBaraja;
                        repetir=false;
                    }
                    break;
                case 3:
                    retorno = OptionMenu.MenuPrinicpal;
                    repetir = false;
                    break;
                case 4:
                    retorno= OptionMenu.Exit;
                    repetir=false;
            }
            
        } while (repetir);
        return retorno;
    }

    public OptionMenu controlEscaleras() {
        int lectura = -1;
        boolean repetir = true;
        OptionMenu retorno = OptionMenu.MenuPrinicpal;
        do {
            ios.showTablero(tablero);
            lectura = ios.opcionesMenuEscalera();
            Card card = this.cartaSeleccionadaDesdeEscalera();
            switch (lectura) {
            case 0:
                if (card.getVisible()) {
                    retorno = OptionMenu.MenuMoverCartaAEscaleraDesdeEscalera;
                    repetir = false;
                }
                break;
            case 1:
                if (card.getVisible()) {
                    retorno = OptionMenu.MenuMoverCartaAPalosDesdeEscalera;
                    repetir = false;
                }
                break;
            case 2:
                if (!card.getVisible()) {
                    card.setVisible(true);
                }
                break;                
            case 3:
                retorno = OptionMenu.MenuPrinicpal;
                repetir = false;
                break;    
            case 4:
                retorno= OptionMenu.Exit;
                repetir=false;
        }
        } while (repetir);
        return retorno;
    }

   
    public OptionMenu controlMoverCartaAPalosDesdeEscalera() {
        List<Card> origin = this.seleccionListaDeCartasOrigenDesdeEscalera();
        Card card = this.cartaSeleccionadaDesdeEscalera();
        return moverCartaAPaloDesdeEscaleraController.controlMoverCartaAPalos();
    }
    
    public OptionMenu controlMoverCartaAPalosDesdeBaraja() {
        List<Card> origin = this.seleccionListaDeCartasOrigenDesdeBaraja();
        Card card = this.seleccionCartaAMoverDesdeBaraja();
        return moverCartaAPaloDesdeBarajaController.controlMoverCartaAPalos();
    }    
    
      
    
   
    
    private Card cartaSeleccionadaDesdeEscalera() {
        Card card;

        int posicionPila = tablero.getEscalera().getPilaCartaSeleccionada();
        // obtengo la posicion de la carta
        int posicionCarta = tablero.getEscalera().getEscaleras().get(posicionPila).getPilaCartas().size() - 1;
        // carta seleccionada para mover de una escalera seleccionada
        card = tablero.getEscalera().getEscaleras().get(posicionPila).getPilaCartas().get(posicionCarta);

        return card;
    }

    private List<Card> seleccionListaDeCartasOrigenDesdeEscalera() {
        List<Card> origin = null;
        int posicionPila = tablero.getEscalera().getPilaCartaSeleccionada();
        origin = tablero.getEscalera().getEscaleras().get(posicionPila).getPilaCartas();
        
        return origin;
    }

    
    
    private Card seleccionCartaAMoverDesdeBaraja() {
        Card card;
        // coge la carta del monton que esta mostrada
        card = tablero.getBaraja().getCards().get(tablero.getBaraja().getPosCartaMostrada());
        
        return card;
    }

    private List<Card> seleccionListaDeCartasOrigenDesdeBaraja() {
        List<Card> origin = null;
        origin = tablero.getBaraja().getCards();
        return origin;
    }
    
    public void actualizarLaCartaAMostrarEnPalos (PilaFamiliaCartas pilaFamiliaCartas){
        int indicePos = pilaFamiliaCartas.getPosCartaMostrada() + 1;
        pilaFamiliaCartas.setPosCartaMostrada(indicePos);
    }
    
    public  void actualizarLaCartaAMostrarEnBarja (){
       if (this.tablero.getBaraja().getPosCartaMostrada()>=0){
           int posicion=this.tablero.getBaraja().getPosCartaMostrada()-1;
           tablero.getBaraja().setPosCartaMostrada(posicion);
       }
    }
    
    public void ponerEscaleraSeleccionada(Integer seleccionEscalera){
        int posicionEscaleraSeleccionada = seleccionEscalera - 1;
        if (tablero.getEscalera().getEscaleras().get(posicionEscaleraSeleccionada).size() > 0) {
            tablero.getEscalera().setPilaCartaSeleccionada(posicionEscaleraSeleccionada);
        }
    }
    
    public boolean comprobarVisibleCartaEnBaraja(){
        boolean retorno= false;
        int pos = tablero.getBaraja().getPosCartaMostrada();
        if (pos != -1) {
            Card card = tablero.getBaraja().getCards().get(pos);
            if (card.getVisible()) {
                retorno = true;
            }
        }
        return retorno;
    }
    /*
     * public OptionMenu controlMoverCartaAPalos(List<Card> origin, Card card) {
        int lectura = -1;
        boolean repetir = true;
        OptionMenu retorno = OptionMenu.MenuPrinicpal;
        do {
            ios.showTablero(tablero);
            lectura = ios.opcionesMenuMoverCartaAPalos();
            if ((lectura >= 1) && (lectura < 5)) {
                if (this.moverCartaController.moverCartaAPaloFamilia(origin, tablero.getPilasFamily().get(lectura).getCards(), card)) {
                    this.actualizarLaCartaAMostrarEnPalos(tablero.getPilasFamily().get(lectura));
                    this.actualizarLaCartaAMostrarEnBarja();
                    repetir = false;
                    retorno = OptionMenu.MenuPrinicpal;
                    
                }

            } else{
                repetir = false;
                if (lectura == 5) 
                       retorno = OptionMenu.MenuPrinicpal;
                if (lectura== 6) 
                        retorno = OptionMenu.Exit;
            }
        } while (repetir);
        return retorno;
    }
    
    
    
     public OptionMenu controlMoverCartaEscaleraDesdeBaraja() {
        int lectura = -1;
        boolean repetir = true;
        OptionMenu retorno = OptionMenu.MenuPrinicpal;
        do {
            ios.showTablero(tablero);
            lectura = ios.opcionesMenuMoverCartaEscalera();
            if ((lectura >= 1) && (lectura < 8)) {
                    int posicion = lectura - 1;
                    List<Card> origin = this.seleccionListaDeCartasOrigenDesdeBaraja();
                    Card card = this.seleccionCartaAMoverDesdeBaraja();
                    List<Card> escaleraDestino=tablero.getEscalera().getEscaleras().get(posicion).getPilaCartas();
                    if (this.moverCartaController.moverCartaAEscalera(origin,card, escaleraDestino)) {
                        this.actualizarLaCartaAMostrarEnBarja();
                        repetir = false;
                        retorno = OptionMenu.MenuPrinicpal;
                    }                 
            } else {
                repetir = false;
                if (lectura == 8) 
                       retorno = OptionMenu.MenuPrinicpal;
                if (lectura== 9) 
                        retorno = OptionMenu.Exit;
            }
        } while (repetir);
        return retorno;
    }

    
    public OptionMenu controlMoverCartaEscaleraDesdeEscalera() {
        int lectura = -1;
        boolean repetir = true;

        OptionMenu retorno = OptionMenu.MenuPrinicpal;
        do {
            ios.showTablero(tablero);
            lectura = ios.opcionesMenuMoverCartaEscalera();
            if ((lectura >= 1) && (lectura < 8)) {
                int posicion = lectura - 1;
                List<Card> origin = this.seleccionListaDeCartasOrigenDesdeEscalera();
                List<Card> escaleraDestino=tablero.getEscalera().getEscaleras().get(posicion).getPilaCartas();
                    if (this.moverCartaController.moverCartasVisiblesAEscalera(origin, escaleraDestino)) {
                        repetir = false;
                        retorno = OptionMenu.MenuPrinicpal;
                    }
            } else {
                repetir = false;
                if (lectura == 8) 
                       retorno = OptionMenu.MenuPrinicpal;
                if (lectura== 9) 
                        retorno = OptionMenu.Exit;
            }
        } while (repetir);
        return retorno;
    }
    
    
    
    
     */
    
}
