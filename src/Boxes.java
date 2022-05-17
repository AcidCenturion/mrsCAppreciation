import java.util.Scanner;

public class Boxes {
    /* This class holds the information about the Boxes Scene. This class will have a method
     * detailing all the interactable objects within the room. This class will also have information
     * about items that can be found inside this scene.
     */

    //Boolean variables that store if the player has obtained the item
    boolean key = false;

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
        System.out.println("Boxes details...");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Small Blue Box    2. Larger Red Box    3. Super Small Green Box    4. Return to Utilities Room");

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Small Blue Box, Larger Red Box, Super Small Green Box
        //Options to move to a different scene: Return to Utilities Room
        while(!userInput.equals("Return to Utilities Room")){

            //If the input was the Small Blue Box dead-end scenes,
            //detail the Small Blue Box and return to the Boxes scene afterwards
            if(userInput.equals("Small Blue Box")){

                //Print the dialogue about the Small Blue Box
                System.out.println("Small Blue Box details... You turn back to the rest of the boxes.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println("1. Small Blue Box    2. Larger Red Box    3. Super Small Green Box    4. Return to Utilities Room");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If the input was the Larger Red Box dead-end scenes,
            //detail the Larger Red Box scene and return to the Boxes scene afterwards
            else if(userInput.equals("Larger Red Box")){

                //Print the dialogue about the Larger Red Box
                System.out.println("Larger Red Box details... You turn back to the rest of the boxes.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println("1. Small Blue Box    2. Larger Red Box    3. Super Small Green Box    4. Return to Utilities Room");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If the input was the Super Small Green Box dead-end scenes,
            //detail the Larger Red Box scene and return to the Boxes scene afterwards
            else if(userInput.equals("Super Small Green Box")){

                //Print the dialogue about the Super Small Green Box
                System.out.println("Super Small Green Box details...");

                //update key information now that the player has acquired the key
                key = true;

                //inform user that the item was obtained
                System.out.println("You obtained the Key");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println("1. Small Blue Box    2. Larger Red Box    3. Super Small Green Box    4. Return to Utilities Room");
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

        //Go to where player specifies
        return "Utilities Room";
    }
}
