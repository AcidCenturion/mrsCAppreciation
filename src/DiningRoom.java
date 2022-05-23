import java.util.Scanner;

public class DiningRoom {
    /* This class holds the information about the Dining Room Scene. This class will have a method
     * detailing all the interactable objects within the room. This class will also have information
     * about items that can be found inside this scene.
     */

    //Variable that knows if it is the first time a player enters a room
    //change the variable to false once the player has entered the room
    boolean firstEntry = true;
    boolean rabbitInteraction = false;

    /* Create method to print details about all the interactables in a scene.
     * If the player moves location, return the new location as a string
     * Return String
     * Boolean Parameters only if an item is needed
     * Call method in Player by setting this method as the value for the location variable.
     * When the player chooses a location, return that location and move the player to that scene.
     * Scanner is Required
     */
    public String interactables(boolean chickenContact, boolean egg1, boolean egg2){

        //Check if this call is the first entry
        if(firstEntry){

            //change the value to false so that first entry dialogue is not called again
            firstEntry = false;

            //Print the first entry dialogue
            System.out.println("I head to the dining room to check on the rabbits. Rabbit stew sounds pretty ");
            System.out.println("good for dinner. I grab the rabbit feed from the counter.");
            System.out.println("\"Pssst! Hey you..yeah you, Mrs. C. Did you get my letter?\"");
            System.out.println("I quickly whip around to look for where the voice came from. The only other ");
            System.out.println("living creature in this room is the rabbits in the...open rabbit cage. Uh oh");
            System.out.println("\"I’m right here, on the table\"");
            System.out.println("One of the rabbits hopped on the dining room table. This one is definitely going on ");
            System.out.println("the chopping block tonight.");
            System.out.println("\"Have you ever wanted to be something that the world told you that you can’t ");
            System.out.println("be? Like maybe the next billionaire...but instead you're stuck teaching at CCA?\"");
            System.out.println("This felt like a personal attack");
            System.out.println();
        }

        //Create the Scanner object
        Scanner myScan = new Scanner(System.in);

        //inform backyard that instructions have been received
        rabbitInteraction = true;

        //Has the player received the missions from the chickens?
        if(chickenContact){

            //Detail the room. This String is printed every time the user enters the room
            System.out.println("\"I’m Czar Hops, and we rabbits want to bring festive cheer to others every year. ");
            System.out.println("So why can’t we be easter rabbits? Easter bunnies exist, and bunnies and rabbits ");
            System.out.println("really arent that far apart. So, what do you say to helping us accomplish our ");
            System.out.println("dream, hmm? I need you to get two eggs from those annoying chickens. They’re ");
            System.out.println("outside in the [Backyard] somewhere. That Zoplex fellow is probably in the garden, ");
            System.out.println("he has some weird obsession with hoses. Chuck is probably banging his head into ");
            System.out.println("the Fence Gate. The dummy doesn't know how to use a door latch.\"");
            System.out.println();
            System.out.println("What would you like to observe?");
            System.out.println("1. Table    2. Living Room    3. Lightswitch    4. Rabbit Cage");
        }

        //if the player has not heard from capt cluck yet
        else{

            //inform user
            System.out.println("\"I’m Czar Hops, and we rabbits want to bring festive cheer to others every year. ");
            System.out.println("So why can’t we be easter rabbits? Easter bunnies exist, and bunnies and rabbits ");
            System.out.println("really arent that far apart. So, what do you say to helping us accomplish our ");
            System.out.println("dream, hmm? I need you to get two eggs from those annoying chickens. They’re ");
            System.out.println("outside in the [Backyard] somewhere. That Zoplex fellow is probably in the garden, ");
            System.out.println("he has some weird obsession with hoses. Chuck is probably banging his head into ");
            System.out.println("the [Fence Gate]. The dummy doesn't know how to use a door latch.\"");
            System.out.println();
            System.out.println("What would you like to observe?");
            System.out.println("1. Table    2. Living Room");
        }

        //Receive the user's input
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Table
        //Options to move to a different scene: Windowsill, Rabbit Cage, Living Room
        while(!(userInput.equalsIgnoreCase("Living Room") || userInput.equals("2"))){

            //If the player obtained the two eggs for the Rabbit ending
            //detail the ending and return the RabbitEnd
            if((userInput.equalsIgnoreCase("Table")||userInput.equals("1")) && egg1 && egg2){

                //detail ending
                System.out.println("Rabbit Ending details...");

                //return the ending
                return "RabbitEnd";
            }

            //if player communicates with the czar hops w/o the eggs
            else if(userInput.equalsIgnoreCase("Table")||userInput.equals("1")){

                //detail the table and czar hops' instructions
                System.out.println("\"What are you waiting for? Hop to it already.\"");
                System.out.println();

                //offer different options based on if the chickens gave instructions
                if(chickenContact){
                    System.out.println("What would you like to observe?");
                    System.out.println("1. Table    2. Living Room    3. Lightswitch    4. Rabbit Cage");

                    //Receive the user's input
                    userInput = myScan.nextLine();
                    System.out.println();
                }
                else{
                    System.out.println("What would you like to observe?");
                    System.out.println("1. Table    2. Living Room");

                    //Receive the user's input
                    userInput = myScan.nextLine();
                    System.out.println();
                }
            }

            //if the player chooses the egg quests, ensure that they have met the chickens
            else if((userInput.equalsIgnoreCase("Lightswitch")||userInput.equals("3")) && chickenContact){

                //return the correct location
                return "Lightswitch";
            }

            //ensure the chicken contact
            else if((userInput.equalsIgnoreCase("Rabbit Cage")||userInput.equals("4")) && chickenContact){

                //return the correct location
                return "Rabbit Cage";
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
