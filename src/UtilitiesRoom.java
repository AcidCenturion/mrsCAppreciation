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
        System.out.println("Utility Room details...");
        System.out.println();
        System.out.println("What would you like to do?");
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
                System.out.println("Washing Machine details... You turn back to the Utilities Room.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println("1. Washing Machine    2. Dryer    3. Inspect Boxes    4. Living Room");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If the input was the Dryer dead-end scenes,
            //detail the Dryer scene and return to the Utilities Room scene afterwards
            else if(userInput.equals("Dryer")){

                //Print the dialogue about the Dryer
                System.out.println("Dryer details... You turn back to the Utilities Room.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println("1. Washing Machine    2. Dryer    3. Inspect Boxes    4. Living Room");
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
        return userInput;
    }
}
