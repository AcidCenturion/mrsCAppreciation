import java.util.Scanner;

public class Lightswitch {
    /* Demonminator's Egg Quest: Combat */

    //fields
    boolean egg = false;
    private int playerHitPoints;
    private int rabbitHitPoints;
    private int playerMana;
    private boolean playerCharge;
    private boolean playerDefend;
    private int playerDefenseTimer;
    private boolean enemyCharge;
    private boolean enemyLockedOn;
    Scanner myScan = new Scanner(System.in);
    String userInput;

    /* Method for accuracy
     * return boolean value
     * no parameters
     * randomize a number from 0-25
     * if the number is greater than 17, accuracy failed
     */
    public boolean accuracy(){

        //randomize a number between 0 and 25
        int randNum = (int) (Math.random()*26);

        //if the number was less than 17, then the attack hits
        return randNum <= 17;
    }

    /* Method that attempts a player attack
     * no return, change value of foes hp directly
     * no parameters
     * Player has four moves: Basic Attack, Block, Heal, Attack Boost
     */
    public void playerAttack(){

        //See what player wants to do
        System.out.println("What would you like to do?");
        System.out.println("1. Attack    2. Block (10 Mana)    3. Heal (10 Mana)    4. Attack Boost (10 Mana)" +
                "    5. Info");
        userInput = myScan.nextLine();
        System.out.println();

        //ensure that the input was one of the options
        while(!(userInput.equals("Attack") || (userInput.equals("Block")&&playerMana>=10)
                || (userInput.equals("Heal")&&playerMana>=10)
                || (userInput.equals("Attack Boost")&&playerMana>=10))){

            if(playerMana < 10){
                System.out.println("You're out of mana");
            }

            if(userInput.equals("Info")){
                System.out.println("You have " + playerHitPoints + " HP");
                System.out.println("You have " + playerMana + " Mana");
                System.out.println("Demonminator has " + rabbitHitPoints + " HP");
                System.out.println("Demonminator ATK: 999   DEF: 999");
                System.out.println("\033[3mYou won't find higher attack and defense anywhere else! Its a shame \033[0m");
                System.out.println("\033[3mthat those stats are completely meaningless in this combat \033[0m");
            }

            //Inform the user to try again
            System.out.println("Please input an option exactly as specified");

            //Scan again for new user input
            userInput = myScan.nextLine();
            System.out.println();
        }

        //determine what move was used
        if(userInput.equals("Attack")){

            //roll accuracy
            if(accuracy()){

                //if the attack was charged
                if(playerCharge){

                    //reduce opponent hp by an increased amount
                    rabbitHitPoints -= 12;
                    playerCharge = false;

                    System.out.println("You hit Demonminator for 12 damage");
                }

                //otherwise, reduce opponent hp by normal amount
                else{
                    //reduce opponent hp (normal amount)
                    rabbitHitPoints -= 5;

                    System.out.println("You hit Demonminator for 5 damage");
                }
            }

            //if accuracy rolls false
            else{

                //miss the attack
                System.out.println("Your attack missed!");
            }
        }
        else if(userInput.equals("Block")){

            //reduce damage from next incoming attack
            playerDefend = true;

            //set counter
            //counts to zero; blocks 3 attacks
            playerDefenseTimer = 2;

            //use 10 mana
            playerMana -= 10;

            System.out.println("You brace for incoming damage");
        }
        else if(userInput.equals("Heal")){

            //heal player 7 hit points
            playerHitPoints += 7;

            //use 10 mana
            playerMana -= 10;

            System.out.println("You heal 7 HP");
        }
        else{

            //charge player's next attack
            playerCharge = true;

            //use 10 mana
            playerMana -= 10;

            System.out.println("You charge your next attack");
        }
    }

    /* Method that attempts an enemy attack
     * no return, change value of foes hp directly
     * no parameters
     * Enemy has four moves: Basic Attack, strong Attack, Attack Boost, Lock on
     */
    public void enemyAttack(){

        //generate a random number between 0 and 3
        int randNum = (int) (Math.random()*4);

        //select move based off of generated number
        //basic attack
        if(randNum == 0){

            //roll for accuracy
            if(accuracy() || enemyLockedOn){

                //attack lands, deal damage. Check damage modifiers
                if(enemyCharge && !playerDefend){

                    //enemy charged and player not defended
                    playerHitPoints -= 12;

                    System.out.println("Demonminator readied a charged attack");
                    System.out.println("Demonminator hits you for 12 damage");
                }
                else if(enemyCharge){

                    //enemy charged and player defended
                    playerHitPoints -=6;

                    System.out.println("Demonminator readied a charged attack");
                    System.out.println("You braced for the hit");
                    System.out.println("Demonminator hits you for 6 damage");
                }
                else if(playerDefend){

                    //player defended and enemy not charged
                    playerHitPoints -= 2;

                    System.out.println("You braced for the hit");
                    System.out.println("Demonminator hits you for 2 damage");
                }
                else{

                    //normal damage
                    playerHitPoints -= 5;

                    System.out.println("Demonminator hits you for 5 damage");
                }

                //reset buffs if any
                enemyCharge = false;
                enemyLockedOn = false;
                if(playerDefenseTimer == 0 && playerDefend){
                    playerDefend = false;
                    System.out.println("Your defense buff wears out");
                }
                else{
                    playerDefenseTimer--;
                }
            }

            //missed accuracy check
            else{
                System.out.println("Demonminator missed!");
            }
        }

        //strong attack
        else if(randNum == 1) {

            //roll for accuracy twice for a greater miss chance
            if ((accuracy() && accuracy())||enemyLockedOn) {

                //attack lands, deal damage. Check damage modifiers
                if (enemyCharge && !playerDefend) {

                    //enemy charged and player not defended
                    playerHitPoints -= 25;

                    System.out.println("Demonminator readied a charged attack");
                    System.out.println("Demonminator hits you with a strong attack for 25 damage");
                } else if (enemyCharge) {

                    //enemy charged and player defended
                    playerHitPoints -= 14;

                    System.out.println("Demonminator readied a charged attack");
                    System.out.println("You braced for the hit");
                    System.out.println("Demonminator hits you with a strong attack for 14 damage");
                } else if (playerDefend) {

                    //player defended and enemy not charged
                    playerHitPoints -= 6;

                    System.out.println("You braced for the hit");
                    System.out.println("Demonminator hits you with a strong attack for 6 damage");
                } else {

                    //normal damage
                    playerHitPoints -= 10;

                    System.out.println("Demonminator hits you with a strong attack for 10 damage");
                }

                //reset buffs if any
                enemyCharge = false;
                enemyLockedOn = false;
                if(playerDefenseTimer == 0 && playerDefend){
                    playerDefend = false;
                    System.out.println("Your defense buff wears out");
                }
                else{
                    playerDefenseTimer--;
                }
            }

            //missed accuracy check
            else {
                System.out.println("Demonminator missed his strong attack!");
            }
        }

        //attack boost
        else if(randNum == 2){

            //if he was already charged
            if(enemyCharge){
                System.out.println("Demonminator stores his charge");
            }
            else{
                System.out.println("Demonminator charges energy for his next attack");
            }

            //buff enemy's next attack
            enemyCharge = true;
        }

        //Lock on
        else{

            //guarantee the next attack to land
            enemyLockedOn = true;

            System.out.println("Demonminator locks onto your movements");
        }
    }

    /* Simulates the fight
     * no return
     * no parameters
     * As long as they both have hp, run their attacks. If either of them runs out of hp, end the game
     * if the rabbit lost, update egg variable
     * if the player lost, give them the option to try again
     */
    public void runGame(){

        //initialize the game stats
        playerHitPoints = 35;
        rabbitHitPoints = 35;
        playerMana = 50;
        playerCharge = false;
        playerDefend = false;
        playerDefenseTimer = 0;
        enemyCharge = false;
        enemyLockedOn = false;

        System.out.println("Demonminator squares up");

        //while both characters have hp
        while(playerHitPoints > 0 && rabbitHitPoints > 0){

            //run both attacks
            playerAttack();
            enemyAttack();
        }

        //when someone runs out of hp
        if(playerHitPoints <= 0 && rabbitHitPoints <= 0){

            //ties because both characters take themselves out in the same round
            System.out.println();
            System.out.println("Demonminator fainted");
            System.out.println("You blacked out");
            System.out.println("Game draw");
        }
        else if(rabbitHitPoints <=0){
            System.out.println();
            System.out.println("Demonminator fainted");
            System.out.println("You won!");
            System.out.println("You obtained an egg");
            egg = true;
        }
        else{
            System.out.println();
            System.out.println("You blacked out");
            System.out.println("GAME OVER");
        }
        System.out.println();
    }
}