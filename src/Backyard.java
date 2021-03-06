import java.util.Scanner;

public class Backyard {
    /* This class holds the information about the Backyard Scene. This class will have a method
     * detailing all the interactable objects within the room. This class will also have information
     * about items that can be found inside this scene.
     */

    //Variable that knows if it is the first time a player enters a room
    //change the variable to false once the player has entered the room
    boolean firstEntry = true;
    boolean chickenInteraction = false;

    /* Create method to print details about all the interactables in a scene.
     * If the player moves location, return the new location as a string
     * Return String
     * Boolean Parameters only if an item is needed
     * Call method in Player by setting this method as the value for the location variable.
     * When the player chooses a location, return that location and move the player to that scene.
     * Scanner is Required
     */
    public String interactables(boolean rabbitContact, boolean egg3, boolean egg4){

        //Check if this call is the first entry
        if(firstEntry){

            //change the value to false so that first entry dialogue is not called again
            firstEntry = false;

            //Print the first entry dialogue
            System.out.println("I walk into the Backyard and approach the coop. Fresh eggs make for the best ");
            System.out.println("breakfast. I hear the familiar clucking as I approach. It could be my imagination, ");
            System.out.println("but I feel like I hear something else along with the clucking… like English words ");
            System.out.println("or some other intellectual communication. When I arrive, a chicken walked right up ");
            System.out.println("to the door of the coop, with a navy-blue army general cap. Who gave this chicken ");
            System.out.println("a military status!?");
            System.out.println("\"You! Where’s your salute? I am Capt Cluck of the Chicken militia’s 1st platoon!\"");
            System.out.println("The chicken...talked. I'm going insane. THE CHICKEN. CAN TALK. On second thought, ");
            System.out.println("I don’t need the eggs. I turn to start walking back to the house.");
            System.out.println("\"Woah, wait wait wait where do you think you’re heading? I haven’t even given you ");
            System.out.println("orders yet. The Chicken militia needs help; specifically help from the capable ");
            System.out.println("hands of a human.\"");
            System.out.println();
        }

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //Has the player received the missions from the rabbits?
        if(rabbitContact){

            //Detail the room. This String is printed every time the user enters the room
            System.out.println("\"Them stupid rabbits that you house in the Dining Room be taking all our eggs! ");
            System.out.println("And we want them back. I know of two targets that have our eggs. Bun Bun is a ");
            System.out.println("recluse. She’s probably still in the rabbit cage. But shes ditzy too. It ");
            System.out.println("shouldn’t be too hard to get the egg from her. Demonminator, on the other hand, ");
            System.out.println("is a bit more difficult. He likes fighting. He’s a little on the narcissistic ");
            System.out.println("side, and likes to be in control. He likes the Light Switch so that he gets to choose ");
            System.out.println("when the lights are on and off. You can find him there.\"");
            System.out.println("The chicken coop appears to be empty apart from Capt Cluck. It seems that if I ");
            System.out.println("want to have eggs for breakfast, I’ll just have to go along with it.");
            System.out.println();
            System.out.println("What would you like to observe?");
            System.out.println("1. Chicken Coop    2. Living Room    3. Garden    4. Fence Gate");
        }

        //if the player has not heard from czar hops yet
        else{

            //inform user
            System.out.println("\"Them stupid rabbits that you house in the Dining Room be taking all our eggs! ");
            System.out.println("And we want them back. I know of two targets that have our eggs. Bun Bun is a ");
            System.out.println("recluse. She’s probably still in the rabbit cage. But shes ditzy too. It ");
            System.out.println("shouldn’t be too hard to get the egg from her. Demonminator, on the other hand, ");
            System.out.println("is a little more difficult. He likes fighting. He’s a little on the narcissistic ");
            System.out.println("side, likes to be in control. He likes the light switch so that he gets to choose ");
            System.out.println("when the lights are on and off. You can find him there.\"");
            System.out.println("\nThe chicken coop appears to be empty apart from Capt Cluck. It seems that if I ");
            System.out.println("want to have eggs for breakfast, I’ll just have to go along with it.");
            System.out.println();
            System.out.println("What would you like to observe?");
            System.out.println("1. Chicken Coop    2. Living Room");
        }

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //inform dining room that instructions have been received
        chickenInteraction = true;

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Chicken Coop
        //Options to move to a different scene: Garden, Fence Gate, Living Room
        while(!(userInput.equalsIgnoreCase("Living Room") || userInput.equals("2"))){

            //If the player obtained the two eggs for the chicken ending
            //detail the ending and return the ChickenEnd
            if((userInput.equalsIgnoreCase("Chicken Coop") || userInput.equals("1")) && egg3 && egg4){

                //detail ending
                System.out.println("Chicken Ending details...");

                //return the ending
                return "ChickenEnd";
            }

            //if player communicates with the coop w/o the eggs
            else if((userInput.equalsIgnoreCase("Chicken Coop") || userInput.equals("1"))){

                //detail chicken coop
                System.out.println("Just an average chicken coop...an average chicken coop that now apparently ");
                System.out.println("acts as the base of operations for a chicken militia.");
                System.out.println();

                //offer different options based on if the rabbits gave instructions
                if(rabbitContact){
                    System.out.println("What would you like to observe?");
                    System.out.println("1. Chicken Coop    2. Living Room    3. Garden    4. Fence Gate");

                    //Receive the user's input
                    userInput = myScan.nextLine();
                    System.out.println();
                }
                else{
                    System.out.println("What would you like to observe?");
                    System.out.println("1. Chicken Coop    2. Living Room");

                    //Receive the user's input
                    userInput = myScan.nextLine();
                    System.out.println();
                }
            }

            //if the player chooses the egg quests, ensure that they have met the rabbits
            else if((userInput.equalsIgnoreCase("Garden")||userInput.equals("3")) && rabbitContact){

                //return the correct location
                return "Garden";
            }

            //ensure the rabbit contact
            else if((userInput.equalsIgnoreCase("Fence Gate")||userInput.equals("4")) && rabbitContact){

                //return the correct location
                return "Fence Gate";
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
        return "Living Room";
    }
}
