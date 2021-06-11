public class Card {
    private String type; //Name or house of the card
    private String suit; //The suit of the carf
    private int value; //Value of the card

    public Card(String type, String suit, int value){
        this.type = type;
        this.suit = suit;
        this.value = value;
    }

    //returns a string version of the card with the value as well
    public String toString(){
        return type + " of " + suit + " (" + value + ")"; 
    }

    //gets the card name
    public String getType(){
        return type;
    }

    //gets the card suit
    public String getSuit() {
        return suit;
    }

    //gets the card value
    public int getValue() {
        return value;
    }

    //can be used to change the value of the card (For Aces) 
    public void changeValue(int newValue){
        value = newValue;
    }
}
