import java.util.Scanner;

public class Nightstand {
    /* This class holds the information about the Nightstand Scene. This class will have a method
     * detailing all the interactable objects within the room. This class will also have information
     * about items that can be found inside this scene.
     */

    //Boolean variables that store if the player has obtained the item
    private boolean flashlight = false;

    //get the flashlight
    public boolean getFlashlight(){
        return flashlight;
    }

    /* Create method to print details about all the interactables in a scene.
     * If the player moves location, return the new location as a string
     * Return String
     * Boolean Parameters only if an item is needed
     * Call method in Player by setting this method as the value for the location variable.
     * When the player chooses a location, return that location and move the player to that scene.
     * Scanner is Required
     */
    public String interactables(){

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //Detail the room. This String is printed every time the user enters the room
        System.out.println("On my nightstand I always keep a glass of water, just in case I need to keep hydrated. ");
        System.out.println("I probably won’t be needing it at all today; I can just get water from the kitchen ");
        System.out.println("later. In the drawer I keep a spare flashlight in case power goes out. On the top of ");
        System.out.println("my nightstand there’s...a letter? I don’t remember keeping letters on my nightstand.");
        System.out.println();
        System.out.println("Where would you like to go?");
        System.out.println("1. Letter    2. Flashlight    3. Bedroom");

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Letter, Flashlight
        //Options to move to a different scene: Return to Bedroom
        while(!(userInput.equalsIgnoreCase("Bedroom") || userInput.equals("3"))){

            //If the input was the Letter dead-end scenes,
            //detail the Letter and return to the Nightstand scene afterwards
            if(userInput.equalsIgnoreCase("Letter") || userInput.equals("1")){

                //Print the dialogue about the Letter
                System.out.println("I pick up the letter and look over the exterior it's in. The letter is poking ");
                System.out.println("out of an envelope it was tucked in, and the envelope seems to have a little ");
                System.out.println("bit of dirt and dust on it. It’s addressed to me, but I don’t recall receiving ");
                System.out.println("any envelopes or letters. It’s a pretty antiquated method of communication; ");
                System.out.println("nowadays we have email. I open the envelope and remove the letter from it. ");
                System.out.println("The letter reads: ");
                System.out.println("\"Hello, Mrs. Carlson. We have something important to discuss with you. After ");
                System.out.println("you complete your morning routines to the chicken coop, we ask that you please ");
                System.out.println("come see us in the Dining Room.\"");
                System.out.println("It wasn't signed at all. I put down the letter and look back at the rest of ");
                System.out.println("the nightstand.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to observe?");
                System.out.println("1. Letter    2. Flashlight    3. Bedroom");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If the input was the Flashlight dead-end scenes,
            //detail the Flashlight scene and return to the Nightstand scene afterwards
            else if(userInput.equalsIgnoreCase("Flashlight") || userInput.equals("2")){

                //Print the dialogue about the Nightstand
                System.out.println("You never know when you’re going to need to see in the dark. I’ll take this ");
                System.out.println("flashlight just in case.");
                System.out.println("You obtained the Flashlight.");
                System.out.println("I look back at the rest of the Nightstand.");

                //Update flashlight variable to reflect that the player now has the flashlight
                flashlight = true;

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to observe?");
                System.out.println("1. Letter    2. Flashlight    3. Bedroom");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If an input was given that is not an option in this room, ask for a new input again
            else{

                //Inform the user to try again
                System.out.println("Please input an option exactly as specified.");

                //Scan again for new user input
                userInput = myScan.nextLine();
                System.out.println();
            }
        }

        //Return to the Bedroom Scene
        return "Bedroom";
    }
}
