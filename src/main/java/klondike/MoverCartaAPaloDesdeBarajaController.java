package klondike;

import java.util.List;

public class MoverCartaAPaloDesdeBarajaController extends MoverCartaAPaloController {

    public MoverCartaAPaloDesdeBarajaController(Tablero tablero, IOS ios) {
        super(tablero, ios);
    }

    @Override
    public void actualizarLasCartasAMostrar(PilaFamiliaCartas pilaFamiliaCartas) {
       this.actualizarLaCartaAMostrarEnPalos (pilaFamiliaCartas);
       this.actualizarLaCartaAMostrarEnBarja();
        
    }
    
    
    
    public  void actualizarLaCartaAMostrarEnBarja (){
       if (this.getTablero().getBaraja().getPosCartaMostrada()>=0){
           int posicion=this.getTablero().getBaraja().getPosCartaMostrada()-1;
           getTablero().getBaraja().setPosCartaMostrada(posicion);
       }
    }

    @Override
    public List<Card> seleccionListaDeCartasOrigen() {
        List<Card> origin = null;
        origin = this.getTablero().getBaraja().getCards();
        return origin;
    }

   
    @Override
    public Boolean moverCartasAEscalera(List<Card> origin, List<Card> destin, Card card) {
        boolean retorno = this.getMoverCartaController().moverCartaAEscalera(origin,card, destin);
        if (retorno)
            this.actualizarLaCartaAMostrarEnBarja();
        return retorno;
    }

    @Override
    public Card seleccionCartaAMoverAEscalera() {
        Card card;
        card = this.getTablero().getBaraja().getCards().get(this.getTablero().getBaraja().getPosCartaMostrada());
        return card;
    }

    @Override
    public Card seleccionCartaAMoverAPalos() {        
        return this.seleccionCartaAMoverAEscalera();
    }

}
