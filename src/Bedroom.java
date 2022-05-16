import java.util.Scanner;

public class Bedroom {
    /* This class holds the information about the Bedroom Scene. This class will have a method
     * detailing all the interactable objects within the room. This class will also have information
     * about items that can be found inside this scene.
     */

    //Variable that knows if it is the first time a player enters a room
    //change the variable to false once the player has entered the room
    boolean firstEntry = true;

    /* Create method to print details about all the interactables in a scene.
     * If the player moves location, return the new location as a string
     * Return String
     * Boolean Parameters only if an item is needed
     * When the method is called, check the firstEntree boolean to determine if story conjunction is to be printed.
     * Call method in Player by setting this method as the value for the location variable.
     * When the player chooses a location, return that location and move the player to that scene.
     * Scanner is Required
     */
    public String interactables(){

        //Check if this call is the first entry
        if(firstEntry){

            //change the value to false so that first entry dialogue is not called again
            firstEntry = false;

            //Print the first entry dialogue
            System.out.println("First Bedroom Entry");
        }

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //Detail the room. This String is printed every time the user enters the room
        System.out.println("Explain where to go from this scene");
        System.out.println("List scenes that can be accessed from current scene");

        //Receive the user's input
        String userInput = myScan.nextLine();

        //Check that the user inputted an acceptable input
        //While they have not, have the user give another input
        while(!(userInput.equals("roomOption1") || userInput.equals("roomOption2"))){

            //Inform the user to try again
            System.out.println("Please input an option exactly as specified");

            //Scan again for new user input
            userInput = myScan.nextLine();
        }

        //Return the new location that the user specified
        return userInput;
    }
}
