import java.util.Scanner;

public class DiningRoom {
    /* This class holds the information about the Dining Room Scene. This class will have a method
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
    public String interactables(boolean chickenContact, boolean egg1, boolean egg2){

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //Has the player recieved the misssions from the chickens?
        if(chickenContact){

            //Detail the room. This String is printed every time the user enters the room
            System.out.println("Dining Room details...");
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Windowsill    2. Rabbit Cage    3. Table    4. Living Room");
        }

        //if the player has not heard from capt cluck yet
        else{

            //inform user
            System.out.println("Dining room details...");
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Table    2. Living Room");
        }

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Table
        //Options to move to a different scene: Windowsill, Rabbit Cage, Living Room
        while(!(userInput.equals("Living Room"))){

            //If the player obtained the two eggs for the Rabbit ending
            //detail the ending and return the RabbitEnd
            if(userInput.equals("Table") && egg1 && egg2){

                //detail ending
                System.out.println("Rabbit Ending details...");

                //return the ending
                return "RabbitEnd";
            }

            //if player communicates with the czar hops w/o the eggs
            else if(userInput.equals("Table")){

                //detail the table and czar hops' instructions
                System.out.println("Czar Hops instructions...");
                System.out.println();

                //offer different options based on if the rabbits gave instructions
                if(chickenContact){
                    System.out.println("What would you like to do?");
                    System.out.println("1. Windowsill    2. Rabbit Cage    3. Table    4. Living Room");

                    //Receive the user's input
                    userInput = myScan.nextLine();
                    System.out.println();
                }
                else{
                    System.out.println("What would you like to do?");
                    System.out.println("1. Table    2. Living Room");

                    //Receive the user's input
                    userInput = myScan.nextLine();
                    System.out.println();
                }
            }

            //if the player chooses the egg quests, ensure that they have met the rabbits
            else if(userInput.equals("Windowsill") && chickenContact){

                //return the correct location
                return "Windowsill";
            }

            //ensure the rabbit contact
            else if(userInput.equals("Rabbit Cage") && chickenContact){

                //return the correct location
                return "Rabbit Cage";
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
