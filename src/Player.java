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
        System.out.println("Dream sequence");

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
                boolean tempKeyVar = false;
                location = bedWardrobe.interactables(tempKeyVar);
            }
        }
    }
}
