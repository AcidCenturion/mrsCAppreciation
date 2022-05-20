import java.util.Scanner;

public class Garden {
    /* Zoplex's Egg Quest 1 : Quiz*/
    boolean egg = false;

    /* Create method to run the quiz
     * no return, edit egg value
     * no param
     */
    public void eggQuest(){

        //Introduction
        System.out.println("I enter the garden and look for Zoplex. Just like Czar Hops said, I find a chicken ");
        System.out.println("playing around with a hose. I approach cautiously, being careful not to get sprayed ");
        System.out.println("by the hose.");
        System.out.println("\"Why good day to thee thou lowly commoner! I possessth thine egg thou lookst for, and ");
        System.out.println("if thou wouldst like to ownth it thou must passth minest most strenuous of quizzes!\"");
        System.out.println("\033[3mWhat is he even saying???\033[0m");
        System.out.println();

        //Scanner object
        Scanner myScan = new Scanner(System.in);

        //ask first question
        System.out.println("\"I grace thee with thine first question:");
        System.out.println("Doest ‘Thing’ soundeth liketh a goodst name for a class?\"");
        System.out.println("1. Yes    2. No");

        //scan for user's answer
        String userInput = myScan.nextLine();
        System.out.println();

        //check for correct answer
        if(!(userInput.equals("No")||userInput.equals("no")||userInput.equals("1"))){

            //inform user they were incorrect
            System.out.println("\"haHA!! I knewst such a lowly lifeform as thyself couldst not possibly passetheth ");
            System.out.println("the heights of intelligence such as I! But feareth not, for I amst most gracious, ");
            System.out.println("and shallth gievth thou as many chances as thou wishest to proveth thine ");
            System.out.println("inferiority to I.\"");
            System.out.println("Test failed. Returning to Backyard");
            System.out.println();

            //if they gave the wrong answer
            return;
        }

        //continue the quiz
        System.out.println("\"Of how highth importance isth the slumber of the night?\"");
        System.out.println("1. Not Important    2. Important    3. Very Important");
        userInput = myScan.nextLine();
        System.out.println();

        //check for correct answer
        if(!(userInput.equals("Very Important")||userInput.equals("very important")||userInput.equals("3"))){

            //inform user they were incorrect
            System.out.println("\"haHA!! I knewst such a lowly lifeform as thyself couldst not possibly passetheth ");
            System.out.println("the heights of intelligence such as I! But feareth not, for I amst most gracious, ");
            System.out.println("and shallth gievth thou as many chances as thou wishest to proveth thine ");
            System.out.println("inferiority to I.\"");
            System.out.println("Test failed. Returning to Backyard");
            System.out.println();

            //if they gave the wrong answer
            return;
        }

        //continue the quiz
        System.out.println("\"If thine chicken tryst to maul thee, isth that a good thingeth or a bad thingeth?\"");
        System.out.println("1. Good    2. Bad");
        userInput = myScan.nextLine();
        System.out.println();

        //check for correct answer
        if(!(userInput.equals("Bad")||userInput.equals("bad")||userInput.equals("2"))){

            //inform user they were incorrect
            System.out.println("\"haHA!! I knewst such a lowly lifeform as thyself couldst not possibly passetheth ");
            System.out.println("the heights of intelligence such as I! But feareth not, for I amst most gracious, ");
            System.out.println("and shallth gievth thou as many chances as thou wishest to proveth thine ");
            System.out.println("inferiority to I.\"");
            System.out.println("Test failed. Returning to Backyard");
            System.out.println();

            //if they gave the wrong answer
            return;
        }

        //continue the quiz
        System.out.println("\"What shouldst one do if thoust feathered cocks tryst to maul thee?\"");
        System.out.println("1. Kill Them    2. Let Them Live   3. Timeout");
        userInput = myScan.nextLine();
        System.out.println();

        //check for correct answer
        if(!(userInput.equals("Timeout")||userInput.equals("timeout")||userInput.equals("3"))){

            //inform user they were incorrect
            System.out.println("\"haHA!! I knewst such a lowly lifeform as thyself couldst not possibly passetheth ");
            System.out.println("the heights of intelligence such as I! But feareth not, for I amst most gracious, ");
            System.out.println("and shallth gievth thou as many chances as thou wishest to proveth thine ");
            System.out.println("inferiority to I.\"");
            System.out.println("Test failed. Returning to Backyard");
            System.out.println();

            //if they gave the wrong answer
            return;
        }

        System.out.println("\"HOW CAN THIS BE?? HOWDST THOU PASSETH MINE TEST WITH SUCH EASE?! Thou must’ve ");
        System.out.println("cheated!! Whereth is thine note card with the answers thoust possess?! Looked upst ");
        System.out.println("the answers perhapseth? Or hast thou peeketh at minest code?! Welleth then… i shallth ");
        System.out.println("stayst true to minest word and bestow upon thee: an egg. Do withdst it as thou pleaseth.\"");
        System.out.println();
        System.out.println("You obtained an egg");
        System.out.println();
        System.out.println("\033[3m... Do not bite that hand that feeds you, chicken.\033[0m");
        System.out.println();
        egg = true;
    }
}
