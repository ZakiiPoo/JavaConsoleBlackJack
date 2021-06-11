import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<>();

    public Hand(){

    }

    //Makes the data to string
    public String toString(){
        String toReturn = "";
        for(Card card : hand){
            toReturn +=  card.toString() + ", ";
        }
        toReturn += " | Total: " + value();

        return toReturn;
    }

    //adds a card to the hand
    public void giveCard(Card card){
        hand.add(card);
    }

    //prints out the hand
    public void showHand(){
        toString();
        System.out.println(toString());
    }

    //Gets the value of the hand (adds up all the cards in the hand)
    public int value(){
        int sum = 0;
        int Aces11 = 0;

        for(Card card : hand){
            sum += card.getValue();

            //this part is for the Aces
            if (card.getValue() == 11){
                Aces11++;
            }
        }

        //switches Aces when needed
        while(sum > 21 && Aces11 > 0){
            for(Card card : hand){
                if (card.getValue() == 11){
                    card.changeValue(1);
                    sum-= 10;
                    break;
                }
            }
        }

        return sum;
    }

    //Might empty the hand (hasn't been tested yet lol)
    public void emptyHand(){
        hand.removeAll(hand);
    }
}
