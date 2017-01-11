package klondike;

import java.util.ArrayList;
import java.util.List;

public class MoverCartaController {

    
    public  boolean moverCartaAPaloFamilia(List<Card> origin, List<Card> destin, Card card){
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
   
    
    public boolean moverCartasVisiblesAEscalera(List<Card> origin,List<Card> destin){
        boolean retorno=false;
        List<Integer> posicionesEliminarPilaOrigen= new ArrayList<Integer>();
        for (Card card: origin){
            if (card.getVisible()){
                if (this.moverCartaAEscalera( card, destin)){
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
    
    public boolean moverCartaAEscalera(List<Card> origin,Card card,List<Card> destin){
        if (moverCartaAEscalera(card,destin)){
            int index = origin.indexOf(card);
            origin.remove(index);
            return true;
        }
        return false;
    }
    
    public boolean moverCartaAEscalera(Card card,List<Card> destin){
        boolean retorno=false;
        int tam=destin.size()-1;
        if (tam==-1){
            if (card.getNumbersCards().equals(NumbersCards.K)){
                destin.add(card);
                retorno=true;
            }
        }
        else{
            if(this.isMenorCarta(destin.get(tam), card)){
                destin.add(card);
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
