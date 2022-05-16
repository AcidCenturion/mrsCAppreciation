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
        System.out.println("Bedroom details...");
        System.out.println("Where would you like to go?");
        System.out.println("1. Bed    2. Window    3. Nightstand    4. Wardrobe    5. Living Room");

        //Receive the user's input
        String userInput = myScan.nextLine();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Bed, Window
        //Options to move to a different scene: Living Room, Nightstand, Wardrobe (Key Item Required)
        while(!(userInput.equals("Living Room") || userInput.equals("Nightstand") || userInput.equals("Wardrobe"))){

            //If the input was the Bed dead-end scenes,
            //detail the Bed scene and return to the Bedroom scene afterwards
            if(userInput.equals("Bed")){

                //Print the dialogue about the Bed
                System.out.println("Bed details... You return to face back towards the Bedroom");

                //Determine where the player wants to go next
                System.out.println("1. Bed    2. Window    3. Nightstand    4. Wardrobe    5. Living Room");
                userInput = myScan.nextLine();
            }

            //If the input was the Window dead-end scenes,
            //detail the Nightstand scene and return to the Bedroom scene afterwards
            else if(userInput.equals("Window")){

                //Print the dialogue about the Nightstand
                System.out.println("Window Details... You return to face back towards the Bedroom");

                //Determine where the player wants to go next
                System.out.println("1. Bed    2. Window    3. Nightstand    4. Wardrobe    5. Living Room");
                userInput = myScan.nextLine();
            }

            //If an input was given that is not an option in this room, ask for a new input again
            else{

                //Inform the user to try again
                System.out.println("Please input an option exactly as specified");

                //Scan again for new user input
                userInput = myScan.nextLine();
            }
        }

        //Return the new location that the user specified
        return userInput;
    }
}
