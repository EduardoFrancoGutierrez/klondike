package klondike;

import java.util.List;

public abstract class MoverCartaAPaloController {
    private Tablero tablero;

    private IOS ios;

    private MoverCartaController moverCartaController;
    
    public MoverCartaAPaloController(Tablero tablero, IOS ios) {
        super();
        this.tablero = tablero;
        this.ios = ios;
        this.moverCartaController = new MoverCartaController();
    }
    public OptionMenu controlMoverCartaAPalos() {
        int lectura = -1;
        boolean repetir = true;
        OptionMenu retorno = OptionMenu.MenuPrinicpal;
        do {
            ios.showTablero(tablero);
            lectura = ios.opcionesMenuMoverCartaAPalos();
            if ((lectura >= 1) && (lectura < 5)) {
                List<Card> origin =this.seleccionListaDeCartasOrigen();
                Card card=this.seleccionCartaAMoverAPalos();
                if (this.moverCartaController.moverCartaAPaloFamilia(origin, tablero.getPilasFamily().get(lectura).getCards(), card)) {
                    this.actualizarLasCartasAMostrar(tablero.getPilasFamily().get(lectura));
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
    
    public OptionMenu controlMoverCartaAEscalera() {
        int lectura = -1;
        boolean repetir = true;
        OptionMenu retorno = OptionMenu.MenuPrinicpal;
        do {
            ios.showTablero(tablero);
            lectura = ios.opcionesMenuMoverCartaEscalera();
            if ((lectura >= 1) && (lectura < 8)) {
                    int posicion = lectura - 1;
                    List<Card> origin = this.seleccionListaDeCartasOrigen();
                    Card card = this.seleccionCartaAMoverAEscalera();
                    List<Card> escaleraDestino=tablero.getEscalera().getEscaleras().get(posicion).getPilaCartas();
                    if (this.moverCartasAEscalera(origin, escaleraDestino,card)) {
                        //this.actualizarLaCartaAMostrarEnBarja();
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
    
    public abstract void actualizarLasCartasAMostrar(PilaFamiliaCartas pilaFamiliaCartas);
    
    public abstract List<Card>  seleccionListaDeCartasOrigen();
    
    public abstract Card  seleccionCartaAMoverAEscalera();
    public abstract Card  seleccionCartaAMoverAPalos();
    
    public abstract Boolean  moverCartasAEscalera(List<Card> origin, List<Card> destin, Card card);
    
    
    
    public void actualizarLaCartaAMostrarEnPalos (PilaFamiliaCartas pilaFamiliaCartas){
        int indicePos = pilaFamiliaCartas.getPosCartaMostrada() + 1;
        pilaFamiliaCartas.setPosCartaMostrada(indicePos);
    }
    
    public Tablero getTablero() {
        return tablero;
    }
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    public IOS getIos() {
        return ios;
    }
    public void setIos(IOS ios) {
        this.ios = ios;
    }
    public MoverCartaController getMoverCartaController() {
        return moverCartaController;
    }
        
}
