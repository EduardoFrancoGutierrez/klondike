package klondike;

import java.util.ArrayList;
import java.util.List;

public class PilaCartas {
    private List<Card> pilaCartas;

    public PilaCartas() {
        this.pilaCartas = new ArrayList<Card>();
    }

    public List<Card> getPilaCartas() {
        return pilaCartas;
    }

    public void setPilaCartas(List<Card> pilaCartas) {
        this.pilaCartas = pilaCartas;
    }
    
    public int size (){
        return this.pilaCartas.size();
    }

    
 

}
