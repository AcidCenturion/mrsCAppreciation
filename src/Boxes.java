import java.util.Scanner;

public class Boxes {
    /* This class holds the information about the Boxes Scene. This class will have a method
     * detailing all the interactable objects within the room. This class will also have information
     * about items that can be found inside this scene.
     */

    //Boolean variables that store if the player has obtained the item
    private boolean key = false;

    //get key value
    public boolean getKey(){
        return key;
    }

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
        System.out.println("For some reason, I felt like taking a closer look at the junk I left around in ");
        System.out.println("this room. There are three main boxes that caught my attention. They look as if ");
        System.out.println("they had been sifted through. There was a small blue box pushed a little to the ");
        System.out.println("left, a larger red box on the right, and a very small green box further back that ");
        System.out.println("I don’t remember ever adding to the pile.");
        System.out.println();
        System.out.println("What would you like to observe?");
        System.out.println("1. Blue Box    2. Red Box    3. Green Box    4. Utilities Room");

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Small Blue Box, Larger Red Box, Super Small Green Box
        //Options to move to a different scene: Return to Utilities Room
        while(!(userInput.equalsIgnoreCase("Utilities Room") || userInput.equals("4"))){

            //If the input was the Small Blue Box dead-end scenes,
            //detail the Small Blue Box and return to the Boxes scene afterwards
            if(userInput.equalsIgnoreCase("Blue Box") || userInput.equals("1")){

                //Print the dialogue about the Small Blue Box
                System.out.println("I reach for the blue box. It's a little light and definitely doesn't weigh the ");
                System.out.println("same as it looks it should. The box wasn't well sealed so I managed to open ");
                System.out.println("it up with my hands. Inside was a soft, blue, penguin plush. It was round ");
                System.out.println("in shape and its head wasn't defined separate from its body. It had cute, ");
                System.out.println("beady eyes and an upside-down yellow triangle with rounded corners for a ");
                System.out.println("beak. I didn't know I had such an adorable toy in my house, I wonder why I ");
                System.out.println("left it in the utilities room. I'll name it Onigiri.");

                //obtain penguin plush
                System.out.println("You obtained Onigiri (Penguin Plush).");
                System.out.println("It doesn't do anything. Its just really cute.");

                //Determine where the player wants to go
                System.out.println();
                System.out.println("What would you like to observe?");
                System.out.println("1. Blue Box    2. Red Box    3. Green Box    4. Utilities Room");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If the input was the Larger Red Box dead-end scenes,
            //detail the Larger Red Box scene and return to the Boxes scene afterwards
            else if(userInput.equalsIgnoreCase("Red Box") || userInput.equals("2")){

                //Print the dialogue about the Larger Red Box
                System.out.println("I tried carrying the red box out of the junk pile but it was too heavy. I ");
                System.out.println("climb through the clutter to get a peak inside the box. Instantly, a wave a ");
                System.out.println("regret washed over me. It was my shameful instant noodles box. Filled to the ");
                System.out.println("brim with different brands and flavors of instant noodles, this box ");
                System.out.println("encapsulates all my past regrets. I have long since quit the ways of the ");
                System.out.println("instant noodles, but they still fill me with shame and regret when I see ");
                System.out.println("them. I force the box further back into the pile of boxes.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to observe?");
                System.out.println("1. Blue Box    2. Red Box    3. Green Box    4. Utilities Room");
                userInput = myScan.nextLine();
                System.out.println();
            }

            //If the input was the Super Small Green Box dead-end scenes,
            //detail the Larger Red Box scene and return to the Boxes scene afterwards
            else if(userInput.equalsIgnoreCase("Green Box") || userInput.equals("3")){

                //Print the dialogue about the Super Small Green Box
                System.out.println("Sitting at the edge of the junk pile, practically begging to be picked up, ");
                System.out.println("lay the small green box. I reach forward and grab the box. The green box was ");
                System.out.println("about the size of an envelope, with a little more depth. Its nicely wrapped ");
                System.out.println("and packaged. Was this a gift from someone? I open up the present to ");
                System.out.println("discover the box housed a lone key. ");
                System.out.println("\"Huh, that’s strange. I don’t quite remember leaving this here. \"");
                System.out.println("I don’t recognize the design or pattern of the key either. I take it with ");
                System.out.println("me just in case.");

                //update key information now that the player has acquired the key
                key = true;

                //inform user that the item was obtained
                System.out.println("You obtained the Key.");

                //Determine where the player wants to go next
                System.out.println();
                System.out.println("What would you like to observe?");
                System.out.println("1. Blue Box    2. Red Box    3. Green Box    4. Utilities Room");
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
        return "Utilities Room";
    }
}
