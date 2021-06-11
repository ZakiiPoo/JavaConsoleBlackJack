import java.util.Scanner;

public class Game {
    private Hand dealersHand  = new Hand(); //creates a hand for the dealer
    private Hand playersHand = new Hand(); //creats a hand for the player

    private String tempStop;
    private Scanner scanner = new Scanner(System.in); //Makes a scanner

    public Game(){

    }

    //Show's  the current Hands
    public void showAllHands(){
        System.out.print("Dealers Hand: ");
        dealersHand.showHand();
        System.out.println("---------------------------");
        System.out.print("Your Hand: ");
        playersHand.showHand();
    }

    //Checks if hand is bust
    public  boolean checkBust(Hand hand){
        if(hand.value() > 21){
            return true;
        }
        return false;
    }

    //plays a game 
    public void playGame(){
        
        //Getting the game ready
        boolean stand = false;
        Deck playCards = new Deck(); //Makes a new deck called playcards
        playCards.fillDeck(); //Fills it with new cards
        playCards.shuffleDeck(); //Shuffle's the deck
        int userInput; //what the user will say

        //Tells the user the game is about to start
        System.out.println("You are about to start a game of Black Jack \nPress ENTER To Continue:");
        tempStop = scanner.nextLine();
        System.out.println();

        dealersHand.giveCard(playCards.drawCard()); //gives a card to the dealer
        playersHand.giveCard(playCards.drawCard());//gives a card to the player (12, 24)
        playersHand.giveCard(playCards.drawCard()); 
        showAllHands(); //shows both hands
        System.out.println(); //adds a space line

        //prompts the player to hit ot stand until they bust or stand
        while(!checkBust(playersHand) && !stand){
            System.out.print("Hit(1) or Stand(2): ");
            userInput = scanner.nextInt();

            if(userInput != 1 && userInput != 2){
                System.out.println(userInput + " Is not a valid answer please try again \n(make sure to use the numbers)");
            }

            if(userInput == 2){
                stand = true;
            }
            else if(userInput == 1){
                playersHand.giveCard(playCards.drawCard());
            }

            System.out.println();
            showAllHands(); //shows both hands
            System.out.println(); //adds a space line
        }

        if(checkBust(playersHand)){
            System.out.println("Oh no! Your hand busted! You lost...");
            playAgain();
        }
        else{
            while(dealersHand.value() < playersHand.value() && !checkBust(dealersHand)){
                dealersHand.giveCard(playCards.drawCard());
                showAllHands();

                System.out.println("Press ENTER To Continue:");
                tempStop = scanner.nextLine();
                System.out.println();
            }

            if(checkBust(dealersHand)){
                System.out.println("You win! the dealer busted congrats");
                playAgain();
            }
            else if(dealersHand.value() > playersHand.value()){
                System.out.println("Oh no! The Dealer has more points. You lost...");
                playAgain();
            }
            else if(dealersHand.value() == playersHand.value()){
                System.out.println("You tied");
                playAgain();
            }
        }
    }

    //starts the game again with empty hands
    public void playAgain(){
        System.out.print("Would you like to play again? (yes): ");
        scanner.nextLine();
        tempStop = scanner.nextLine();
        if(tempStop.equals("yes")){
            playersHand.emptyHand();
            dealersHand.emptyHand();
            playGame();
        }
        else{
            System.out.println("Ok bye have a good day!");
        }
    }
}
