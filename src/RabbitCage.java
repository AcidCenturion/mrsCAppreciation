import java.util.ArrayList;
import java.util.Scanner;

public class RabbitCage {
    /* Bun Bun's Egg Quest 4 : */
    private boolean egg = false;

    private ArrayList<Integer> cardDeck = new ArrayList<>();
    private ArrayList<Integer> playerHand = new ArrayList<>();
    private ArrayList<Integer> dealerHand = new ArrayList<>();
    private Scanner myScan = new Scanner(System.in);
    private String userInput;
    private boolean hasBusted;

    //get egg
    public boolean getEgg(){
        return egg;
    }

    //create the card deck
    private void fillCardDeck(){
        //52 slots, 52 cards
        //for each card, 1-10
        for(int i = 1; i <= 10; i++) {
            //create 4 copies
            for (int j = 0; j < 4; j++) {
                cardDeck.add(i);
            }
        }
        //fill in for the face cards; 12 copies of 10
        for(int k = 0; k < 12; k++){
            cardDeck.add(10);
        }
    }

    //method to deal cards
    private int dealCard(){
        //upper bound : current size of deck (-1 for size vs index)
        //lower bound : 0
        //range : upper bound - lower bound + 1
        //range : (deck size - 1) - lower bound + 1
        //random : math random * range + lower bound
        int rand = (int)(Math.random() * cardDeck.size());
        //select the card
        int pickedCard = cardDeck.get(rand);
        //remove the card from th deck
        cardDeck.remove(rand);
        //return the card
        return pickedCard;
    }

    //create the hands
    private void gameSetUp(){
        for(int i = 0; i < 2; i++){
            playerHand.add(dealCard());
            dealerHand.add(dealCard());
        }
    }

    //find hand score
    private int handScore(ArrayList<Integer> eitherHand){
        int sum = 0;
        for(int i = 0; i < eitherHand.size(); i++){
            sum += eitherHand.get(i);
        }
        return sum;
    }

    //print the scores and hands
    private void handStatus(){
        System.out.println("Your hand ("+handScore(playerHand)+"):");
        for(int i = 0; i < playerHand.size(); i++){
            System.out.print(playerHand.get(i) + "   ");
        }
    }

    //run the game
    public void runGame() {
        //reset game
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        fillCardDeck();
        gameSetUp();
        hasBusted = false;

        //while the player has not busted
        while (!hasBusted) {
            handStatus();
            System.out.println();
            System.out.println("Bun Bun's hand (?):");
            System.out.print(dealerHand.get(0));
            System.out.println("   ?");

            System.out.print("\nWhat would you like to do? (Please enter the letter a or b) " +
                    "\n\ta) hit (add a card)" +
                    "\n\tb) stay (do not draw a card)" +
                    "\n>>> ");
            userInput = myScan.nextLine();
            System.out.println();
            while(!(userInput.equals("a") ||userInput.equals("b"))){
                //Inform the user to try again
                System.out.println("Please input an option exactly as specified");

                //Scan again for new user input
                userInput = myScan.nextLine();
                System.out.println();
            }
            if (userInput.equals("a")) {
                playerHand.add(dealCard());
                //check for bust
                if (handScore(playerHand) > 21) {
                    hasBusted = true;
                }
            }
            else{
                break;
            }
        }

        //have dealer draw
        while(handScore(dealerHand) < 16){
            dealerHand.add(dealCard());
        }

        //show final results
        handStatus();

        //print rest of dealer's hand
        System.out.println();
        System.out.println("Bun Bun's hand ("+handScore(dealerHand)+"):");
        for(int i = 0; i < dealerHand.size(); i++){
            System.out.print(dealerHand.get(i)+"   ");
        }
        System.out.println();
        System.out.println();

        //determine winner
        if(handScore(playerHand)>21){
            System.out.println("You busted.");
            System.out.println("Bun Bun wins.");
        }
        else if(handScore(playerHand)<=21 && handScore(dealerHand)>21){
            System.out.println("Bun Bun busted.");
            System.out.println("You win");
        }
        else{
            //general math calc
            if(handScore(playerHand)>handScore(dealerHand)){
                System.out.println("You win");
            }
            else{
                System.out.println("Bun Bun wins.");
            }
        }
        System.out.println();
    }
}
