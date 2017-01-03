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

    
    public boolean moverCartasVisiblesApila(List<Card> origin){
        boolean retorno=false;
        List<Integer> posicionesEliminarPilaOrigen= new ArrayList<Integer>();
        for (Card card: origin){
            if (card.getVisible()){
                if (this.moverCartaApila( card)){
                    int index= origin.indexOf(card);
                    posicionesEliminarPilaOrigen.add(index);
                    retorno =true;
                }
                else{
                    return false;
                }
            }  
        }
        for (int i=posicionesEliminarPilaOrigen.size()-1; i>=0; i--){
            origin.remove(posicionesEliminarPilaOrigen.get(i).intValue());
        }
        return retorno;
        
    }
    
    public boolean moverCartaApila(Card card){
        boolean retorno=false;
        int tam=this.pilaCartas.size()-1;
        if (tam==-1){
            if (card.getNumbersCards().equals(NumbersCards.K)){
                this.pilaCartas.add(card);
                retorno=true;
            }
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
                int diferencia=card.getNumbersCards().ordinal()-cardPila.getNumbersCards().ordinal();
                if(diferencia==1)
                    retorno=true;
            }
        }
        return retorno;
    }
    

}
