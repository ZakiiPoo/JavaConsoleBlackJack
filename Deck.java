import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deckOfCards = new ArrayList<Card>(); //ArrayList to put all the cards int
    private Card tempCard; //tempCard for draw card method


    //fills the deck up with 52 playing cards cards
    public void fillDeck(){
        String[] sList = {"Hearts", "Dimionds", "Spades", "Clubs"};
        for(String sName : sList) {
            deckOfCards.add(new Card("Ace", sName, 11)); //Ace will be changed automatically (in Hand.value)
            deckOfCards.add(new Card("Two", sName, 2));
            deckOfCards.add(new Card("Three", sName, 3));
            deckOfCards.add(new Card("Four", sName, 4));
            deckOfCards.add(new Card("Five", sName, 5));
            deckOfCards.add(new Card("Six", sName, 6));
            deckOfCards.add(new Card("Seven", sName, 7));
            deckOfCards.add(new Card("Eight", sName, 8));
            deckOfCards.add(new Card("Nine", sName, 9));
            deckOfCards.add(new Card("Ten", sName, 10));
            deckOfCards.add(new Card("Jack", sName, 10));
            deckOfCards.add(new Card("Queen", sName, 10));
            deckOfCards.add(new Card("King", sName, 10));
        }
    }

    //Shuffles the deck
    public void shuffleDeck(){
        Collections.shuffle(deckOfCards); //uses java.util.Collections to shuffle the deck ArrayList
    }

    //Draws a card and returns the drawn card after a card is drawn it is removed from the deck
    public Card drawCard(){
        tempCard = deckOfCards.get(0); //sets tempCard to first card in deck
        deckOfCards.remove(0); //removes the first card in the deck
        return tempCard; //returns the tempCard
    }

    //This method is only for debugging it will get the card in the card at the index provided in the parameter
    public Card drawCard(int indexOfCard){
        Card tempCard = deckOfCards.get(indexOfCard);
        deckOfCards.remove(indexOfCard);
        return tempCard;
    }
    
}
