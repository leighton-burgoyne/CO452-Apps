
/**
 * This command allows the player to take or pickup an item from a room and carry it around to use somewhere else
 *
 * @author Derek Peacock & Nicholas Day (1.0). Modified by Leighton Burgoyne (2.0)
 * @version 23/08/2021 (1.0), 05/01/2022 (2.0)
 */
public class TakeCommand extends ZuulCommand
{
    String item;

    /**
     * Take an item from a location and add it
     * to the player's inventory.
     */
    public TakeCommand(Game zuul, String itemInput)
    {
        super(zuul);
        item = itemInput; // String Assignment
    }    

    public void execute()
    {
        Player player = zuul.player;  // Player Object via Zuul
        Map map = zuul.MAP;  // Map Object via Zuul
        Location currentLocation = map.getCurrentLocation();  // Specifies Current Location as the result of map.getCurrentLocation() function
        ItemList selectedItem = currentLocation.getItem(item); // Specifies Selected Item as the Item(s) assigned to the Player's Current Location

        if(item == null) // No Input
        {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }

        if (selectedItem != null) // Input Detected & Successful Item Found
        {
            player.addItemToInventory(selectedItem); // Add Item to Inventory (currently not working)
            player.increaseScore(20); // Increase Player Score
            System.out.println(ConsoleColours.ANSI_GREEN + "SUCCESS: The following Item has been taken: " + this.item + ConsoleColours.ANSI_RESET); // Display Confirmation Message
        }
        else // Input Detected & No Item Found
        {
            System.out.println(ConsoleColours.ANSI_RED + "ERROR: The following Item does not exist: " + this.item + ConsoleColours.ANSI_RESET); // Display Error Message
        }
    }
}
