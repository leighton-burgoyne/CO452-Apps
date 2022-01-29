import java.util.Timer;
import java.util.TimerTask;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended
 *  to make it more interesting!
 *
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  locations, creates the CommandReader and starts the game.  
 * 
 * @author  Michael Kölling and David J. Barnes (1.0), Leighton Burgoyne (2.0)
 * @version 29/02/2016 (1.0), 30/12/2021 (2.0)
 *
 */

public class Game
{
    public Map MAP; // Reference to Map
    private CommandReader reader; // Reference to CommandReader
    public boolean gameOver; // Reference to gameOver
    public Player player; // Reference to Player

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        MAP = new Map(); // Create Map Instance
        player = new Player(0,0,false); // Create Player Instance
        reader = new CommandReader(this); // Create Reader Instance
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play()
    {
        Timer bountyTimer = new Timer(); // Bounty Timer
        bountyTimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                player.increaseBounty(20); // Increase Bounty by 20 every 1 Minute.
            }
        }, 60000, 60000); // 60000ms = 1 Minute
        printWelcome();
        gameOver = false;

        // Enter the main command loop. Here we repeatedly read commands and execute them until the game is over.

        while (!gameOver) // Game is not Over
        {
            System.out.println(player.printStats()); // Print the Statistics (Bounty and Score) continuously.
            gameOver = reader.getCommand();

            if(player.inventory.contains(ItemList.RECORDS)) // If Records are on the Player
            {
                printSuccess(); // Show Success Message
                gameOver = true;
            }
            else if(player.bounty == 100) // If Bounty is Max (100)
            {
               printFail(); // Show Fail Message
               gameOver = true;
            }
        }
        System.out.println("Game Over. Thank you for playing WatchDogs: Zuul Edition (BBC Mission).");
    }

    /**
     * Print out the Welcome Message for the Player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println(ConsoleColours.ANSI_BG_BLACK + " INTRO: " + ConsoleColours.ANSI_RESET);
        System.out.println("Welcome to WatchDogs: Zuul Edition, this is a text-based adventure game based on the Zuul Game Concept and inspired by WatchDogs.");
        System.out.println("The BBC Team are due to release a documentary on Crime in Britain, due to be released in Summer 2022, however they are lacking certain information and statistics. ");
        System.out.println("Your mission (if you choose to accept it) is to break into HMP Burnley and locate a range of items in different locations within the Map.");
        System.out.println("You will then be able to use these items to gain entry to the Archive Room and unlock the correct Filing Cabinet and steal a range of Prisoner Records for the BBC to use.");
        System.out.println("Your Bounty will go up by 20 every minute, meaning you have exactly 5 minutes to retrieve the Records before you are caught by Security!");
        System.out.println(ConsoleColours.ANSI_RED + "WHAT ARE YOU PLAYING AT? GO FIND THOSE RECORDS BEFORE YOUR TIME RUNS OUT!" + ConsoleColours.ANSI_RESET);
        printInstructions();
        System.out.println(MAP.getCurrentLocation().getLongDescription());
    }

    /**
     * Print out the Instructions Message for the Player.
     */
    public void printInstructions()
    {
        System.out.println();
        System.out.println(ConsoleColours.ANSI_BG_BLACK +" HOW TO PLAY: " + ConsoleColours.ANSI_RESET);
        System.out.println("Type 'go <direction>' to move either North, East, South, or West into another Location, a list of exit directions will be shown.");
        System.out.println("Type 'take <item>' in order to collect an Item from a Location, this will place it in your inventory for you to use.");
        System.out.println("Type 'notepad' to output the contents of the Notepad Item to the Terminal for you to read and obtain information.");
        System.out.println("Type 'inventory' to output the contents of your Inventory to the Terminal for you to read and obtain information.");
        System.out.println("Type 'unlock' to unlock any furniture within a Location, such as the Filing Cabinets. You will be prompted for a code.");
        System.out.println("Type 'help' if you require help at any point during the game, and the Help Menu will be displayed.");
        System.out.println("Type 'quit' to end the game at any time.");
        System.out.println();
    }
    private void printSuccess()
    {
        System.out.println(ConsoleColours.ANSI_GREEN + " SUCCESS: Mission Passed! " + ConsoleColours.ANSI_RESET);
        System.out.println("Congratulations Comrade! \n The BBC are extremely pleased with the Records and they congratulate you for passing the game!");
    }
    private void printFail()
    {
        System.out.println(ConsoleColours.ANSI_RED + " FAILED: Mission Failed! " + ConsoleColours.ANSI_RESET);
        System.out.println("Your Bounty Level has now reached 100. \n You've been caught by Security and the Police have been called. \n Unlucky! Good try though, and better luck next time!");
    }

}