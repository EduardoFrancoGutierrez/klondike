package klondike.model;

import java.util.ArrayList;
import java.util.List;

public class StackCards {
    private List<Card> satckCards;

    public StackCards() {
        this.satckCards = new ArrayList<Card>();
    }

    public List<Card> getSatckCards() {
        return satckCards;
    }

    public void setSatckCards(List<Card> satckCards) {
        this.satckCards = satckCards;
    }
    
    public int size (){
        return this.satckCards.size();
    }

    
 

}
