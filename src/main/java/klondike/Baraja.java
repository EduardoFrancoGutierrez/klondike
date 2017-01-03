package klondike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baraja {
    private List<Card> cards;
    private int posCartaMostrada;
    
    public Baraja(){
        this.cards= new ArrayList<Card>();
        this.posCartaMostrada=-1;
        
    }
    
    public void construir (){       
        for (NumbersCards numbersCards: NumbersCards.values()){
            for(FamilyCards family : FamilyCards.values()){
                  Card card= new Card(family,numbersCards);
                  this.cards.add(card);
                
            }
        }
    }
    
    public void mezclar (){
        long seed = System.nanoTime();
        Collections.shuffle(this.cards, new Random(seed));
    }
    
    
 
    // public String sacarCarta ()
    //toDo:eliminar
    private <E extends Enum<E>> ArrayList<String> enumValues(Class<E> enumData) {
        ArrayList<String> EnumReturn= new ArrayList<String> ();
        for (Enum<E> enumVal: enumData.getEnumConstants()) {  
            EnumReturn.add(enumVal.toString());
        }
        return EnumReturn;  
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    
    //funcion que mueve una carta a una lista de cartas destino
    public void moveCard(List<Card> origin, List<Card> destin, Card card){
        int index= origin.indexOf(card);
        destin.add(origin.get(index));
        origin.remove(index);
    }
    public int size(){
        return this.cards.size();
    }
    
    public boolean mostrarSiguienteCarta(){
        boolean retorno=false;
        if (this.size()<1){
            this.posCartaMostrada=-1;
            return retorno;
        }
        else{
            int posCartaSiguenteMostrada= this.posCartaMostrada+1; 
            //si la posicion es igual al tamaño ha de volver a colocar ocultas las cartas
            if (posCartaSiguenteMostrada==this.size()){
                this.ocultarCartas();
                retorno=true;
                    
            }
            else{
                this.cards.get(posCartaSiguenteMostrada).setVisible(true);
                this.posCartaMostrada=posCartaSiguenteMostrada;
                retorno=true;
            }        

        }
        return retorno;
    }
   
    private void ocultarCartas(){
        for (Card card: this.cards){
            card.setVisible(false);
        }
        this.posCartaMostrada=-1;
    }

    public int getPosCartaMostrada() {
        return posCartaMostrada;
    }

    public void setPosCartaMostrada(int posCartaMostrada) {
        this.posCartaMostrada = posCartaMostrada;
    }
    
    
}
