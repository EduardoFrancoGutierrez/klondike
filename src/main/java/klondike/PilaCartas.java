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

    public boolean moverCartaApila(Card card){
        boolean retorno=false;
        int tam=this.pilaCartas.size()-1;
        if (tam==-1){
            this.pilaCartas.add(card);
        }
        else{
            if(this.isMenorCarta(this.pilaCartas.get(tam), card)){
                this.pilaCartas.add(card);
                retorno=true;
            }
        }
            
        return retorno;
    }
    
    public boolean isMenorCarta(Card cardPila, Card card){
        boolean retorno=false;
        if (cardPila.getVisible()&&(card.getVisible())){
            if (cardPila.getColor()!=card.getColor()){
                if(cardPila.getNumbersCards().ordinal()<card.getNumbersCards().ordinal())
                    retorno=true;
            }
        }
        return retorno;
    }
    

}
