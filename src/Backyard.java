import java.util.Scanner;

public class Backyard {
    /* This class holds the information about the Utilities Basement Scene. This class will have a method
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
    public String interactables(boolean rabbitContact, boolean egg3, boolean egg4){

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //Has the player recieved the misssions from the rabbits?
        if(rabbitContact){

            //Detail the room. This String is printed every time the user enters the room
            System.out.println("Backyard details...");
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Garden    2. Fence Gate    3. Chicken Coop    4. Living Room");
        }

        //if the player has not heard from czar hops yet
        else{

            //inform user
            System.out.println("Backyard details...");
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Chicken Coop    2. Living Room");
        }

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Chicken Coop
        //Options to move to a different scene: Garden, Fence Gate, Living Room
        while(!(userInput.equals("Living Room"))){

            //If the player obtained the two eggs for the chicken ending
            //detail the ending and return the ChickenEnd
            if(userInput.equals("Chicken Coop") && egg3 && egg4){

                //detail ending
                System.out.println("Chicken Ending details...");

                //return the ending
                return "ChickenEnd";
            }

            //if player communicates with the coop w/o the eggs
            else if(userInput.equals("Chicken Coop")){

                //detail chicken coop
                System.out.println("Chicken Coop details...");
                System.out.println();

                //offer different options based on if the rabbits gave instructions
                if(rabbitContact){
                    System.out.println("What would you like to do?");
                    System.out.println("1. Garden    2. Fence Gate    3. Chicken Coop    4. Living Room");

                    //Receive the user's input
                    userInput = myScan.nextLine();
                    System.out.println();
                }
                else{
                    System.out.println("What would you like to do?");
                    System.out.println("1. Chicken Coop    2. Living Room");

                    //Receive the user's input
                    userInput = myScan.nextLine();
                    System.out.println();
                }
            }

            //if the player chooses the egg quests, ensure that they have met the rabbits
            else if(userInput.equals("Garden") && rabbitContact){

                //return the correct location
                return "Garden";
            }

            //ensure the rabbit contact
            else if(userInput.equals("Fence Gate") && rabbitContact){

                //return the correct location
                return "Fence Gate";
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
