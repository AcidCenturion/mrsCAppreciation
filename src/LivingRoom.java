import java.util.Scanner;

public class LivingRoom {
    /* This class holds the information about the Living Room Scene. This class will have a method
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
    public String interactables(boolean passageUnlocked){

        //Check if this call is the first entry
        if(firstEntry){

            //change the value to false so that first entry dialogue is not called again
            firstEntry = false;

            //Print the first entry dialogue
            System.out.println("I approach the door and ready my hand on the handle. I should probably check on ");
            System.out.println("the chicken coop just in case. I open the door and walk down the hallway. I take ");
            System.out.println("a flight of stairs down and I find myself in the Living Room.");
        }

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //difference if passage unlocked
        if(passageUnlocked){

            //detail the new unlocked passage if unlocked
            System.out.println("As I return to the living room, I look around to see if anything moved. I ");
            System.out.println("noticed an opening behind the stairs.");
            System.out.println("I don’t remember that being there when I bought the house.");
            System.out.println("The opening was just about human-sized. It seemed there was another room behind ");
            System.out.println("the opening.");

            System.out.println();
            System.out.println("What would you like to observe?");
            System.out.println("1. Backyard     2. Utilities Room    3. Dining Room    4. Bedroom    5. Unlocked Passage");
        }

        //if the passage is not unlocked, print the normal details
        else{

            //Detail the room. This String is printed every time the user enters the room
            System.out.println("Directly ahead from the staircase is the Dining Room, where I keep the rabbit ");
            System.out.println("cage. To the left of the staircase, upon the wall, is the door to the Utilities ");
            System.out.println("Room. It had a lot of extra space in it so the room eventually just became a ");
            System.out.println("place where I store my extra junk. To my right, across the room, is the sliding ");
            System.out.println("glass door to the Backyard. I can see the chicken coop standing alone in the ");
            System.out.println("backyard.");

            //Ask user where they desire to go
            System.out.println();
            System.out.println("What would you like to observe?");
            System.out.println("1. Backyard    2. Utilities Room    3. Dining Room    4. Bedroom");
        }

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: None
        //Options to move to a different scene: Backyard, Utilities Room, Dining Room, Bedroom, Unlocked Passage
        while(!(userInput.equalsIgnoreCase("Backyard") || userInput.equalsIgnoreCase("Utilities Room") || userInput.equalsIgnoreCase("Dining Room") || userInput.equalsIgnoreCase("Bedroom"))){

            //If the unlocked passage was chosen, confirm that the player had unlocked the passage
            if(userInput.equalsIgnoreCase("Unlocked Passage") && passageUnlocked){
                return userInput;
            }

            //If an input was given that is not an option in this room, ask for a new input again
            //Inform the user to try again
            System.out.println("Please input an option exactly as specified.");

            //Scan again for new user input
            userInput = myScan.nextLine();
            System.out.println();
        }

        //Return the new location that the user specified
        return userInput;
    }
}
