import java.util.Scanner;

public class Nightstand {
    /* This class holds the information about the Nightstand Scene. This class will have a method
     * detailing all the interactable objects within the room. This class will also have information
     * about items that can be found inside this scene.
     */

    //Boolean variables that store if the player has obtained the item
    boolean flashlight = false;

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
        System.out.println("Nightstand details...");
        System.out.println();
        System.out.println("Where would you like to go?");
        System.out.println("1. Letter    2. Flashlight    3. Return to Bedroom");

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Letter, Flashlight
        //Options to move to a different scene: Return to Bedroom
        while(!userInput.equals("Return to Bedroom")){

            //If the input was the Letter dead-end scenes,
            //detail the Letter and return to the Nightstand scene afterwards
            if(userInput.equals("Letter")){

                //Print the dialogue about the Letter
                System.out.println("Letter details... You put down the letter and look back at the rest of the Nightstand.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println("1. Letter    2. Flashlight    3. Return to Bedroom");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If the input was the Flashlight dead-end scenes,
            //detail the Flashlight scene and return to the Nightstand scene afterwards
            else if(userInput.equals("Flashlight")){

                //Print the dialogue about the Nightstand
                System.out.println("Flashlight details...");
                System.out.println("You obtained the Flashlight.");
                System.out.println("You look back at the rest of the Nightstand.");

                //Update flashlight variable to reflect that the player now has the flashlight
                flashlight = true;

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println("1. Letter    2. Flashlight    3. Return to Bedroom");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If an input was given that is not an option in this room, ask for a new input again
            else{

                //Inform the user to try again
                System.out.println("Please input an option exactly as specified");

                //Scan again for new user input
                userInput = myScan.nextLine();
                System.out.println();
            }
        }

        //Return to the Bedroom Scene
        return "Bedroom";
    }
}
