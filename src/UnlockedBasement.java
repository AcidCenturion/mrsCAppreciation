import java.util.Scanner;

public class UnlockedBasement {
    /* This class holds the information about the Unlocked Basement Scene. This class will have a method
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
    public String interactables(boolean light, boolean egg1, boolean egg2, boolean egg3, boolean egg4){

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Does the player have the flashlight to see in the dark basement?
        if(light){

            //Detail the room. This String is printed every time the user enters the room
            System.out.println("Unlocked Basement details...");
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Inspect Altars    2. Living Room");
        }

        //if the player does not have a light, kick them back out to living room
        else{

            //inform user
            System.out.println("Cannot see... I'll need a light first");
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Living Room");
        }

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Inspect Altars
        //Options to move to a different scene: Living Room
        while(!(userInput.equals("Living Room"))){

            //If the input was the Inspect Altars dead-end scene,
            //detail the Altars and return to the Unlocked Basement scene afterwards
            if(userInput.equals("Inspect Altars") || light){

                //Print the dialogue about the Altars
                System.out.println("Altar details...");

                //if the player has all four eggs
                if(egg1 && egg2 && egg3 && egg4){

                    //inform user that they unlocked the ending
                    System.out.println("Unlocked altars...");
                    System.out.println();

                    //return ending
                    return "TrueEnd";
                }

                //if the user does not have the eggs yet
                else{

                    //inform user they will need a key
                    System.out.println("The altars have a slight concavity on the top...");
                }

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println("1. Inspect Altars    2. Living Room");
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
