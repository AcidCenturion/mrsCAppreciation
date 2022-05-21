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
            System.out.println("I wake up in a cold sweat.");
            System.out.println("\"That was just a dream... everything is normal. No big chickens or rabbits,\" ");
            System.out.println("I tell myself.");
            System.out.println();
        }

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //Detail the room. This String is printed every time the user enters the room
        System.out.println("I double check the room just to make sure I'm not still in a dream like it's ");
        System.out.println("Inception or something. Everything is where I remember them to be. My queen-sized ");
        System.out.println("bed sits in the corner of the room, just under the window to the right. To my left ");
        System.out.println("is my nightstand where I keep emergency items on. Further past my nightstand ");
        System.out.println("across the room is the wardrobe. In the opposite corner of the room is the door ");
        System.out.println("to the hallway and stairs that lead to the living room.");
        System.out.println();
        System.out.println("What would you like to observe?");
        System.out.println("1. Bed    2. Window    3. Nightstand    4. Wardrobe    5. Living Room");

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Bed, Window
        //Options to move to a different scene: Living Room, Nightstand, Wardrobe (Key Item Required)
        while(!(userInput.equals("Living Room") || userInput.equals("Nightstand") || userInput.equals("Wardrobe"))){

            //If the input was the Bed dead-end scenes,
            //detail the Bed scene and return to the Bedroom scene afterwards
            if(userInput.equals("Bed")){

                //Print the dialogue about the Bed
                System.out.println("My bed is nice and fluffy. It's warm enough to get me through the wintry ");
                System.out.println("nights out here in Mooced. The blankets are in a bit of a mess due to my ");
                System.out.println("abrupt waking from the nightmare. There’s nothing interesting here, so I ");
                System.out.println("turn back to the room.");
                System.out.println();

                //Determine where the player wants to go next
                System.out.println("What would you like to observe?");
                System.out.println("1. Bed    2. Window    3. Nightstand    4. Wardrobe    5. Living Room");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If the input was the Window dead-end scenes,
            //detail the Nightstand scene and return to the Bedroom scene afterwards
            else if(userInput.equals("Window")){

                //Print the dialogue about the Nightstand
                System.out.println("I look outside my bedroom window. It’s a bit cloudy from the morning dew, ");
                System.out.println("but I can still make out the cows in the field. There’s nothing interesting ");
                System.out.println("here, so I turn back to the room.");
                System.out.println();

                //Determine where the player wants to go next
                System.out.println("What would you like to observe?");
                System.out.println("1. Bed    2. Window    3. Nightstand    4. Wardrobe    5. Living Room");
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

        //Return the new location that the user specified
        return userInput;
    }
}
