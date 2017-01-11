package klondike;

import java.util.List;

public class MoverCartaAPaloDesdeEscaleraController  extends MoverCartaAPaloController {

    public MoverCartaAPaloDesdeEscaleraController(Tablero tablero, IOS ios) {
        super(tablero, ios);
    }

    @Override
    public void actualizarLasCartasAMostrar(PilaFamiliaCartas pilaFamiliaCartas) {
        this.actualizarLaCartaAMostrarEnPalos (pilaFamiliaCartas);
        
    }

    @Override
    public List<Card> seleccionListaDeCartasOrigen() {
        List<Card> origin = null;
        int posicionPila = this.getTablero().getEscalera().getPilaCartaSeleccionada();
        origin = this.getTablero().getEscalera().getEscaleras().get(posicionPila).getPilaCartas();
        return origin;
    }

    @Override
    public Card seleccionCartaAMoverAEscalera() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean moverCartasAEscalera(List<Card> origin, List<Card> destin, Card card) {
        
        return this.getMoverCartaController().moverCartasVisiblesAEscalera(origin, destin);
    }

    @Override
    public Card seleccionCartaAMoverAPalos() {
        Card card;
        int posicionPila = this.getTablero().getEscalera().getPilaCartaSeleccionada();
        // obtengo la posicion de la carta
        int posicionCarta = this.getTablero().getEscalera().getEscaleras().get(posicionPila).getPilaCartas().size() - 1;
        // carta seleccionada para mover de una escalera seleccionada
        card = this.getTablero().getEscalera().getEscaleras().get(posicionPila).getPilaCartas().get(posicionCarta);
        return card;
    }

}
