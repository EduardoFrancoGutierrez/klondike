package klondike;

import java.util.ArrayList;
import java.util.List;

public class Escaleras {
    static public final int NUM_COLUMNAS = 7;
    static public final int MAX_NUM_FILAS = 20;
    private List<PilaCartas> escaleras;
    
    public Escaleras() {
        this.escaleras= new ArrayList<PilaCartas>();
        for (int i=0; i< NUM_COLUMNAS; i++) {
           escaleras.add(new PilaCartas());
        }
    }
    
    public void componerTableroInicial(Baraja baraja) {
        for (int i=0; i< NUM_COLUMNAS; i++) {
            PilaCartas pilaCarta= this.escaleras.get(i);
            for (int j=0; j <= i; j++) {
              baraja.moveCard(baraja.getCards(), pilaCarta.getPilaCartas(), baraja.getCards().get(0));
            }
            pilaCarta.getPilaCartas().get(this.escaleras.get(i).getPilaCartas().size()-1).setVisible(true);
        }
    }

    public List<PilaCartas> getEscaleras() {
        return escaleras;
    }

    public void setEscaleras(List<PilaCartas> escaleras) {
        this.escaleras = escaleras;
    }
    
    public boolean moverCardOtraPila(Integer pilaOrigen, Integer pilaDestino){
        boolean retorno=false;
        if (this.escaleras.get(pilaOrigen).size()<1)
            retorno=false;
        else{
            int position=this.escaleras.get(pilaOrigen).size()-1;
            Card card= this.escaleras.get(pilaOrigen).getPilaCartas().get(position);
            retorno=this.escaleras.get(pilaDestino).moverCartaApila(card);
        }
        return retorno;
    }
    
}
