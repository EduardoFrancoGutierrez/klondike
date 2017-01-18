package klondike.model;

public class Card {

    private static final String HIDDEN_CARD = "HiddenCard";

    private FamilyCards familyCard;

    private NumbersCards numbersCards;

    private Color color;

    private boolean visible;

    public Card(FamilyCards familyCard, NumbersCards numbersCards) {
        this.visible = false;
        this.familyCard = familyCard;
        this.numbersCards = numbersCards;
        this.color = assignColor(familyCard);
    }

    public FamilyCards getFamilyCard() {
        return familyCard;
    }

    public void setFamilyCard(FamilyCards familyCard) {
        this.familyCard = familyCard;
    }

    public NumbersCards getNumbersCards() {
        return numbersCards;
    }

    public void setNumbersCards(NumbersCards numbersCards) {
        this.numbersCards = numbersCards;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    private Color assignColor(FamilyCards familyCard) {
        Color color;
        if ((FamilyCards.Hearts.equals(familyCard)) || (FamilyCards.Diamonds.equals(familyCard)))
            color = Color.Red;
        else
            color = Color.Black;
        return color;
    }

    @Override
    public String toString() {
        String returnToString;
        if (!this.visible)
            returnToString = HIDDEN_CARD;
        else
            returnToString = this.numbersCards + "_" + this.familyCard + "_" + this.color;
        return returnToString;
    }

}
