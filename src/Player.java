import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Player {
    /* This class holds the information about the player, like the player's location.
     * The game method depend on where the player is located.
     * This class will need to link to all the other scenes, and acts as the navigation between scenes.
     * Scenes/Locations are defined by whether there are interactable options within the scene
     */

    //Create the objects to each class
    Bedroom bedroomScene = new Bedroom();
    Nightstand bedStand = new Nightstand();
    Wardrobe bedWardrobe = new Wardrobe();
    LivingRoom livRoom = new LivingRoom();
    UtilitiesRoom utilRoom = new UtilitiesRoom();
    Boxes utilBoxes = new Boxes();
    UnlockedBasement unlockPass = new UnlockedBasement();
    Backyard bckyrd = new Backyard();
    DiningRoom dineRoom = new DiningRoom();
    Garden eggQuest1 = new Garden();
    FenceGate eggQuest2 = new FenceGate();
    Lightswitch eggQuest3 = new Lightswitch();
    RabbitCage eggQuest4 = new RabbitCage();
    TimeUnit timer = TimeUnit.SECONDS;

    //Store where the player is located. Default value at the starting location
    String location = "Bedroom";

    /* Create the method for the game
     * Void method
     * No Parameters
     * While the game has not ended, repeatedly check where the player is. Depending on where the player is,
     * run the interactables method from that scene.
     * When the location is at an ending, end the while loop and check what ending was achieved, and print
     * that ending.
     */
    public void game(){

        //Print the Dream scene
        System.out.println();
        System.out.println("Today is the same as every other day. After I finish teaching my computer science ");
        System.out.println("class, I head outside to the chicken coop to get some eggs for an afternoon snack. ");
        System.out.println("I could hear buck-buck-bawk's and cluckings grow louder as I walked closer to the ");
        System.out.println("coop. The chickens seem a little louder today than normal...");
        System.out.println("\033[3mMaybe a coyote or fox wandered by last night and the chickens are all " +
                "panicky now.\033[0m");
        System.out.println("While my mind tries to find a solution, I hear a loud crashing sound. Pieces of ");
        System.out.println("plywood whirlwind around me as a giant chicken breaches through the top of the coop.");
        System.out.println("\033[3mWhat th--\033[0m");
        System.out.println("I turn to run back inside the house, but then I hear an even louder crashing sound. ");
        System.out.println("I look up to see a giant rabbit hop its way over to the giant chicken. The chicken, ");
        System.out.println("a battle-ready challenger, stomps toward the rabbit. They look like they're about to ");
        System.out.println("duel each other. It's like a scene from the movies, except...");
        System.out.println("\033[3mI'm in between them\033[0m");
        System.out.println("I try to run, but my stride length is nothing compared to the chicken's and the ");
        System.out.println("rabbit's. The rabbit makes one more jump, and I'm right where it's about to land. As ");
        System.out.println("I see its paw closing in on me, out of the corner of my eye I see something- an egg.");
        System.out.println();

        //introduce player to controls by having them wake up
        //create scanner object
        Scanner myScan = new Scanner(System.in);

        //inform user
        System.out.println("1. Wake Up");

        //receive user input
        String userInput = myScan.nextLine();
        System.out.println();

        //make sure the user understands that they have to type the exact option
        while(!userInput.equals("Wake Up")){

            //secret ending if the player choosese to remain asleep
            if(userInput.equals("Snooze") || userInput.equals("Sleep")){
                System.out.println("Instead of choosing to wake up like a normal person, which was literally the ");
                System.out.println("only option presented to you, you chose the only other possible choice: to ");
                System.out.println("continue sleeping. And thus, you continued to sleep... and sleep... and sleep");
                System.out.println("... forever... and ever...");

                //spam z's
                for(int i = 0; i < 25; i++){
                    for(int j = 0; j < 4; j++){
                        //delay between spam
                        try {
                            //delay in seconds
                            timer.sleep(4);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } //I HAVE NO CLUE WHAT A TRY CATCH IS BUT THAT IS WHAT THE IDE RECOMMENDED AND IT WORKS

                        //print z
                        System.out.println("zzzz");
                    }
                    System.out.println("four lines of z's... its kinda sexy....");
                }

                //end game
                return;
            }

            //Inform the user to try again
            System.out.println("Please input an option exactly as specified");

            //Scan again for new user input
            userInput = myScan.nextLine();
            System.out.println();
        }

        //Check to if the player has reached an ending
        while(!(location.equals("ChickenEnd") || location.equals("RabbitEnd") || location.equals("TrueEnd"))){

            //While they have not reached an ending, run the interactables method from the room they are in
            //Run the interactables from the Bedroom
            if(location.equals("Bedroom")){

                //Call the interactables method
                //Redefine the location using the method return
                location = bedroomScene.interactables();
            }

            //Call interactables from the Nightstand
            else if(location.equals("Nightstand")){

                //Call the interactables method
                //Redefine the location using the method return
                location = bedStand.interactables();
            }

            //Call interactables from the Wardrobe
            else if(location.equals("Wardrobe")){

                //call the interactables method
                //redefine the location using the method return
                location = bedWardrobe.interactables(utilBoxes.getKey());
            }

            //call interactables from the Living Room
            else if(location.equals("Living Room")){

                //call the interactables method
                //redefine the location using the method return
                location = livRoom.interactables(bedWardrobe.getPassageUnlocked());
            }

            //call interactables from the Utilities Room
            else if(location.equals("Utilities Room")){

                //call the interactables method
                //redefine the location using the method return
                location = utilRoom.interactables();
            }

            //call interactables method from the Boxes scene
            else if(location.equals("Inspect Boxes")){

                //call the interactables method
                //redefine the location using the method return
                location = utilBoxes.interactables();
            }

            //call interactables method from the Unlocked Basement scene
            else if(location.equals("Unlocked Passage")){

                //call the interactables method
                //redefine the location using the method return
                location = unlockPass.interactables(bedStand.getFlashlight(), eggQuest1.getEgg(), eggQuest2.getEgg(),
                        eggQuest3.getEgg(), eggQuest4.getEgg());
            }

            //call interactables method from the Backyard scene
            else if(location.equals("Backyard")){

                //call the interactables method
                //redefine the location using the method return
                location = bckyrd.interactables(dineRoom.rabbitInteraction, eggQuest3.getEgg(), eggQuest4.getEgg());
            }

            //call interactables method from the Dining Room scene
            else if(location.equals("Dining Room")){

                //call the interactables method
                //redefine the location using the method return
                location = dineRoom.interactables(bckyrd.chickenInteraction, eggQuest1.getEgg(), eggQuest2.getEgg());
            }

            //call the game from the Lightswitch scene
            else if(location.equals("Lightswitch")){

                //call the game
                eggQuest3.runGame();

                //reset player location back to dining room
                location = "Dining Room";
            }

            //call the game from the FenceGate scene
            else if(location.equals("Fence Gate")){

                //call the game
                eggQuest2.TTT();

                //reset location
                location = "Backyard";
            }

            //call the game from the Garden scene
            else if(location.equals("Garden")){

                //call the game
                eggQuest1.eggQuest();

                //reset location
                location = "Backyard";
            }

            //call the game from the RabbitCage
            else if(location.equals("Rabbit Cage")){

                //call the game
                eggQuest4.runGame();

                //reset location
                location = "Dining Room";
            }
        }

        //print the correct ending
        if(location.equals("TrueEnd")){

            //true end from basement
            System.out.println("Almost as soon as I step foot inside the new room, lights flick on from above. ");
            System.out.println("I look around my surroundings. The room looks like a school classroom, but the ");
            System.out.println("desks are arranged all in the center, like one large dining table. The table is ");
            System.out.println("loaded with food on top. There are eggs made with all kinds of methods, like ");
            System.out.println("hardboiled eggs, sunny-side-up eggs, scrambled eggs, omelets, etc. Seated at the ");
            System.out.println("table are… \033[3mmy APCS students???\033[0m");
            System.out.println("\"What are you all doing in here?\"");
            System.out.println("\"Oh, good morning Mrs. Carlson\"");
            System.out.println("Michael must not have gotten enough sleep again.");
            System.out.println("\"It’s the afternoon,\" Jonathan corrected");
            System.out.println("\"Haiya go to bed on time\" Edward chimed in. Rahil chuckles and joins in");
            System.out.println("\"Well, anyways, thanks Mrs. Carlson for teaching us computer science. We wanted ");
            System.out.println("to thank you by displaying what we learned in this computer science project we ");
            System.out.println("worked on together\"");
            System.out.println("Michael perks up again");
            System.out.println("\"oh yeah, we left something for you in the files. The README file is a little ");
            System.out.println("thank you note, and there’s a little bit of fun hidden in the folders. Here, ");
            System.out.println("this might help navigate you\"");
            System.out.println("He handed me a little slip of paper. It read, ");
            System.out.println("\033[3mThanks to your help, 0 students failed this class. Comp sci is our #1 ");
            System.out.println("favorite class, and we’re all going to get 5 on the AP exam. You're the #1 teacher ");
            System.out.println("to guide all of us students to success. Thank you again, Mrs. Carlson\033[0m");
        }

        //chicken ending
        else if(location.equals("ChickenEnd")){

        }

        //rabbit ending
        else{
            System.out.println("After I retrieve the 2 prized chicken eggs, I return to the living room. Rabbits. ");
            System.out.println("Rabbits are everywhere. But they're neatly lined up around the room, wearing ");
            System.out.println("leather vests and belts with an array of tools");
            System.out.println("\"Hoptastic work Mrs. C! I knew we could count on you- only a human of your exact ");
            System.out.println("specifications could have done this! You should be proud of yourself! Rabbits of ");
            System.out.println("liberty, hope, and easter soon-to-be, be proud too for we have triumphed in our ");
            System.out.println("endeavor to attain the highly marketable chicken egg!!\"");
            System.out.println("Normally, I would have silenced such an intruder, but talking rabbits and their ");
            System.out.println("artistic missions are a bit out of the ordinary. While Czar Hops continues to talk ");
            System.out.println("about hopes and dreams for the easter rabbits, I peruse the room- which for some ");
            System.out.println("strange reason, changes into the setting of a CCA classroom.");
            System.out.println("\033[3mIt's almost as if I went to an alternate universe. But why?\033[0m");
            System.out.println("It seems like they're throwing a party for me here. With Chicken eggs. It's ");
            System.out.println("absolutely the most amazing surprise I have been to. The hors' de touvere and eggs ");
            System.out.println("benedict are all absolutely awesome.");
        }
    }
}
