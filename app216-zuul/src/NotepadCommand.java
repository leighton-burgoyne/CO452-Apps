/**
 * The Class NotepadCommand shows the contents of the Notepad when executed, showing vital clues to the Player.
 *
 * @author Modified by Leighton Burgoyne
 * @version v1.0 05/01/2022
 */
public class NotepadCommand extends ZuulCommand
{
    public Player player; // Player Object
    public NotepadCommand(Game zuul)
    {
        super(zuul);
        player = new Player(0,0,false); // Constructor for Player (it fixes the null errors)
    }

    public void execute() {
        if (!player.inventory.contains(ItemList.NOTEPAD)) // If Player Inventory ArrayList contains Notepad
        {
            System.out.println("Notepad Contents:");
            System.out.println();
            System.out.println("You have found the Notepad, upon opening it you find the following useful information scrawled on the Back Page:");
            System.out.println();
            System.out.println("File \t \t \t \t Code");
            System.out.println("--------------------------------");
            System.out.println("Prisoner Records \t CAB104");
            System.out.println();
            System.out.println("You will require the code later on.");
            System.out.println();
            System.out.println("PS. Don't get caught or else!");
        }
        else // If Player Inventory ArrayList does not contain Notepad
        {
            System.out.println("You need a Notepad to use this Command!");
        }
    }
}
