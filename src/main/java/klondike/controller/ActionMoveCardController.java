package klondike.controller;

import java.util.ArrayList;
import java.util.List;

import klondike.model.Card;
import klondike.model.NumbersCards;

public class ActionMoveCardController {

    
    public  boolean moveCardToStackFamilyCards(List<Card> origin, List<Card> destin, Card card){
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
            int positionCardLadderSelected=destin.size()-1;
            if (moveTest(destin.get(positionCardLadderSelected),card)){
                int index= origin.indexOf(card);
                destin.add(card);
                origin.remove(index);
                return true;
            }
            else return false;
        }
    }
    
    public  boolean moveTest(Card cardPila, Card card){
        boolean test=false;
        if (cardPila.getFamilyCard()==card.getFamilyCard()){
            if (cardPila.getColor()==card.getColor()){
                int difference=cardPila.getNumbersCards().ordinal()-card.getNumbersCards().ordinal();
                if(difference==1)
                    test=true;
            }
        }
        return test;
    }
   
    
    public boolean moveCardsVisiblesToLadders(List<Card> origin,List<Card> destin){
        boolean test=false;
        List<Integer> positionDeleteStackOrign= new ArrayList<Integer>();
        for (Card card: origin){
            if (card.getVisible()){
                if (this.moveCardToLadder( card, destin)){
                    int index= origin.indexOf(card);
                    positionDeleteStackOrign.add(index);
                    test =true;
                }
                else{
                    return false;
                }
            }  
        }
        for (int i=positionDeleteStackOrign.size()-1; i>=0; i--){
            origin.remove(positionDeleteStackOrign.get(i).intValue());
        }
        return test;
        
    }
    
    public boolean moveCardToLadder(List<Card> origin,Card card,List<Card> destin){
        if (moveCardToLadder(card,destin)){
            int index = origin.indexOf(card);
            origin.remove(index);
            return true;
        }
        return false;
    }
    
    public boolean moveCardToLadder(Card card,List<Card> destin){
        boolean test=false;
        int size=destin.size()-1;
        if (size==-1){
            if (card.getNumbersCards().equals(NumbersCards.K)){
                destin.add(card);
                test=true;
            }
        }
        else{
            if(this.isSmallCard(destin.get(size), card)){
                destin.add(card);
                test=true;
            }
        }    
        return test;
    }
    
    public boolean isSmallCard(Card cardPila, Card card){
        boolean test=false;
        if (cardPila.getVisible()&&(card.getVisible())){
            if (cardPila.getColor()!=card.getColor()){
                int difference=card.getNumbersCards().ordinal()-cardPila.getNumbersCards().ordinal();
                if(difference==1)
                    test=true;
            }
        }
        return test;
    }
    
    
}
