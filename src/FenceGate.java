import java.util.Scanner;

public class FenceGate {
    //field
    boolean egg = false;

    private Scanner input = new Scanner(System.in);
    private int botCol = 4;
    private int botCount = 0;
    private int botRow = 4;


    private Scanner input1 = new Scanner(System.in);
    private Scanner input2 = new Scanner(System.in);

    private int playerCol = 4;
    private int playerCount = 0;
    private int playerRow = 4;
    String[] playerMoves = {"P","4","4"};  //sign, col, row


    private String status = "null";
    private int spaceCount = 0;


    private String [][] board = new String[3][3];

    //other methods
    int askRow(){
        while(botCount == 0) {
            //subtract 1 to make sure index is correct in the nested array for gameboard
            botRow = input.nextInt() - 1;

        }
        return botRow;
    }

    int askCol(){
        while(botCount == 0) {
            //subtract 1 for index
            botCol = input.nextInt() - 1;

        }
        return botCol;
    }


    String[] askMoves(String playerName){
        playerMoves[0] = "X";
        while(playerCount == 0) {
            System.out.println(playerName + ", enter a number from 1-3 for row");
            //subtract 1 to make sure index is correct in the nested array for gameboard
            playerRow = input1.nextInt() - 1;
            if((playerRow < 0) || (playerRow > 3)){
                System.out.println("Invalid input."); //continue to loop until player inputs a valid coordinate number
            }
            else{
                break;
            }
        }
        while(playerCount == 0) {
            System.out.println("Enter a number from 1-3 for column");
            //subtract 1 for index
            playerCol = input2.nextInt() - 1;
            if((playerCol < 0) || (playerCol > 3)){
                System.out.println("Invalid input."); //continue to loop until player inputs a valid coordinate number
            }
            else{
                break;
            }
        }
        playerMoves[1] = Integer.toString(playerRow);
        playerMoves[2] = Integer.toString(playerCol);
        return playerMoves;
    }


    String gameStatus(String [][] board){ //comparison can be made for both players since wins can only be made after each respective player's turn
        //check for win
        for(int i = 0; i < 3; i++){
            if( ( (board[i][0].equals(board[i][1])) && (board[i][0].equals(board[i][2])) ) && (board[i][0].equals("X") || board[i][0].equals("O")) ){ //compare rows
                status = "win"; //set status var to win
            }
            if((board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) && (board[0][i].equals("X") || board[0][i].equals("O"))){ //compare columns
                status = "win"; //set status var to win
            }
            if((board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) && (board[2][2].equals("X") || board[2][2].equals("O"))){ //compare diagonals
                status = "win"; //set status var to win
            }
            if((board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) && (board[0][2].equals("X") || board[0][2].equals("O"))) { //compare diagonals
                status = "win"; //set status var to win
            }
        }
        //check for tie game
        spaceCount = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){ //loop through nested list to check if each index has either X or O
                if(board[i][j].equals("X") || board[i][j].equals("O"))
                    spaceCount++; //add 1 to var measuring how many spaces filled with either symbol
            }
        }
        if(spaceCount == 9){ //if all 9 spaces are filled, set status var to tie
            status = "tie";
        }
        return status;
    }


    String[][] getBoard(){
        return board;
    }

    String[][] makeGameboard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = "."; //set each index in nested list to . (default value when no symbols are assigned)
            }
        }
        return board;
    }

    void printGameboard(String [][] givenBoard){ //used to print out current status of the board
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(givenBoard[i][j] + " "); //print out board with nested loop
            }
            System.out.println();
        }
    }

    String[] botMoves(){  //only to block player
        String[]botMoves = {"O","2","2"};

        if(board[0][0].equals(board[0][1])&&board[0][2].equals(".")){  //first row  #3 empty
            botMoves[1]=Integer.toString(0);
            botMoves[2]=Integer.toString(2);
            return botMoves;  //set board[0][2] to O
        }else if(board[0][0].equals(board[0][2])&&board[0][1].equals(".")){  //first row  #2 empty
            botMoves[1]=Integer.toString(0);
            botMoves[2]=Integer.toString(1);
            return botMoves;  //set board[0][1] to O
        }else if(board[0][1].equals(board[0][2])&&board[0][0].equals(".")){  //first row  #1 empty
            botMoves[1]=Integer.toString(0);
            botMoves[2]=Integer.toString(0);
            return botMoves;  //set board[0][0] to O



        }else if(board[1][0].equals(board[1][1])&&board[1][2].equals(".")){  //second row  #3 empty
            botMoves[1]=Integer.toString(1);
            botMoves[2]=Integer.toString(2);
            return botMoves;  //set board[0][2] to O
        }else if(board[1][0].equals(board[1][2])&&board[1][1].equals(".")){  //second row  #2 empty
            botMoves[1]=Integer.toString(1);
            botMoves[2]=Integer.toString(1);
            return botMoves;  //set board[0][2] to O
        }else if(board[1][1].equals(board[1][2])&&board[1][0].equals(".")){  //second row  #1 empty
            botMoves[1]=Integer.toString(1);
            botMoves[2]=Integer.toString(0);
            return botMoves;  //set board[0][2] to O
        }


        else if(board[2][0].equals(board[2][1])&&board[2][2].equals(".")){  //third row  #3 empty
            botMoves[1]=Integer.toString(2);
            botMoves[2]=Integer.toString(2);
            return botMoves;  //set board[0][2] to O
        }else if(board[2][0].equals(board[2][2])&&board[2][1].equals(".")){  //third row  #2 empty
            botMoves[1]=Integer.toString(2);
            botMoves[2]=Integer.toString(1);
            return botMoves;  //set board[0][2] to O
        }else if(board[2][1].equals(board[2][2])&&board[2][0].equals(".")){  //third row  #1 empty
            botMoves[1]=Integer.toString(2);
            botMoves[2]=Integer.toString(0);
            return botMoves;  //set board[0][2] to O
        }


        else if(board[0][0].equals(board[1][0])&&board[2][0].equals(".")){  //first col  #3 empty
            botMoves[1]=Integer.toString(2);
            botMoves[2]=Integer.toString(0);
            return botMoves;  //set board[0][2] to O
        }else if(board[0][0].equals(board[2][0])&&board[1][0].equals(".")){  //first col  #2 empty
            botMoves[1]=Integer.toString(1);
            botMoves[2]=Integer.toString(0);
            return botMoves;  //set board[0][2] to O
        }else if(board[1][0].equals(board[2][0])&&board[0][0].equals(".")){  //first col  #1 empty
            botMoves[1]=Integer.toString(0);
            botMoves[2]=Integer.toString(0);
            return botMoves;  //set board[0][2] to O
        }


        else if(board[0][1].equals(board[1][1])&&board[2][1].equals(".")){  //second col  #3 empty
            botMoves[1]=Integer.toString(2);
            botMoves[2]=Integer.toString(1);
            return botMoves;  //set board[0][2] to O
        }else if(board[0][1].equals(board[2][1])&&board[1][1].equals(".")){  //second col  #2 empty
            botMoves[1]=Integer.toString(1);
            botMoves[2]=Integer.toString(1);
            return botMoves;  //set board[0][2] to O
        }else if(board[1][1].equals(board[2][1])&&board[0][1].equals(".")){  //second col  #1 empty
            botMoves[1]=Integer.toString(0);
            botMoves[2]=Integer.toString(1);
            return botMoves;  //set board[0][2] to O
        }


        else if(board[0][2].equals(board[1][2])&&board[2][2].equals(".")){  //third col  #3 empty
            botMoves[1]=Integer.toString(2);
            botMoves[2]=Integer.toString(2);
            return botMoves;  //set board[0][2] to O
        }else if(board[0][2].equals(board[2][2])&&board[1][2].equals(".")){  //third col  #2 empty
            botMoves[1]=Integer.toString(1);
            botMoves[2]=Integer.toString(2);
            return botMoves;  //set board[0][2] to O
        }else if(board[1][2].equals(board[2][2])&&board[0][2].equals(".")){  //third col  #1 empty
            botMoves[1]=Integer.toString(0);
            botMoves[2]=Integer.toString(2);
            return botMoves;  //set board[0][2] to O
        }


        else if(board[0][0].equals(board[1][1])&&board[2][2].equals(".")){  //left right diagonal  #3 empty
            botMoves[1]=Integer.toString(2);
            botMoves[2]=Integer.toString(2);
            return botMoves;  //set board[0][2] to O
        }else if(board[0][0].equals(board[2][2])&&board[1][1].equals(".")){  //left right diagonal  #2 empty
            botMoves[1]=Integer.toString(1);
            botMoves[2]=Integer.toString(1);
            return botMoves;  //set board[0][2] to O
        }else if(board[1][1].equals(board[2][2])&&board[0][0].equals(".")){  //left right diagonal  #1 empty
            botMoves[1]=Integer.toString(0);
            botMoves[2]=Integer.toString(0);
            return botMoves;  //set board[0][2] to O
        }


        else if(board[0][2].equals(board[1][1])&&board[2][0].equals(".")){  //right left diagonal  #3 empty
            botMoves[1]=Integer.toString(2);
            botMoves[2]=Integer.toString(0);
            return botMoves;  //set board[0][2] to O
        }else if(board[0][2].equals(board[2][0])&&board[1][1].equals(".")){  //right left diagonal  #2 empty
            botMoves[1]=Integer.toString(1);
            botMoves[2]=Integer.toString(1);
            return botMoves;  //set board[0][2] to O
        }else if(board[2][0].equals(board[1][1])&&board[0][2].equals(".")){  //right left diagonal  #1 empty
            botMoves[1]=Integer.toString(0);
            botMoves[2]=Integer.toString(2);
            return botMoves;  //set board[0][2] to O
        }


        else{
            for(int col = 0;col<2;col++){
                for(int row = 0;row<2;row++){
                    if(board[col][row].equals(".")){
                        botMoves[1]=Integer.toString(col);
                        botMoves[2]=Integer.toString(row);
                        return botMoves;  //set empty slot to O
                    }
                }
            }
        }
        return botMoves;

    }

    void addToBoard(String[]moves){
        if(board[Integer.parseInt(moves[1])][Integer.parseInt(moves[2])].equals("X") || board[Integer.parseInt(moves[1])][Integer.parseInt(moves[2])].equals("O")){ //check if board coordinates are taken
            System.out.println("\nBoard coordinates of this input were already taken. Your turn was invalid and skipped.\n"); //user cannot take over a used space; turn is skipped
        }
        else{
            board[Integer.parseInt(moves[1])][Integer.parseInt(moves[2])] = moves[0]; //if board coordinates are not taken, assign corresponding symbol to board
        }


    }


    //run the game
    public void TTT(){

        //reset game state
        botCol = 4;
        botCount = 0;
        botRow = 4;
        playerCol = 4;
        playerCount = 0;
        playerRow = 4;
        String[] playerMoves = {"P","4","4"};  //sign, col, row
        status = "null";
        spaceCount = 0;
        board = new String[3][3];

        //introduce the game with bun bun
        System.out.println("game details");


        printGameboard(makeGameboard());

        //loop until win or tie occurs
        System.out.println("You are \"X\"");
        for(int i = 1; i <= 10; i++) {
            addToBoard(askMoves("Player 1"));
            //game.printGameboard(game.getBoard());
            if((gameStatus(getBoard())).equals("win")){
                System.out.println("\nYou win.");
                printGameboard(getBoard());

                //reward egg
                System.out.println();
                System.out.println("You obtained an egg");
                System.out.println();
                egg = true;

                break;
            }
            if((gameStatus(getBoard())).equals("tie")){
                System.out.println("\nTie Game.");
                printGameboard(getBoard());

                break;
            }

            addToBoard(botMoves());
            printGameboard(getBoard());
            if((gameStatus(getBoard())).equals("win")){
                System.out.println("\nChuck wins.");
                printGameboard(getBoard());

                break;
            }
        }
        //README
        /*
        TicTacToe class:
        keeps looping until there is a win or tie game
        1. Asks player 1 for board coordinates
        2. Prints out current game board
        3. Checks if player 1 made a three in a row, breaks loop if win
        4. Checks for a tie game (all spaces on the board are filled) breaks loop if tied
        5. Asks player 2 for board coordinates
        6. Prints out current game board
        7. Checks if player 2 made a three in a row, breaks loop if win

        Gameboard class:
        makes board with nested list
        prints board
        adds symbols to board using user input
        turn is invalid if user inputs coordinates that are already taken (turn is skipped)

        AskPlayer class:
        asks player for board coordinates (col = column number, row = row number)
        keeps asking player for number if input is invalid
        returns input for row
        return input for column

        DidIWin class:
        check if either player wins, or if there is a tie
        status variable indicates a win or tie, and "null" if nothing happens, then returns value to main
        how the for loop (to check win) works:
        HORIZONTAL three in a row:
        checks if each space in row "i" is equal
        VERTICAL three in a row:
        checks if each space in column "i" is equal
        DIAGONAL three in a row:
        compares center value with other symbols that form a diagonal with it
         */

        //Updated README
        /*
        I'm trying to keep every scene in one class, so I conjoined all the classes together. I copied and pasted all
        the variables and methods, making the main method into the TTT method which is called from the Player class.
        I added variables for the eggs and print statements for the setting.
         */
    }
}
