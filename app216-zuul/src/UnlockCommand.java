/**
 * The Class UnlockCommand handles the unlocking of the Filing Cabinet, and the final progress of the game, including
 * asking for the Filing Cabinet code and giving the Player the 'Records' item.
 *
 * @author Modified by Leighton Burgoyne
 * @version v1.0 05/01/2022
 */
public class UnlockCommand extends ZuulCommand
{
    String code; // Creates the 'code' String
    public Player player; // Player Object

    public UnlockCommand(Game zuul, String codeInput)
    {
        super(zuul);
        player = new Player(0,0,false); // Constructor for Player (it fixes the null errors)
        this.code = codeInput; // String Assignment
    }

    public void execute()
    {
        if (code.equals("CAB104")) // Input Detected & Successful Code Entered
        {
            player.addItemToInventory(ItemList.RECORDS); // Add Item to Inventory
            player.increaseScore(40); // Increase Player Score
            System.out.println(ConsoleColours.ANSI_GREEN + "SUCCESS: The Records have been found!"+ ConsoleColours.ANSI_RESET); // Display Confirmation Message
        }
        else // Input Detected & Incorrect Code Entered
        {
            System.out.println(ConsoleColours.ANSI_RED + "ERROR: The Code is incorrect, Security have been alerted to the tampering." + ConsoleColours.ANSI_RESET); // Display Error Message
            player.setBounty(100); // Sets Bounty to 100, so Player will lose game.
            player.gameLost = true; // Sets GameLost variable to true.
        }
    }
}
