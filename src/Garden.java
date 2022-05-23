import java.util.Scanner;

public class Garden {

    //Scanner object
    Scanner myScan = new Scanner(System.in);
    private String userInput;

    /* Zoplex's Egg Quest 1 : Quiz*/
    private boolean egg = false;

    //get the egg
    public boolean getEgg(){
        return egg;
    }

    private String newLocation(boolean egg3, boolean egg4){

        System.out.println("What would you like to observe?");
        System.out.println("1. Garden    2. Fence Gate    3. Chicken Coop    4. Living Room");

        //scan for user's answer
        String userInput = myScan.nextLine();
        System.out.println();

        //Check that the user inputted an acceptable input to move to a different scene
        //If it was not, ask for a new input until a proper input is given
        //Dead-end Scenes: Chicken Coop
        //Options to move to a different scene: Garden, Fence Gate, Living Room
        while(!(userInput.equalsIgnoreCase("Living Room") || userInput.equalsIgnoreCase("Garden") || userInput.equalsIgnoreCase("Fence Gate"))){

            //If the player obtained the two eggs for the chicken ending
            //detail the ending and return the ChickenEnd
            if(userInput.equalsIgnoreCase("Chicken Coop") && egg3 && egg4){

                //detail ending
                System.out.println("Chicken Ending details...");

                //return the ending
                return "ChickenEnd";
            }

            //if player communicates with the coop w/o the eggs
            else if(userInput.equalsIgnoreCase("Chicken Coop")){

                //detail chicken coop
                System.out.println("Just an average chicken coop...an average chicken coop that now apparently ");
                System.out.println("acts as the base of operations for a chicken militia.");
                System.out.println();

                //offer different options based on if the rabbits gave instructions
                System.out.println("What would you like to observe?");
                System.out.println("1. Garden    2. Fence Gate    3. Chicken Coop    4. Living Room");

                //Receive the user's input
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
        return userInput;
    }

    /* Create method to run the quiz
     * no return, edit egg value
     * no param
     */
    public String eggQuest(boolean egg3, boolean egg4){

        //Introduction
        System.out.println("I enter the garden and look for Zoplex. Just like Czar Hops said, I find a chicken ");
        System.out.println("playing around with a hose. I approach cautiously, being careful not to get sprayed ");
        System.out.println("by the hose.");
        System.out.println("\"Why good day to thee thou lowly commoner! I possessth thine egg thou lookst for, and ");
        System.out.println("if thou wouldst like to ownth it thou must passth minest most strenuous of quizzes!\"");
        System.out.println("\033[3mWhat is he even saying???\033[0m");
        System.out.println();

        //ask first question
        System.out.println("\"I grace thee with thine first question:");
        System.out.println("Doest ‘Thing’ soundeth liketh a goodst name for a class?\"");
        System.out.println("1. Yes    2. No");

        //scan for user's answer
        String userInput = myScan.nextLine();
        System.out.println();

        //check for correct answer
        if(!(userInput.equalsIgnoreCase("no")||userInput.equals("2"))){

            //inform user they were incorrect
            System.out.println("\"haHA!! I knewst such a lowly lifeform as thyself couldst not possibly passetheth ");
            System.out.println("the heights of intelligence such as I! But feareth not, for I amst most gracious, ");
            System.out.println("and shallth gievth thou as many chances as thou wishest to proveth thine ");
            System.out.println("inferiority to I.\"");
            System.out.println("Test failed. Returning to Backyard...");
            System.out.println();

            //if they gave the wrong answer
            return newLocation(egg3, egg4);
        }

        //continue the quiz
        System.out.println("\"Of how highth importance isth the slumber of the night?\"");
        System.out.println("1. Not Important    2. Important    3. Very Important");
        userInput = myScan.nextLine();
        System.out.println();

        //check for correct answer
        if(!(userInput.equalsIgnoreCase("very important")||userInput.equals("3"))){

            //inform user they were incorrect
            System.out.println("\"haHA!! I knewst such a lowly lifeform as thyself couldst not possibly passetheth ");
            System.out.println("the heights of intelligence such as I! But feareth not, for I amst most gracious, ");
            System.out.println("and shallth gievth thou as many chances as thou wishest to proveth thine ");
            System.out.println("inferiority to I.\"");
            System.out.println("Test failed. Returning to Backyard...");
            System.out.println();

            //if they gave the wrong answer
            return newLocation(egg3, egg4);
        }

        //continue the quiz
        System.out.println("\"If thine chicken tryst to maul thee, isth that a good thingeth or a bad thingeth?\"");
        System.out.println("1. Good    2. Bad");
        userInput = myScan.nextLine();
        System.out.println();

        //check for correct answer
        if(!(userInput.equalsIgnoreCase("bad")||userInput.equals("2"))){

            //inform user they were incorrect
            System.out.println("\"haHA!! I knewst such a lowly lifeform as thyself couldst not possibly passetheth ");
            System.out.println("the heights of intelligence such as I! But feareth not, for I amst most gracious, ");
            System.out.println("and shallth gievth thou as many chances as thou wishest to proveth thine ");
            System.out.println("inferiority to I.\"");
            System.out.println("Test failed. Returning to Backyard...");
            System.out.println();

            //if they gave the wrong answer
            return newLocation(egg3, egg4);
        }

        //continue the quiz
        System.out.println("\"What shouldst one do if thoust feathered cocks tryst to maul thee?\"");
        System.out.println("1. Kill Them    2. Let Them Live   3. Timeout");
        userInput = myScan.nextLine();
        System.out.println();

        //check for correct answer
        if(!(userInput.equalsIgnoreCase("timeout")||userInput.equals("3"))){

            //inform user they were incorrect
            System.out.println("\"haHA!! I knewst such a lowly lifeform as thyself couldst not possibly passetheth ");
            System.out.println("the heights of intelligence such as I! But feareth not, for I amst most gracious, ");
            System.out.println("and shallth gievth thou as many chances as thou wishest to proveth thine ");
            System.out.println("inferiority to I.\"");
            System.out.println("Test failed. Returning to Backyard...");
            System.out.println();

            //if they gave the wrong answer
            return newLocation(egg3, egg4);
        }

        System.out.println("\"HOW CAN THIS BE?? HOWDST THOU PASSETH MINE TEST WITH SUCH EASE?! Thou must’ve ");
        System.out.println("cheated!! Whereth is thine note card with the answers thoust possess?! Looked upst ");
        System.out.println("the answers perhapseth? Or hast thou peeketh at minest code?! Welleth then… i shallth ");
        System.out.println("stayst true to minest word and bestow upon thee: an egg. Do withdst it as thou pleaseth.\"");
        System.out.println();
        System.out.println("You obtained an egg.");
        System.out.println();
        System.out.println("\033[3m... Do not bite the hand that feeds you, chicken.\033[0m");
        System.out.println();
        egg = true;

        return newLocation(egg3, egg4);

    }
}
