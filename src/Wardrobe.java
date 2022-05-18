import java.util.Scanner;

public class Wardrobe {
    /* This class holds the information about the Wardrobe Scene. This class will have a method
     * detailing all the interactable objects within the room. This class will also have information
     * about items that can be found inside this scene.
     */

    //Track if the passage is unlocked
    boolean passageUnlocked = false;

    /* Create method to print details about all the interactables in a scene.
     * If the player moves location, return the new location as a string
     * Return String
     * Boolean Parameters only if an item is needed
     * Call method in Player by setting this method as the value for the location variable.
     * When the player chooses a location, return that location and move the player to that scene.
     * Scanner is Required
     */
    public String interactables(boolean hasKey){

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //Detail the room. This String is printed every time the user enters the room
        System.out.println("I look inside my wardrobe to see it full of all my familiar clothes. Vibrant colors ");
        System.out.println("from all over the spectrum fill the wardrobe. As the light from the window shines into ");
        System.out.println("the wardrobe, I see a little glint in the left-back of the wardrobe behind my blue ");
        System.out.println("jacket. I feel around for it and find a strange keyhole.");
        System.out.println();
        System.out.println("What would you like to observe?");
        System.out.println("1. Keyhole    2. Bedroom");

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Keyhole (Item opportunity)
        //Options to move to a different scene: Return to Bedroom
        while(!userInput.equals("Bedroom")){

            //If the input was the Keyhole dead-end scene,
            //check if the mysterious key was obtained
            //then detail the object depending on if the key was obtained
            if(userInput.equals("Keyhole")){

                //Detail the keyhole
                System.out.println("I take a closer look at the key hole. It has a golden trim around a strangely ");
                System.out.println("sized hole. It looks designed to prevent break-ins with the use of normal, ");
                System.out.println("average lock picking tools and sets.");

                //if the player does have the key yet
                if(hasKey){

                    //inform user that they unlocked the passage
                    System.out.println("I feel around the keyhole until my mysterious key slides into the keyhole's");
                    System.out.println("oddly shaped slot. A perfect fit. As I turn the key, the wardrobe makes a ");
                    System.out.println("creaking sound. It sounds like the grinding of gears. I have the feeling ");
                    System.out.println("something has been opened.");

                    //then unlock the passage
                    passageUnlocked = true;
                }

                //if the user does not have the key yet
                else{

                    //inform user they will need a key
                    System.out.println("Looks like I’ll need some kind of key to open this.");
                }

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to observe?");
                System.out.println("1. Keyhole    2. Bedroom");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If an input was given that is not an option in this scene, ask for a new input again
            else{

                //Inform the user to try again
                System.out.println("Please input an option exactly as specified");

                //Scan again for new user input
                userInput = myScan.nextLine();
                System.out.println();
            }
        }

        //Return to the Bedroom
        return "Bedroom";
    }
}
