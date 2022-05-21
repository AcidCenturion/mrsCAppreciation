import java.util.Scanner;

public class UtilitiesRoom {
    /* This class holds the information about the Utilities Room Scene. This class will have a method
     * detailing all the interactable objects within the room. This class will also have information
     * about items that can be found inside this scene.
     */

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
        System.out.println("I enter the utilities room. Its just as messy as I remember it to be. The washing machine ");
        System.out.println("and dryer are still accessible, but there are boxes stacked all over the place.");
        System.out.println();
        System.out.println("What would you like to observe?");
        System.out.println("1. Washing Machine    2. Dryer    3. Inspect Boxes    4. Living Room");

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Washing Machine, Dryer
        //Options to move to a different scene: Inspect Boxes, Return to Living Room
        while(!(userInput.equals("Living Room") || userInput.equals("Inspect Boxes"))){

            //If the input was the Washing Machine dead-end scenes,
            //detail the Washing Machine and return to the Utilities Room scene afterwards
            if(userInput.equals("Washing Machine")){

                //Print the dialogue about the Washing Machine
                System.out.println("Just the average everyday washing machine. It came in a pair with the dryer, ");
                System.out.println("designed so that both doors can be opened, and clothes can be easily moved ");
                System.out.println("between. But the mechanics who installed them placed them in the opposite ");
                System.out.println("spots, causing the doors to collide when they are both opened.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to observe?");
                System.out.println("1. Washing Machine    2. Dryer    3. Inspect Boxes    4. Living Room");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If the input was the Dryer dead-end scenes,
            //detail the Dryer scene and return to the Utilities Room scene afterwards
            else if(userInput.equals("Dryer")){

                //Print the dialogue about the Dryer
                System.out.println("I take a moment to relish in the greatness that is the dryer. I love wearing ");
                System.out.println("clothes straight from the dryer. Surely, I’m not the only one that likes the ");
                System.out.println("warm, fuzzy feeling of fresh clothes.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to observe?");
                System.out.println("1. Washing Machine    2. Dryer    3. Inspect Boxes    4. Living Room");
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

        //Go to where player specifies
        return userInput;
    }
}
