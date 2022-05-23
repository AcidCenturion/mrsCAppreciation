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
    public String runGame(boolean egg1, boolean egg2) {

        //introduce game
        System.out.println("There are many rabbits in the cage, gathered together in groups. In the corner, I ");
        System.out.println("spot a lone pink rabbit with droopy ears shuffling a deck of cards. I wonder how it ");
        System.out.println("managed to get ahold of the cards; I do remember having a deck somewhere in the house. ");
        System.out.println("The rabbit looks up at me as it continues shuffling the cards. Seems like this one has ");
        System.out.println("been sitting here for some time. I walk around the cage to get a closer look. The ");
        System.out.println("rabbit stops shuffling cards and turns towards me expectantly.");
        System.out.println("\"Hello Mrs. C! I'm Bun Bun!\"");
        System.out.println("How strange, I don't remember seeing a pink rabbit in my rabbit cage before.");
        System.out.println("\"Want to play a game of blackjack with me? If you win, I'll give you a nice prize!\"");
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
            while(!(userInput.equalsIgnoreCase("a") ||userInput.equalsIgnoreCase("b"))){
                //Inform the user to try again
                System.out.println("Please input an option exactly as specified.");

                //Scan again for new user input
                userInput = myScan.nextLine();
                System.out.println();
            }
            if (userInput.equalsIgnoreCase("a")) {
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
            System.out.println("\"Aww...nice try. Better luck next time!\"");
            System.out.println("Bun Bun goes back to her corner of the cage and continues shuffling the deck of cards.");
        }
        else if(handScore(playerHand)<=21 && handScore(dealerHand)>21){
            System.out.println("Bun Bun busted.");
            System.out.println("You win!");
            System.out.println();
            System.out.println("\"Congrats, Mrs. C! I knew you could do it. Here, take this.\"");
            System.out.println("Bun Bun hands you an egg");
            System.out.println("\"I suppose you know what to do with this, right?\"");
            System.out.println();
            System.out.println("You obtained an egg.");
            egg = true;
        }
        else{
            //general math calc
            if(handScore(playerHand)>handScore(dealerHand)){
                System.out.println("You win!");
                System.out.println();
                System.out.println("\"Congrats, Mrs. C! I knew you could do it. Here, take this.\"");
                System.out.println("Bun Bun hands you an egg.");
                System.out.println("\"I suppose you know what to do with this, right?\"");
                System.out.println();
                System.out.println("You obtained an egg.");
                egg = true;
            }
            else{
                System.out.println("Bun Bun wins.");
                System.out.println("\"Aww...nice try. Better luck next time!\"");
                System.out.println("Bun Bun goes back to her corner of the cage and continues shuffling the deck of cards.");
            }
        }
        System.out.println();
//Detail the room. This String is printed every time the user enters the room
        System.out.println("What would you like to observe?");
        System.out.println("1. Lightswitch    2. Rabbit Cage    3. Table    4. Living Room");

//Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        while(!(userInput.equalsIgnoreCase("Living Room"))){

            //If the player obtained the two eggs for the Rabbit ending
            //detail the ending and return the RabbitEnd
            if(userInput.equalsIgnoreCase("Table") && egg1 && egg2){

                //detail ending
                System.out.println("Rabbit Ending details...");

                //return the ending
                return "RabbitEnd";
            }

            //if player communicates with the czar hops w/o the eggs
            else if(userInput.equalsIgnoreCase("Table")){

                //detail the table and czar hops' instructions
                System.out.println("\"What are you waiting for? Hop to it already.\"");
                System.out.println();

                //offer different options based on if the chickens gave instructions
                System.out.println("What would you like to observe?");
                System.out.println("1. Lightswitch    2. Rabbit Cage    3. Table    4. Living Room");

                //Receive the user's input
                userInput = myScan.nextLine();
                System.out.println();

            }

            //if the player chooses the egg quests, ensure that they have met the chickens
            else if(userInput.equalsIgnoreCase("Lightswitch")){

                //return the correct location
                return "Lightswitch";
            }

            //ensure the chicken contact
            else if(userInput.equalsIgnoreCase("Rabbit Cage")){

                //return the correct location
                return "Rabbit Cage";
            }

            //If an input was given that is not an option in this room, ask for a new input again
            else {

                //Inform the user to try again
                System.out.println("Please input an option exactly as specified.");

                //Scan again for new user input
                userInput = myScan.nextLine();
                System.out.println();
            }
        }
        //Go to where player specifies
        return userInput;
    }
}
